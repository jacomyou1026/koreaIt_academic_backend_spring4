package com.korea.vs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired //자동주입 : 스프링에서 제공하는 클래스에 대해 자동으로 객체를 만들어주는 기능
	//이 기능을 사용하려면 servlet-context.xml에 <context:annotation-config/>속성을 추가해둬야 한다
	HttpServletRequest request; //Autowired를 통해 자동으로 객체생성이 된다
	
	
	@Autowired
	ServletContext application; //현재프로젝트의  정보를 저장하고 있는 클래스
	
	static final String WEB_PATH = "/WEB-INF/views/visit/";
	
	//앞으로 비지트 컨트롤러에서 호출할 dao객체를 생성
	VisitDAO visit_dao;
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}

	//방명록 전체조회
	@RequestMapping( value= {"/", "/list.do"} )
	public String list( Model model ) {
		
		//방명록 조회
		List<VisitVO> list = visit_dao.selectList();
		
		//바인딩
		model.addAttribute("list", list);
		//포워딩
		return WEB_PATH + "visit_list.jsp";
	}
	
	//새글 작성을 위한 폼 띄우기
	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return WEB_PATH + "visit_insert_form.jsp";
	}
	
	//새글 작성
	@RequestMapping("/insert.do")
	public String insert( VisitVO vo ) {
		//insert.do?name=홍길동&content=내용&pwd=1111
		//파라미터로 VisitVO를 준비해둠으로써, insert.do에서 넘어온 name, content, pwd를 vo가 한번에 저장한다
		
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		//파일 업로드를 위한 절대경러 지정
		String webPath = "/resources/upload/";
		String savePath = application.getRealPath(webPath);
		System.out.println(savePath);

		//파라미터로 넘어온 파일의 정보
		MultipartFile photo = vo.getPhoto();
		
		String filename="no_file";
		
		//수신된 photo가 존재한다면 (비어있지 않다면)
		if(!photo.isEmpty()) {
			filename= photo.getOriginalFilename(); //업로드된 실제 파일명
			
			//파일을 저장할 경로를 생성
			File saveFile = new File(savePath,filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();//없는 경로 (upload/파일명) 생성
			}else {
				//업로드 시도 시, 동일한 이름의 파일이 존재할 경우 업로드 시간을 붙여서 중복을 방지
			//currentTimeMillis() : 1970/1/1 ~ 현재까지의 경과시간을 1/1000단위로 저장하고 있는 메서드
				long time  =System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename);
			}
			
			try {
				//saveFile이 가지고 있는 경로에 실제로 파일을 업로드
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		vo.setFilename(filename);
		
		//vo가 가진 정보를 DB에 insert
		visit_dao.insert(vo);
		
		//새 글 추가 완료후 첫 페이지(list.do)로 돌아가자!!
		//return "list.do"; <- 안되는 코드
		//response.sendRedirect("/list.do"); <-- 안되는코드
		return "redirect:list.do";
	}
	
	//글 삭제
	@RequestMapping("/delete.do")
	@ResponseBody //<-- 해당 어노테이션이 적용되어 있는경우 return값을 콜백메서드로 보낸다
	public String delete( int idx ) {
		//delete.do?idx=5
		
		int res = visit_dao.delete( idx );
		
		String str = "no";//삭제실패시 사용할 값
		
		if( res == 1 ) {
			str = "yes";//삭제성공시 사용할 값
		}
		
		//스프링은 return된 값을 기본적으로 jsp나 html등의 view형태로 인지하기 때문에
		//view형태로 인지하지 말고 그대로 콜백메서드로 값을 전달하도록 해야한다
		return str;
		
	}
	
	//글 수정 페이지로 전환
	@RequestMapping("/modify_form.do")
	public String modify_form(Model model, int idx) {
		//idx에 해당하는 게시글의 정보를 vo에 담아서 가져온다
		VisitVO vo = visit_dao.selectOne(idx);
		
		//가져온 vo를 바인딩
		model.addAttribute("vo", vo);
		
		//포워딩		
		return WEB_PATH + "visit_modify_form.jsp";
	}
	
	//글 수정
	@RequestMapping("/modify.do")
	public String modify(VisitVO vo) {
		//modify.do?idx=3&name=이길동&content=asdf132&pwd=1111
				
		String ip = request.getRemoteAddr();//ip
		vo.setIp(ip);
		
		//vo를 DB를 통해 update하기
		visit_dao.update(vo);
		
		//수정 완료 후 list.do로 복귀
		return "redirect:list.do";
	}
	
}
























