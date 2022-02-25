package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeliveryVO;
import vo.UserVO;

public class UserDAO{
	
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

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
	 
	 //회원정보 수정
	 public int adjust(UserVO vo) {
		int res = sqlSession.update("u.user_update", vo);
			
		return res;
	 }
	 
	 //비밀번호 변경
	 public int adjust_pwd(UserVO vo) {
		int res = sqlSession.update("u.user_adjust", vo);
			
		return res;
	 }

	 //회원탈퇴
	 public int delete(String id) {
			int res = sqlSession.delete("u.delete", id);
			
			return res;
		}
		 
		
		//카카오페이 적립
		public int insert_pay(UserVO vo) {
			
			int res= sqlSession.update("u.updateMoney", vo);
			System.out.println(res+"일");
			return res;
				
		}
		
		//유저목록
		 public List<DeliveryVO> selectdelivery(String id){
				List<DeliveryVO> list = sqlSession.selectList("u.Delivery",id);
				
				return list;
			}
		
		
		
		
}
