package com.spring.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.utils.UploadFileUtils;

import dao.ReviewDAO;
import vo.BookVO;

import service.BookService;
import vo.CategoryVO;
import vo.PageCreator;
import vo.PageVO;
import vo.SearchVO;
	
@Controller
public class ListController {

	BookService service;
	ReviewDAO review_dao;
	
	//이미지 테스트용
	@Resource(name="uploadPath")
	private String uploadPath;
	
	static final String WEB_PATH = "/WEB-INF/views/";
	
	
	public void setService(BookService service) {
		this.service = service;
	}
	
	public void setReview_dao(ReviewDAO review_dao) {
		this.review_dao = review_dao;
	}
	
	//국내 도서 리스트
	@RequestMapping(value = "/bookList1", method = RequestMethod.GET)
	public String bookList1(PageVO paging, @RequestParam("c") int categoryNum,@RequestParam("t") int tier,Model model) throws Exception{

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
			
			  return WEB_PATH +"bookList1.jsp";
			
			
	}


	
	// 외국 도서 리스트
	@RequestMapping(value = "/bookList2", method = RequestMethod.GET)
	public String bookList2(PageVO paging, @RequestParam("c") int categoryNum,@RequestParam("t") int tier,Model model) throws Exception{


			
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
			
			  return WEB_PATH +"bookList2.jsp";
			
			
	}

	// 검색리스트
	@RequestMapping(value = "/bookListSearch", method = RequestMethod.GET)
	public String bookListSearch(SearchVO searchPaging,Model model) throws Exception{

		List<BookVO> list = service.ListAll(searchPaging);
		model.addAttribute("list", list);


		PageCreator pc = new PageCreator();
		pc.setPaging(searchPaging);
		pc.setTotalCount(service.CountAll(searchPaging));
		model.addAttribute("pc", pc);
		System.out.println(pc);
			
		
		  return WEB_PATH +"bookListSearch.jsp";		
			
			
	}
	
	// 신간 도서
	@RequestMapping(value = "/bookListNew", method = RequestMethod.GET)
	public String bookListNew(SearchVO searchPaging,Model model) throws Exception{

		List<BookVO> list = service.ListAll(searchPaging);
		model.addAttribute("list", list);

		System.out.println("리스트 내용은 : " + list);
		PageCreator pc = new PageCreator();
		pc.setPaging(searchPaging);
		pc.setTotalCount(service.CountAll(searchPaging));
		model.addAttribute("pc", pc);
		System.out.println(pc);
			
		
		  return WEB_PATH +"bookListNew.jsp";
			
			
	}	// 베스트셀러
	@RequestMapping(value = "/bookListBest", method = RequestMethod.GET)
	public String bookListBest(SearchVO searchPaging,Model model) throws Exception{

		List<BookVO> list = service.ListAll(searchPaging);
		model.addAttribute("list", list);

		System.out.println("리스트 내용은 : " + list);
		PageCreator pc = new PageCreator();
		pc.setPaging(searchPaging);
		pc.setTotalCount(service.CountAll(searchPaging));
		model.addAttribute("pc", pc);
		System.out.println(pc);
			
		
		  return WEB_PATH +"bookListBest.jsp";
			
			
	}
	
	//메인화면
	@RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
	public String bookListSearchMain(SearchVO searchPaging,Model model) throws Exception{

		List<BookVO> list = service.ListAll(searchPaging);
		model.addAttribute("list", list);


		PageCreator pc = new PageCreator();
		pc.setPaging(searchPaging);
		pc.setTotalCount(service.CountAll(searchPaging));
		model.addAttribute("pc", pc);
		System.out.println(pc);
			
		
		  return WEB_PATH +"main.jsp";			
			
			
	}


	// 샘플 데이터 삽입
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String register(Model model) throws Exception {
		ObjectMapper objm = new ObjectMapper();
		List<CategoryVO> list = service.cateList();
		String cateList = objm.writeValueAsString(list);
		model.addAttribute("cateList", cateList);
		  return WEB_PATH +"insert.jsp";
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
