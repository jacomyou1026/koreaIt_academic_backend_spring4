package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.UserVO;


public class UserDAOImpl{
	
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	public int insert(UserVO vo) throws Exception{
		return sqlSession.insert("userMapper.user_insert", vo);
	}

	
	public UserVO selectOne(String id) throws Exception{
		return sqlSession.selectOne("userMapper.user_login", id);
	}

	
	public List<UserVO> selectList(String name, String email, String tel) throws Exception{
		return sqlSession.selectList("userMapper.user_list");
	}

	
	public UserVO selectOne_search(String name) throws Exception{
		return sqlSession.selectOne("userMapper.user_search", name); 
	}
	

	
}
