package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.WorkServiceImpl;

@Controller
public class WorkController {
		WorkServiceImpl serviceBean;
		
		 public WorkController() {
			// TODO Auto-generated constructor stub
		}
		
		public void setServiceBean(WorkServiceImpl serviceBean) {
			this.serviceBean = serviceBean;
			System.out.println("항하하하하");
		}
		
		@RequestMapping("/list.do")
		public String list(Model model) {
			List<String> list = serviceBean.selectList();
			System.out.println("Dfd");
			model.addAttribute("list",list);
			return "work_list";
		}
		
}
