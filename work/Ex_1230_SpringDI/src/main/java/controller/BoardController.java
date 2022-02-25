package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImpl;


//@(어노테이션: 프로그래밍 주석)
//@override -> 프로그램이 오버라이딩 메서드임을 빠르게 캐치하고 정보를 제공하도록 하는 꼬리표
//@Controller ->특수한 기능으로써 동작하도록 하기 위한 용도의 꼬리표

@Controller //스프링으로 하여금 해당 클래스가 컨트롤러임을 인식시키기 위해 어노테이션이 '반드시'필요
public class BoardController {
	
	// root-context.xml은 controller를 제외한 모든 객체를 생성할 수 있다.
	BoardServiceImpl serviceBean;
	
	public BoardController() {
		System.out.println("--BoardController의 생성자--");
	}
	
	public void setServiceBean(BoardServiceImpl serviceBean) {
		this.serviceBean = serviceBean;
		System.out.println("--컨트롤러의 setter--");
	}
	
	//사용자가 요청한 urlMapping을 받을 메서드
	//@RequestMapping 어노테이션을 통해 매핑을 지정해둬야 한다.
	@RequestMapping("/list.do")
	public String list(Model model) {
		//Model객체는 스프링에서 바인딩을 담당하는 객체
		
		//list.do가 요청되면 실행되는 메서드
		List<String> list =  serviceBean.select();
		System.out.println("size: "+list.size());
		
		//list를 바인딩
		//jsp구조 : request.setAttribute("list",list);
		
		//spring
		model.addAttribute("list",list);
		
		//바인딩 된 데이터를 포워딩
		return "board_list";
	}
}	
