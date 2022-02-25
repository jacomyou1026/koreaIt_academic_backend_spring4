package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.GogekVO;

public class GogekDAO {
	
	// 생성자 인젝션 (constructor injection method)
	SqlSession sqlSession;
	
	public GogekDAO(SqlSession sqlSession) {
		// TODO Auto-generated constructor stub
		this.sqlSession = sqlSession;
	}
	
	
	//고객목록 출력
	public List<GogekVO> selectOne(){
		
		GogekVO list = sqlSession.selectOne("gogek.gogek_list");
		// sqlSession.close(); <- 스프링 에서는 DB 사용 이후에 sqlSession 을 자동으로 닫아준다
		return list;
		
	}
}