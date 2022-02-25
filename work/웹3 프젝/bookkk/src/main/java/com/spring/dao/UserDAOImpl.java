package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(UserVO vo) throws Exception{
		return sqlSession.insert("userMapper.user_insert", vo);
	}

	@Override
	public UserVO selectOne(String id) throws Exception{
		return sqlSession.selectOne("userMapper.user_login", id);
	}

	@Override
	public List<UserVO> selectList(String name, String email, String tel) throws Exception{
		return sqlSession.selectList("userMapper.user_list");
	}

	@Override
	public UserVO selectOne_search(String name) throws Exception{
		return sqlSession.selectOne("userMapper.user_search", name); 
	}
	

}
