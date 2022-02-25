package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import vo.BookVO;

import vo.CategoryVO;
import vo.PageVO;
import vo.SearchVO;


public class BookDAO {    
	
	private SqlSession sql;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sql = sqlSession;
	}

	
	public List<BookVO> list_2(int categoryNum ,PageVO paging) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("categoryNum", categoryNum);
		 map.put("paging", paging);
		return sql.selectList("listMapper.list_2",map);
	}

	//1차분류
	public List<BookVO> list_1(int cateParent,PageVO paging) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("cateParent", cateParent);
		 map.put("paging", paging);
		return  sql.selectList("listMapper.list_1" , map);
	}





	
	public List<BookVO> listIncountry(PageVO paging) {
		return sql.selectList("listMapper.listIncountry", paging);
}


	public List<BookVO> listOutcountry(PageVO paging) {
		return sql.selectList("listMapper.listOutcountry", paging);
	}
	
	
	
	



	

	public int IncountryCount(PageVO paging) throws Exception {
		return sql.selectOne("listMapper.IncountryCount",paging);
	}

	
	public int OutcountryCount(PageVO paging) throws Exception {
		return sql.selectOne("listMapper.OutcountryCount",paging);
	}

	
	public int primaryClassification(int cateParent,PageVO paging) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("cateParent", cateParent);
		 map.put("paging", paging);
		return sql.selectOne("listMapper.primaryClassification",map);
	}

	
	public int secondaryClassification(int categoryNum,PageVO paging) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("categoryNum", categoryNum);
		 map.put("paging", paging);
		return sql.selectOne("listMapper.secondaryClassification",map);
	}

	
	public int CountAll(SearchVO searchPaging) throws Exception {
		return sql.selectOne("listMapper.CountAll",searchPaging);
	}

	
	public List<BookVO> ListAll(SearchVO searchPaging) throws Exception {
		return sql.selectList("listMapper.ListAll", searchPaging);
	}

	
	public void bookEnroll(BookVO book) {
		sql.insert("listMapper.bookEnroll", book);
	}


	public List<CategoryVO> cateList() {
		return sql.selectList("listMapper.cateList");
	}

	
	//책 상세정보 조회
	public BookVO selectListOne(Integer num){
		BookVO vo = sql.selectOne("book.book_list",num);

		return vo;
	}
	
	public List<BookVO> selectlist() {
		List<BookVO> list= sql.selectList("book.book_list2");
		return list;

	}
	

}
