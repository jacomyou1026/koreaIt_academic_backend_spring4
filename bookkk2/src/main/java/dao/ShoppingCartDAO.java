package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.OrderVO;
import vo.ShoppingCartVO;

public class ShoppingCartDAO {
	SqlSession sqlSession; 
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	////shoppoing_Car+&book table
	public List<OrderVO> selectlist(String id) {
		List<OrderVO> list= sqlSession.selectList("shopping.list2", id);
		
		return list;

	}
	
	public List<OrderVO> priceselect() {
		List<OrderVO> list= sqlSession.selectList("shopping.priceselect");
		
		return list;
		
	}
	
	
	//책 수량 변경
	public int updateCnt(OrderVO vo) {
		int res= sqlSession.update("shopping.updateCnt",vo);
		
		return res;
		
	}
	
	
	//총 주문 개수 
	public int Carttotalcnt() {
		int cnt= sqlSession.selectOne("shopping.Carttotalcnt");
		return cnt;
	}
	
	
	//체크박스 삭제
	public int checkdel(int idx) {
		int li  = sqlSession.delete("shopping.checkdel",idx);
		System.out.println("체크박스 삭제"+li);
		return li;
	}
	
	//삭제하나
	public int delOne(int shopnum) {
		int delOne= sqlSession.delete("shopping.delOne",shopnum);
		System.out.println("삭제1"+delOne);
		return delOne;
	}
	
	
	//출고 날짜
	public List<String>regSelect() {
		List<String> relase =sqlSession.selectList("shopping.releaseBook");
		return relase; 
					
		}
	
	//바로구매(구매1) / 주문하기
	public int payone(OrderVO vo) {
		int payone= sqlSession.insert("shopping.payone",vo);
		return payone;
		
	}
	
	
//	
//	
//	//주문하기
//	public int goOrder(OrderVO ord) {
//		int goOrder= sqlSession.insert("shopping.goOrder",ord);
//		return goOrder;
//		
//	}
//	
	
	
	//장바구니에 담기
		public int insert(ShoppingCartVO vo) {
			int res = sqlSession.insert("shopping.insert_basket",vo);
			return res;
			
		}
		
		
		
		
	

}
