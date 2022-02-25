package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BookDAO;
import com.spring.vo.BookVO;
import com.spring.vo.CategoryVO;
import com.spring.vo.PageVO;
import com.spring.vo.SearchVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO dao;


	 


	@Override
	public List<BookVO> list(int categoryNum, int tier ,PageVO paging) throws Exception {
	 
	 int cateParent = 0;

	 
	 if (tier == 1) {
		if( categoryNum >= 100000 && categoryNum < 200000 )
			return dao.listIncountry(paging);
		if(categoryNum >= 200000 && categoryNum < 300000)
			 return dao.listOutcountry(paging);
	 }
	 if(tier == 2) {  
	  
		 cateParent = categoryNum;
	  return dao.list_1(cateParent,paging);
	 
	  
	 }  else {  
	  
	  return dao.list_2(categoryNum,paging);
	  
	 }

	}

	



	@Override
	public int Count(int categoryNum, int tier, PageVO paging) throws Exception {
		 int cateParent = 0;

		 
		 if (tier == 1) {
			if( categoryNum >= 100000 && categoryNum < 200000 )
				return dao.IncountryCount(paging);
			 if(categoryNum >= 200000 && categoryNum < 300000)
				 return dao.OutcountryCount(paging);
		 }
		 if(tier == 2) {  
		  
			 cateParent = categoryNum;
		  return dao.primaryClassification(cateParent,paging);
		 
		  
		 }  else {  
		  
		  return dao.secondaryClassification(categoryNum,paging);
		  
		 }

		}





	@Override
	public int CountAll(SearchVO searchPaging) throws Exception {
		return dao.CountAll(searchPaging);
	}





	@Override
	public List<BookVO> ListAll(SearchVO searchPaging) throws Exception {
		return dao.ListAll(searchPaging);
	}





	@Override
	public void bookEnroll(BookVO book) {
		dao.bookEnroll(book);
	}





	@Override
	public List<CategoryVO> cateList() {
		return dao.cateList();
	}










	
}
