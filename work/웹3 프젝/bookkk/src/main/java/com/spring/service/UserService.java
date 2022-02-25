package com.spring.service;

import java.util.List;

import com.spring.vo.UserVO;

public interface UserService {
	//회원가입
	public int insert(UserVO vo) throws Exception;
	//로그인
	public UserVO selectOne(String id) throws Exception;
	 //유저목록
	public List<UserVO> selectList(String name, String email, String tel) throws Exception;
	 //아이디 찾기, 회원가입 유무
	public UserVO selectOne_search(String name) throws Exception;
}
