package service;

import java.util.List;

import vo.BookVO;
import vo.CategoryVO;
import vo.PageVO;
import vo.SearchVO;

public interface BookService {

	//게시물 리스트
	public List<BookVO> list(int categoryNum, int tier ,PageVO paging) throws Exception;	
	

	// 게시물 총 갯수
	public int Count(int categoryNum, int tier ,PageVO paging) throws Exception;
	

	
	
	
	// 전체 책 개수
	public int CountAll(SearchVO searchPaging) throws Exception;
	// 전체 책 리스트
	public List<BookVO> ListAll(SearchVO searchPaging) throws Exception;
	
	// 테스트용 책등록
	public void bookEnroll(BookVO book);
	
	//테스트용 리스트
	public List<CategoryVO> cateList();
	
	
}
