package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {

	SqlSession sqlSession;
	
	// setsqlsession + ctrl + space = 자동생성
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("----DEPTDAO의 SETTER ------");
	}
	
	// 부서테이블 조회
	public List<DeptVO> selectList() {
		
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		// sqlSession.close(); <- 스프링 에서는 DB 사용 이후에 sqlSession 을 자동으로 닫아준다
		return list;
		
	}	
}
