package com.korea.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {

	@RequestMapping(value= {"/", "/list.do"})
	public String list() {
		return "/WEB-INF/views/start.jsp";
	}
	
}
