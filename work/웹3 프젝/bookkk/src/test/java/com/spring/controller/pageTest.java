package com.spring.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.BookDAO;
import com.spring.service.BookService;
import com.spring.vo.BookVO;
import com.spring.vo.SearchVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class pageTest {

	@Autowired
	BookDAO dao;
	
	@Autowired
	BookService service;
	
	@Test 
	public void getGoodsListTest2() {
		SearchVO search = new SearchVO();
		String subject = "T";
		String keyword = "테스트";			// 테이블에 등록된 책 제목 데이터
		//String keyword = "없음";				// 테이블에 등록되지 않은 데이터
		String catecode = "";	
		
		search.setKeyword("한국");
		
		List<BookVO> list = dao.listIncountry(search);
		
		System.out.println("search : " + search);
		System.out.println("list : " + list);
		
	}

}
