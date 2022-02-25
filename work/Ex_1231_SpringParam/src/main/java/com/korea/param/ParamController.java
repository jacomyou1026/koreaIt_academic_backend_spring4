package com.korea.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.PersonVO;

@Controller
public class ParamController {
	public static final String VIEW_PATH ="/WEB-INF/views/person/";
	
	
	@RequestMapping(value= {"/","/insert_form.do"})
	public String insertForm() {
		return VIEW_PATH+"insert_form.jsp"; 
	}
	
	//넘어온 파라미터와 받는 순서 같아야함 , 이름또한 같아야함
	@RequestMapping("/insert1.do")
	public String insert1(Model model,String name,int age, String tel) {
		//insert1.do?name =홍길동&age=20&tel=010-111-1111
		
		PersonVO vo =new PersonVO();
		vo.setName(name); //홍길동
		vo.setAge(age);//20
		vo.setTel(tel);//010-111-1111
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH+"result.jsp";
	}
	
	@RequestMapping("/insert2.do")
	public String insert_2(Model model, PersonVO vo) {
		
		//insert2.do?name =홍길동&age=20&tel=010-111-1111
		//파라미터로 넘어온 name,age,tel과 vo에 변수이름이 일치하는 setter를 통해
		//자동으로 값을 넣어준다.
		model.addAttribute("vo", vo);
		return VIEW_PATH+"result.jsp";
		
		//insert_2(Model model, PersonVO vo,String name)
		//위와같이 vo에 이미 존재하는 변수를 파라미터로 또 받으면 실행 시 오류발생
	}
	
}
