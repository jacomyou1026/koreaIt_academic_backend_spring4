package my_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.GogekDAO;
import vo.GogekVO;

@Controller
public class GogekController {

	GogekDAO gogek_dao;
	public void setGogek_dao(GogekDAO gogek_dao) {
		this.gogek_dao = gogek_dao;
	}
	
	@RequestMapping("/gogek_list.do")
	public String list(Model model) {
		// DAO 로 부터 부서목록을 요청 
		
		GogekVO list = gogek_dao.selectList;
		model.addAttribute("list", list);
		return "WEB-INF/views/gogek/gogek_list.jsp";
	}
	
}
