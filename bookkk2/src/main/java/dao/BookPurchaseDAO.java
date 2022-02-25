package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.BookPurchaseVO;
import vo.DeliveryVO;
import vo.OrderVO;
import vo.updateUserVO;

public class BookPurchaseDAO {
	SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//	book table +  table (join) +구매
	public List<OrderVO> selectlist(String id) {
		List<OrderVO> list= sqlSession.selectList("parchase.order_list",id);
		
		return list;

	}
	
//	book table +  +purchase table(join)
	public List<OrderVO> purchaselist(String id) {
		List<OrderVO> list= sqlSession.selectList("parchase.purchaselist",id);
		
		return list;
		
	}
	
	
	//totalprice
	public int totalPrice(String id) {
		int totalprice= sqlSession.selectOne("parchase.totalPrice",id);
		
		return totalprice;

	}
	
	

	
	//purchase 테이븍바로구매-구매
	public int inserpurchase(OrderVO vo) {
		int inserpurchase= sqlSession.insert("parchase.inserpurchase",vo);
		return inserpurchase;
	}
	
	//purchase 주소
	public int updatedelivery(updateUserVO vo) {
		int updatedelivery= sqlSession.insert("parchase.updatedelivery",vo);
		return updatedelivery;
	}
	
	
	//장바구니 삭제
	public int delshoppingCart(int shopnum) {
		int delshoppingCart= sqlSession.insert("parchase.delshoppingCart",shopnum);
		return delshoppingCart;
	}
	
	
	
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//출고 날짜
	public List<String>regSelect() {
		List<String> relase =sqlSession.selectList("parchase.releaseBook");
		return relase; 
				
	}
	

	//총 합(책 전체)
	public int totalpriceSelect() {
		int  totalprice = sqlSession.selectOne("parchase.totalprice");
		return totalprice;
	}
	
	
	//총 주문 개수 
	public int totalcnt() {
		int cnt= sqlSession.selectOne("parchase.totalcnt");
		return cnt;
	}
	
	//최종 결제 금액(배송비 제외)--추가예정
	public int finalprice() {
		int cnt= sqlSession.selectOne("parchase.finalprice");
		System.out.println(cnt+"cnt");
		return cnt;
	}
	
	//적립
	public int savepoint() {
		int savepoint = sqlSession.selectOne("parchase.savepoint");
		return savepoint ;
	}
	
	//변경된 배송지 추가
	public int insertdelivery(DeliveryVO vo) {
		int delivery = sqlSession.insert("parchase.isnertdelivery",vo);
		return delivery;
	}
	
	//배송지 변경된 것이지 구분
	public int updatedeliverysep() {
		int updateDeliveryNum = sqlSession.update("parchase.updatedeliverysep");
		return updateDeliveryNum;
	}
	
	//기존배송지와 이외 배송지 구분을 초기화
	public int initdeliverysep() {
		int initdeliverysep = sqlSession.update("parchase.initdeliverysep");
		return initdeliverysep;
	}
	
	//적립
	public int UpdateShoppingPoing(int savePoint) {
		int UpdateShoppingPoing = sqlSession.update("parchase.UpdateShoppingPoing",savePoint);
		return UpdateShoppingPoing;
	}
	
	//money_update
	public int UpdateMoney(int update_money) {
		int UpdateMoney = sqlSession.update("parchase.UpdateMoney",update_money);
		return UpdateMoney;
	}
	
	//바로구매 1개 구매
	public OrderVO bookone(OrderVO vo) {
		OrderVO bookone= sqlSession.selectOne("parchase.bookone",vo);
		return bookone;
	}
	
	
	//장바구니로 이동시 purchasetable 삭제
	public int delgoshoppurchse(OrderVO vo) {
		System.out.println(vo.getId()+"shoping id");
		int delgoshoppurchse= sqlSession.delete("parchase.delgoshoppurchse",vo);
		
		return delgoshoppurchse;
	}
	
	
}
