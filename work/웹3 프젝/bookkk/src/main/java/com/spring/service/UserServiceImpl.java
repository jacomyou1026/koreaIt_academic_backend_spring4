package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDAO;
import com.spring.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO dao;

	@Override
	public int insert(UserVO vo) throws Exception{
		return dao.insert(vo);
	}

	@Override
	public UserVO selectOne(String id) throws Exception{
		return dao.selectOne(id);
	}

	@Override
	public List<UserVO> selectList(String name, String email, String tel)throws Exception {
		return dao.selectList(name, email, tel);
	}

	@Override
	public UserVO selectOne_search(String name) throws Exception{
		return dao.selectOne_search(name);
	}
	
	
}
