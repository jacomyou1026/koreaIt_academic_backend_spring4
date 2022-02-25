package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.service.UserService;
import com.spring.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	@Autowired
	HttpServletRequest request;
	HttpServletRequest response;
	
	
	//약관
	@RequestMapping("new_head.do")
	public String new_form1(){		
		return "new_head";
	}
	
	//회원가입전 아이디 유뮤
	@RequestMapping("new_check.do")
	public String new_form2(){
		return "new_check";
	}
	
	//회원가입창
	@RequestMapping("new.do")
	public String new_form3(){
		return "new2";
	}
	
	@RequestMapping("insert.do")
	public String insert(Model model, UserVO vo) throws Exception{
		//vo가 가진 정보를 DB에 insert
		int res =userservice.insert(vo);
		if(res == 1) {
			model.addAttribute("msg", "회원가입이 완료 되었습니다.");
		}else{
			model.addAttribute("msg", "회원가입실패");
		}
		return "include_user/redirect2";
	}
	
	//로그인창
	@RequestMapping("login_form.do")
	public String login_form() {
		return "login_form";
	}
	
	//로그인
		@RequestMapping("login.do")
		@ResponseBody
		public String login(String id, String pwd)throws Exception {
			 UserVO vo = userservice.selectOne(id);
			 String str = "no";
			 
			 if(vo == null) {
				 return str;
			 }
			//아이디 체크
			 if(id.equals(vo.getId()) && pwd.equals(vo.getPwd())){ //아이디, 비밀번호를 체크
				 System.out.println("값이일치!!");
				 str = "yes";
			 }
			 System.out.println("db 아이디:"+vo.getId());
			 System.out.println("입력 아이디: "+id);
			 System.out.println("db 패스워드:" +vo.getPwd());
			 System.out.println("입력 패스워드:"+pwd);
			  
			  //아이디와 비밀번호 체크에 문제가 없다면 vo객체를
			  //어디서든 사용가능하도록 sessionScope영역에 저장.
					 HttpSession session = request.getSession(); // 세션영역을 가져온다
					 session.setAttribute("id",id);
					 session.setAttribute("point", vo.getShop_point());
					 session.setAttribute("money", vo.getMoney());
			 //세션유지시간(기본값 30분)
//				  response.sendRedirect("main.jsp");
					 session.setMaxInactiveInterval(60 * 60);//세션 유지시간을 1시간으로 설정
			  
			  return str; 
	  }
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logout() {
		return "include_user/logout";
	}
	
	//아이디 찾기_이동
	@RequestMapping("search_id.do")
	public String id_form() {
		return "search/search_id";
	}
	
	//아이디 찾기
  @RequestMapping("id.do")
  public String search_id(Model model, String name, String email, String tel) throws Exception{ 
	  UserVO vo = userservice.selectOne_search(name);
	  model.addAttribute("msg", "이름, 이메일, 전화번를 올바르게 입력하세요"); 
	  model.addAttribute("url","search_id.do"); 
	
	  if(vo == null) {
		  return "include_user/redirect";
	  }

	 String tel_ch = vo.getTel1() + vo.getTel2() + vo.getTel3();
	  if(vo.getEmail().equals(email) && tel_ch.equals(tel)) {
		  model.addAttribute("vo", vo);
		  return "search/user_id";
	  }
	  
	  return "include_user/redirect";
  }

	 
	//비밀번호 찾기_이동
	@RequestMapping("search_pwd.do")
	public String pwd_form() {
		return "search/search_pwd";
	} 
	
	//비밀번호 찾기
  @RequestMapping("pwd.do")
  public String search_pwd(Model model, String id, String name, String tel) throws Exception{ 
	  UserVO vo = userservice.selectOne_search(name);
	  model.addAttribute("msg", "아이디, 이름, 전화번를 올바르게 입력하세요"); 
	  model.addAttribute("url","search/search_pwd.do"); 
	
	  if(vo == null) {
		  return "include_user/redirect";
	  }

	 String tel_ch = vo.getTel1() + vo.getTel2() + vo.getTel3();
	  if(vo.getId().equals(id) && tel_ch.equals(tel)) {
		  model.addAttribute("vo", vo);
		  return "search/user_pwd";
	  }
	  
	  return "include_user/redirect";
  }
  
  
  //회원가입전 가입유무 검사
  	@RequestMapping("check.do")
	@ResponseBody
	public String check(String name, String tel) throws Exception{
		 UserVO vo = userservice.selectOne_search(name);
		 String str = "yes";
		 
		 if(vo == null) {
			 return str;
		 }
		 String tel_ch = vo.getTel1() + vo.getTel2() + vo.getTel3();
		//이름 체크
		 if(tel.equals(tel_ch) || name.equals(vo.getName())){ //전화번호를 체크
			 str = "no";
		 }

		  HttpSession session = request.getSession(); // 세션영역을 가져온다
		  session.setAttribute("name", name);
		  session.setAttribute("tel", tel);

		  session.setMaxInactiveInterval(60 * 60);//세션 유지시간을 1시간으로 설정
		  
		  return str; 
}
  
  
	
	
	
	
}
