package my_controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller		// 컨트롤러에는 반드시 Controller 어노테이션 (@) 이 필요하다
public class DeptController {
	
	DeptDAO dept_dao;	// DAO 정보를 갖고 있어야, dao 으로 부터 뭔가를 조회하거나 추가하거나 삭제하는 메서드를 호출할 수 있다
	// dept_dao(controller) 에게 비어있는 메모리에게 할당을 해야한다
	
	// servlet-context.xml 에서 생성자 인젝션을 통해 
	// context-3 에서 만든 DAO 를 참조
	public DeptController(DeptDAO dept_dao) {	// DeptDAO dept_dao 를 입력 받겠다 (외부에서 전달 받는다)
		// TODO Auto-generated constructor stub
		this.dept_dao=dept_dao;	// 주소를 넘겨줘야
		System.out.println("DEPTCONTROLLER CONSTRUCTOR 생성자");
	}
	
	// 부서 목록을 조회하는 매핑 지정
	@RequestMapping(value = {"/", "/list.do"} )	// 빈 값을 받거나, list.do 값을 입력받았을 때는 밑에 있는 메서드를 알아서 호출 해줘
	public String list(Model model) {		
		
		// DAO 로 부터 부서목록을 요청 
		
		List<DeptVO> list = dept_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "WEB-INF/views/dept/dept_list.jsp";
		
	}
}
