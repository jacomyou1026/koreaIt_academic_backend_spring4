package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDAO;
import vo.BookVO;      
import vo.CategoryVO;
import vo.PageVO;
import vo.SearchVO;
 
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO dao;

	public BookServiceImpl(BookDAO book_dao) {
		this.dao = book_dao;
	}
	 


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
		List<BookVO> list = dao.ListAll(searchPaging);	
		
		//2주 이내 신규글 new마크 처리 로직
		for(BookVO book : list) {
			//현재 시간 읽어오기
			long now = System.currentTimeMillis();//밀리초로 읽기 15억... * 1000초  
			//각 게시물들의 작성 시간 밀리초로 읽어오기
			long regTime = book.getPublishDate().getTime();  
			    
			if(now - regTime < 60 * 60 * 24 * 1000 * 14) {
				book.setNewMark(true);
			}
		}
		
		return list;
		

	
	
	
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
