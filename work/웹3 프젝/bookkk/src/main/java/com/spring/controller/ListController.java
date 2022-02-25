package com.spring.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.service.BookService;
import com.spring.utils.UploadFileUtils;
import com.spring.vo.BookVO;
import com.spring.vo.CategoryVO;
import com.spring.vo.PageCreator;
import com.spring.vo.PageVO;
import com.spring.vo.SearchVO;
	
@Controller
public class ListController {

	@Autowired
	BookService service;
	
	//이미지 테스트용
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	//국내 도서 리스트
	@RequestMapping(value = "/bookList1", method = RequestMethod.GET)
	public void bookList1(PageVO paging, @RequestParam("c") int categoryNum,@RequestParam("t") int tier,Model model) throws Exception{


			
			if(tier==1) {
			List<BookVO> list = service.list(categoryNum,tier,paging);
			model.addAttribute("list", list);


			PageCreator pc = new PageCreator();
			pc.setPaging(paging);
			pc.setTotalCount(service.Count(categoryNum, tier, paging));
			model.addAttribute("pc", pc);
			System.out.println(pc);
			
			}
			
			if(tier==2) {
			List<BookVO> list = service.list(categoryNum,tier,paging);
			model.addAttribute("list", list);


			PageCreator pc = new PageCreator();
			pc.setPaging(paging);
			pc.setTotalCount(service.Count(categoryNum, tier, paging));
			model.addAttribute("pc", pc);
			System.out.println(pc);
			
			}

			if(tier==3) {
			List<BookVO> list = service.list(categoryNum,tier,paging);
			model.addAttribute("list", list);


			PageCreator pc = new PageCreator();
			pc.setPaging(paging);
			pc.setTotalCount(service.Count(categoryNum, tier, paging));
			model.addAttribute("pc", pc);
			System.out.println(pc);
			
			}
			
			
			
			
	}


	
	// 외국 도서 리스트
	@RequestMapping(value = "/bookList2", method = RequestMethod.GET)
	public void bookList2(PageVO paging, @RequestParam("c") int categoryNum,@RequestParam("t") int tier,Model model) throws Exception{


			
			if(tier==1) {
			List<BookVO> list = service.list(categoryNum,tier,paging);
			model.addAttribute("list", list);


			PageCreator pc = new PageCreator();
			pc.setPaging(paging);
			pc.setTotalCount(service.Count(categoryNum, tier, paging));
			model.addAttribute("pc", pc);
			System.out.println(pc);
			
			}
			
			if(tier==2) {
			List<BookVO> list = service.list(categoryNum,tier,paging);
			model.addAttribute("list", list);


			PageCreator pc = new PageCreator();
			pc.setPaging(paging);
			pc.setTotalCount(service.Count(categoryNum, tier, paging));
			model.addAttribute("pc", pc);
			System.out.println(pc);
			
			}

			if(tier==3) {
			List<BookVO> list = service.list(categoryNum,tier,paging);
			model.addAttribute("list", list);


			PageCreator pc = new PageCreator();
			pc.setPaging(paging);
			pc.setTotalCount(service.Count(categoryNum, tier, paging));
			model.addAttribute("pc", pc);
			System.out.println(pc);
			
			}
			
			
			
			
	}

	// 검색리스트
	@RequestMapping(value = "/bookListSearch", method = RequestMethod.GET)
	public void bookListSearch(SearchVO searchPaging,Model model) throws Exception{

		List<BookVO> list = service.ListAll(searchPaging);
		model.addAttribute("list", list);


		PageCreator pc = new PageCreator();
		pc.setPaging(searchPaging);
		pc.setTotalCount(service.CountAll(searchPaging));
		model.addAttribute("pc", pc);
		System.out.println(pc);
			
		
			
			
			
	}
	
	//메인화면
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void bookListSearchMain(SearchVO searchPaging,Model model) throws Exception{

		List<BookVO> list = service.ListAll(searchPaging);
		model.addAttribute("list", list);


		PageCreator pc = new PageCreator();
		pc.setPaging(searchPaging);
		pc.setTotalCount(service.CountAll(searchPaging));
		model.addAttribute("pc", pc);
		System.out.println(pc);
			
		
			
			
			
	}


	// 샘플 데이터 삽입
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void register(Model model) throws Exception {
		ObjectMapper objm = new ObjectMapper();
		List<CategoryVO> list = service.cateList();
		String cateList = objm.writeValueAsString(list);
		model.addAttribute("cateList", cateList);
	}
	
	//샘플 데이터 삽입
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String register(BookVO book, RedirectAttributes rttr,MultipartFile file)  throws Exception{
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		book.setImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		
		
		service.bookEnroll(book);
		
		rttr.addFlashAttribute("enroll_result", book.getSubject());
		
		return "redirect:/main";
	}		
		
	
	
	
	
	
	
	
	
	
	
	
}
