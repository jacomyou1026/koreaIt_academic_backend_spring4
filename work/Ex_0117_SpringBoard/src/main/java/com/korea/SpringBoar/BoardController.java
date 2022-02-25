package com.korea.SpringBoar;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BoardDAO;
import util.Common;
import util.Paging;
import vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	HttpServletRequest request;

	BoardDAO board_dao;

	public void setBoard_dao(BoardDAO board_dao) {
		this.board_dao = board_dao;
	}

	// 게시판 전체보기
	@RequestMapping(value = { "/", "/list.do" })
	public String list(String page, Model model) {
		// list.do <--- null
		// list.do?page= <--empty

		int nowPage = 1; // 기본페이지는 1페이지

		if (page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}

		// 한페이지에 보여줄 게시물의 시작번호와 끝번호를 계산
		// 1page는 1~5번 게시물까지 보여줘야 함
		// 2page 는 6~10

		int start = (nowPage - 1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;

		// 페이지별 목록 가져오기

		// 전체 게시물 수 구하기
		int row_total = board_dao.rowTotal();

		// 하단부에 추가될 페이지 메뉴 생성
		String pageMenu = Paging.getPaging("list.do", // 호출되는 페이지url
				nowPage, // 현재 페이지 번호
				row_total, // 전체 게시물 수
				Common.Board.BLOCKLIST, // 한페이지에 몇개 보여줄지
				Common.Board.BLOCKPAGE);

		List<BoardVO> list = board_dao.select(start, end);

		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);// 하단 페이지 메뉴 바인딩
		// 세션에 저장해둔 a라는 키값을 제거
		HttpSession session = request.getSession();
		session.removeAttribute("a");

		return Common.Board.View_path + "list.jsp";

	}

	@RequestMapping("write.do")
	public String write_form() {
		return Common.Board.View_path + "board_write.jsp";
	}

	// 게시글 상세보기
	@RequestMapping("view.do")
	public String view_form(Model model, int idx) {
//		<a href="view.do?idx=${vo.idx }">

		// idx에 해당하는 게시글 한 건 얻어오
		BoardVO list = board_dao.selectOne(idx);

		// 조회수 증가
		// 세션에 값을 저장하여 조회수가 한번에 하나만 증가되도록 처리
		HttpSession session = request.getSession();
		String show = (String) session.getAttribute("a");
		if (show == null) {
			board_dao.update_readhit(idx);
			session.setAttribute("a", "");
		}

		// 바인딩
		model.addAttribute("list", list);

		return Common.Board.View_path + "view.jsp";

	}

	// 새 글 추가
	@RequestMapping("insert.do")
	public String insert(BoardVO vo) {
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		board_dao.Insret(vo);
		
		return "redirect:list.do";
		
		
	}
	
	//글 삭제
	@RequestMapping("/del.do")
	@ResponseBody //결과값을 jsp등의 view구조가 아닌 json이나 데이터 형태로 콜백메서드로 돌려주기 위한 키워드
	public String delete(int idx) {
		
		BoardVO baseVO = board_dao.selectOne(idx);
		
		baseVO.setSubject("이미 삭제된 게시글입니다.");
		baseVO.setName(" ");
		
		//제목과 작성자가 변경된 baseVO를 DB에 업데이트
		int res = board_dao.del_update(baseVO);
		
		return ""+res;
		
	}
	
	@RequestMapping("/reply_form.do")
	public String reply() {
		return Common.Board.View_path+"board_reply.jsp";
	}
	
	//댓글쓰기
	@RequestMapping("/reply.do")
	public String reply(BoardVO vo, String page) {
		String ip = request.getRemoteAddr();
		//댓글을 달고자하는 기준글의 idx를 사용하여 정보를 얻어온다.
		BoardVO baseVO = board_dao.selectOne(vo.getIdx());
		
		//기준글의 step보다 큰 값을 가진 step들을 +1처리
		board_dao.update_step(baseVO);
		
		//댓글vo
		vo.setIp(ip);
		
		vo.setRef(baseVO.getRef());
		vo.setStep(baseVO.getStep()+1);
		vo.setDepth(baseVO.getDepth()+1);
		
		//댓글 등록
		board_dao.reply(vo);
		
	
		//reply.do?
		//reply.do?page=
		
		//int myPage = 1;
		
//		if(page!=null&&!page.isEmpty()) {
//			myPage = Integer.parseInt(page);
//		}
//		
		
		return "redirect:list.do?page="+page;
		
	}

}
