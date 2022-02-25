package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.vo.BookVO;
import com.spring.vo.CategoryVO;
import com.spring.vo.PageVO;
import com.spring.vo.SearchVO;

@Repository
public class BookDAOImpl implements BookDAO{
	
	@Autowired
	private SqlSession sql;

	@Override
	public List<BookVO> list_2(int categoryNum ,PageVO paging) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("categoryNum", categoryNum);
		 map.put("paging", paging);
		return sql.selectList("listMapper.list_2",map);
	}

	//1차분류
	@Override
	public List<BookVO> list_1(int cateParent,PageVO paging) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("cateParent", cateParent);
		 map.put("paging", paging);
		return  sql.selectList("listMapper.list_1" , map);
	}





	@Override
	public List<BookVO> listIncountry(PageVO paging) {
		return sql.selectList("listMapper.listIncountry", paging);
}


	@Override
	public List<BookVO> listOutcountry(PageVO paging) {
		return sql.selectList("listMapper.listOutcountry", paging);
	}
	
	
	
	



	
	@Override
	public int IncountryCount(PageVO paging) throws Exception {
		return sql.selectOne("listMapper.IncountryCount",paging);
	}

	@Override
	public int OutcountryCount(PageVO paging) throws Exception {
		return sql.selectOne("listMapper.OutcountryCount",paging);
	}

	@Override
	public int primaryClassification(int cateParent,PageVO paging) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("cateParent", cateParent);
		 map.put("paging", paging);
		return sql.selectOne("listMapper.primaryClassification",map);
	}

	@Override
	public int secondaryClassification(int categoryNum,PageVO paging) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("categoryNum", categoryNum);
		 map.put("paging", paging);
		return sql.selectOne("listMapper.secondaryClassification",map);
	}

	@Override
	public int CountAll(SearchVO searchPaging) throws Exception {
		return sql.selectOne("listMapper.CountAll",searchPaging);
	}

	@Override
	public List<BookVO> ListAll(SearchVO searchPaging) throws Exception {
		return sql.selectList("listMapper.ListAll", searchPaging);
	}

	@Override
	public void bookEnroll(BookVO book) {
		sql.insert("listMapper.bookEnroll", book);
	}

	@Override
	public List<CategoryVO> cateList() {
		return sql.selectList("listMapper.cateList");
	}


	
	
	
	

	
	
	
}
