package Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.WorkService;

@Controller
public class WorkController {
	WorkService serviceBean;
	
	public void setServiceBean(WorkService serviceBean) {
		this.serviceBean = serviceBean;
		System.out.println("나는 컨트롤러");
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		List<String> list = serviceBean.selectList();
		model.addAttribute("list", list);
		return "work_list";
	}
}
