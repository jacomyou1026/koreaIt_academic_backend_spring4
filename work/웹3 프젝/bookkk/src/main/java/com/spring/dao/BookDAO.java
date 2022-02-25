package com.spring.dao;

import java.util.List;

import com.spring.vo.BookVO;
import com.spring.vo.CategoryVO;
import com.spring.vo.PageVO;
import com.spring.vo.SearchVO;

public interface BookDAO {

	
	
	
	//국외도서 리스트
	public List<BookVO> listOutcountry(PageVO paging);
	//외국도서 리스트
	public List<BookVO> listIncountry(PageVO paging);
	// 1차분류 리스트	
	public List<BookVO> list_1(int cateParent,PageVO paging);
	//2차분류 리스트
	public List<BookVO> list_2(int categoryNum,PageVO paging);	
	

	
	
	
	
	
	// 국내 도서 총갯수
	public int IncountryCount(PageVO paging) throws Exception ;
	// 외국 도서 총갯수
	public int OutcountryCount(PageVO paging) throws Exception ;
	// 1차분류 도서 총갯수
	public int primaryClassification(int cateParent,PageVO paging) throws Exception;
	// 2차분류 도서 총갯수
	public int secondaryClassification(int categoryNum ,PageVO paging) throws Exception;
	
	
	// 전체 책 갯수
	public int CountAll(SearchVO searchPaging) throws Exception;
	// 전체 책 리스트
	public List<BookVO> ListAll(SearchVO searchPaging) throws Exception;
	
	
	
	// 테스트용 상품등록
	public void bookEnroll(BookVO book);
	// 테스트용 카테고리 리스트
	public List<CategoryVO> cateList();
	
}
