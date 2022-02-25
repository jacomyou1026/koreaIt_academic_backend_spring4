package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.UserVO;

public class UserDAO {

	static SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/*
	 * public UserVO selectOne(){ UserVO one = sqlSession.selectOne("u.user_list");
	 * return one;
	 * 
	 * }
	 */
	
	public static int insert_pay(int amount) {
		int res= sqlSession.update("u.updateMoney", amount);
		System.out.println(res);
		return res;
			
	}
	
	
	
	
//login part
	public int insert(UserVO vo) {
		int res = sqlSession.insert("u.user_insert", vo);
		return res;
	}
	
	//로그인	
	 public UserVO selectOne(String id) { 
		 UserVO vo = sqlSession.selectOne("u.user_login", id); 
		 
		 return vo; 
	 }
	 
	 //유저목록
	 public List<UserVO> selectList(String name, String email, String tel){
			List<UserVO> list = sqlSession.selectList("u.user_list");
			
			return list;
		}
	 
	 //아이디 찾기, 회원가입 유무
	 public UserVO selectOne_search(String name) { 
		 UserVO vo = sqlSession.selectOne("u.user_search", name); 
		 
		 return vo; 
	 }


}













