package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.UserDAOImpl;
import vo.UserVO;

@Service
public class UserServiceImpl implements UserService{

	UserDAOImpl dao;
	public UserServiceImpl(UserDAOImpl user_dao) {
		this.dao=user_dao;
	}

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
