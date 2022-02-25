package com.korea.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	//실행 경로를 지정할 상수
	public static final String VIEW_PATH ="/WEB-INF/views/test/";
	
	
	public TestController() {
		System.out.println("--TEstcontroller의 생성자--");
	}
	
	//url매핑 호출
	@RequestMapping("/test.do")
	public String Test(Model model,HttpServletRequest request) {
		String ip = request.getRemoteAddr(); // ip 
		String[] fruite = {"사과","배","오렌지","딸기"};
		
		//model객체를 통해 바인딩
		model.addAttribute("fruite", fruite);
		
		//model.addAttribute("ip", ip);
		request.setAttribute("ip", ip);
		
		return VIEW_PATH+"test.jsp";
	}
}
