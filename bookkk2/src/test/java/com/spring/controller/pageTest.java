package com.spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.BookDAO;
import service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class pageTest {

	@Autowired
	BookDAO dao;
	
	@Autowired
	BookService service;
	
	@Test 
	public void getGoodsListTest2() {
		
		
	}

}
