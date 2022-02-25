package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.BookDAO;
import dao.BookPurchaseDAO;
import dao.UserDAO;
import vo.BookVO;
import vo.OrderPageDTO;
import vo.OrderVO;
import vo.UserVO;
import vo.updateUserVO;

@Controller
public class OrderController {
	@Autowired // 자동주입 : 스프링에서 제공하는 클래스에 대해 자동으로 객체를 만들어주는 기능
	// 이 기능을 사용하려면 servlet-context.xml에 <context:annotation-config/>속성을 추가해둬야 한다
	HttpServletRequest request; // Autowired를 통해 자동으로 객체생성이 된다
	@Autowired
	HttpSession session;

	@Autowired
	ServletContext application; // 현재프로젝트의 정보를 저장하고 있는 클래스

	static final String WEB_PATH = "/WEB-INF/views/shop&purchase/";

	UserDAO user_dao;

	public void setUser_dao(UserDAO user_dao) {
		this.user_dao = user_dao;
	}

	BookDAO book_dao;

	public void setBook_dao(BookDAO book_dao) {
		this.book_dao = book_dao;
	}

	BookPurchaseDAO book_purchase_dao;

	public void setBook_purchase_dao(BookPurchaseDAO book_purchase_dao) {
		this.book_purchase_dao = book_purchase_dao;
	}

	@RequestMapping(value = "/purchase_book_one.do")
	public String bookOne(Model model, OrderVO vo) { // 유저 정보 UserVO list1 = user_dao.selectOne();

		return WEB_PATH + "payment.jsp";
	}

		List<OrderVO>  shop_list = new ArrayList<OrderVO>();
		@RequestMapping(value= "/purchase.do")
		public String list(Model model,OrderVO vo,OrderPageDTO opd) {
			
			//유저 정보
			String id = (String) session.getAttribute("id");
			UserVO list1 =  user_dao.selectOne(id);
			
			//책정보
			List<BookVO> list2 =book_dao.selectlist();
			
			System.out.println("ajax1");
			
			//List<OrderVO> shop_list = new ArrayList<OrderVO>();
			System.out.println("ajax2");
			if(opd!=null) {
			for (OrderVO order_vo : opd.getOrders()) {
				System.out.println(order_vo.getId()+"아이디");
				System.out.println(order_vo.getBookCnt()+"북 수량");
				System.out.println(order_vo.getBookNum()+"북 넘");
				System.out.println(order_vo.getPrice()+"가격");
				System.out.println(order_vo.getSubject()+"주제");
				System.out.println(order_vo.getShopnum()+"샵넘");
				
				System.out.println("나나나나나낭아아앙");
				System.out.println("sdfsdf");
				
				OrderVO basket_vo = new OrderVO();
				
				basket_vo.setId(order_vo.getId());
				basket_vo.setBookCnt(order_vo.getBookCnt());
				basket_vo.setShopnum(order_vo.getShopnum());
				basket_vo.setBookNum(order_vo.getBookNum());
				basket_vo.setPrice(order_vo.getPrice());
				basket_vo.setSubject(order_vo.getSubject());
				shop_list.add(basket_vo);
			}
			}
			System.out.println("ajax3");
			
			
			//상품금액
			int total = 0;
			for (int i = 0; i < shop_list.size(); i++) {
				total += shop_list.get(i).getPrice() * shop_list.get(i).getBookCnt();
				
			}
			
			System.out.println(shop_list.get(0).getBookNum()+"북넘넘어옴");
			
			//책구매정보(책정보 + 책 구매정보)
			List<OrderVO> list3 =book_purchase_dao.selectlist(id);
			
			//int totalPrice =book_purchase_dao.totalPrice(id);
			
			//최종결제금액
			//int finalprice = book_purchase_dao.finalprice();
			
			//적립
			//int savePoint= book_purchase_dao.savepoint();
			

			int finalprice = 0;
			int savePoint = 0;
			// 총합이 shoppoint보다 클때 전체shoppoint 쓰기
			if (total > list1.getShopPoint()) {
				finalprice = (total - list1.getShopPoint());
				// 적립(적립) -- 모두가됨
				savePoint = (int) (finalprice * 0.1);
			} else {
				// shoppoint가 총합보다 클 경우
				finalprice = 0;
			}
			
			System.out.println(savePoint+"적립");
			
			System.out.println(finalprice+"finalprice원");
			
			
			model.addAttribute("user", list1);
			model.addAttribute("book", list2);
			model.addAttribute("order", shop_list);		
			model.addAttribute("orders", list3);		
			model.addAttribute("totalprice", total);
			model.addAttribute("savePoint", savePoint);
			model.addAttribute("finalprice", finalprice);
			
			
			
			//model.addAttribute("totalcnt", totalcnt);
			//model.addAttribute("totalPrice", totalPrice);
			//model.addAttribute("finalprice", finalprice);
			//model.addAttribute("released",releasedDate );
			
			//model.addAttribute("savePoint", savePoint);
			
			
			return WEB_PATH+"payment.jsp";
			
		}
		
		
		//배송지 변경 후 주문 완료 화면으로 이동
		@RequestMapping("update_success_payment.do")
		public String update_success_payment(Model model, OrderVO vo) {
			
			String id = (String) session.getAttribute("id");
			
			//총 주문 상품
			//int totalcnt = book_purchase_dao.totalcnt();
			
			//주문테이블 insert
			//int insertPurchase = book_purchase_dao.inserpurchase(vo);
			
			//기본배송지로 update
			//int updatedelivery = book_purchase_dao.updatedelivery(vo);

			List<OrderVO> list3 =book_purchase_dao.purchaselist(id);
			
			
			
			//book_purchase_dao.insertdelivery(vo);
			
			//적립
			//int savePoint= book_purchase_dao.savepoint();
			
			
			//model.addAttribute("totalcnt", totalcnt);
			//model.addAttribute("savePoint", savePoint);
			model.addAttribute("order", list3);
			return WEB_PATH+"success_payment.jsp";

			
		
		}
		
		//주문완료화면으로 이동(주문 완료 페이지)
		@RequestMapping("success_payment.do")
		public String success_payment(Model model,  OrderVO vo) {
			System.out.println("안녕하세요요요요");
			//주문테이블 insert
			String id = (String) session.getAttribute("id");
			//int insertPurchase = book_purchase_dao.inserpurchase(vo);
				
		//	List<OrderVO> list3 =book_purchase_dao.purchaselist(id);
			
			
			//적립
			//int savePoint= book_purchase_dao.savepoint();
			
			//총 주문 개수
			//int totalcnt = book_purchase_dao.totalcnt();
					
			
			//model.addAttribute("totalcnt", totalcnt);
			//model.addAttribute("savePoint", savePoint);
			//model.addAttribute("order", list3);
			return WEB_PATH+"success_payment.jsp";
		}
		@RequestMapping("success_payments.do")
		public String success_payments(Model model,  OrderVO vo) {
			return WEB_PATH+"success_payment.jsp";
		}
		
		
		
		//주문 상세페이지
		@RequestMapping("/detail_page.do")
		public String content_page(Model model,OrderPageDTO opd) {
			System.out.println(shop_list.size());
			for (int i = 0; i < shop_list.size(); i++) {
				System.out.println("sfd+dfsize");
			}
			String id = (String) session.getAttribute("id");
			
			
			List<OrderVO> list3 =book_purchase_dao.purchaselist(id);
			
			//상품금액(총주문금액)
			int total = 0;
			for (int i = 0; i < shop_list.size(); i++) {
				total += shop_list.get(i).getPrice() * shop_list.get(i).getBookCnt();
				
			}
			
			
			//총 주문 개수s
			//int totalcnt = book_purchase_dao.totalcnt();
			
			//최종결제금액
			//int finalprice = book_purchase_dao.finalprice();
			
				
			model.addAttribute("order", list3);
			//list3.get(0).getAddress1();
			
			//model.addAttribute("totalcnt", totalcnt);
			model.addAttribute("totalPrice", total);
			//model.addAttribute("finalprice", finalprice);
			
			return WEB_PATH+"detail_page.jsp";
		}
		
		
		@RequestMapping("chargePoint.do")
		@ResponseBody
		public String charge(int amount) {
			System.out.println(amount+"데이터 받음");
			int res = UserDAO.insert_pay(amount);
			
			String str = "no";//안됨
			
			if( res == 1 ) {
				str = "yes";//됨
			}
			
			return str;
		}
		
		
		
		
		//메인화면으로 이동(주문환료후)
		//적립포인트 더하기
		//장바구니삭제
		@RequestMapping("/main.do")
		public String main(OrderPageDTO opd) {
			List<OrderVO>  shop_list = new ArrayList<OrderVO>();
			for (OrderVO order_vo : opd.getOrders()) {
				System.out.println("dfsfdsf");
				System.out.println(order_vo.getId()+"아이디");
				System.out.println(order_vo.getBookCnt()+"북 수량");
				System.out.println(order_vo.getBookNum()+"북 넘");
				System.out.println(order_vo.getPrice()+"가격");
				System.out.println(order_vo.getSubject()+"주제");
				System.out.println(order_vo.getShopnum()+"샵넘");
				
				System.out.println("나나나나나낭아아앙");
				System.out.println("sdfsdf");
				
				OrderVO basket_vo = new OrderVO();
				
				basket_vo.setId(order_vo.getId());
				basket_vo.setBookCnt(order_vo.getBookCnt());
				basket_vo.setShopnum(order_vo.getShopnum());
				basket_vo.setBookNum(order_vo.getBookNum());
				basket_vo.setPrice(order_vo.getPrice());
				basket_vo.setSubject(order_vo.getSubject());
				shop_list.add(basket_vo);
			}
			
			//유저 정보
			String id = (String) session.getAttribute("id");
			UserVO list1 =  user_dao.selectOne(id);
			
			
			//장바구니 삭제
			System.out.println(shop_list.size()+"size");
			for (int i = 0; i < shop_list.size(); i++) {
				int delshoppint_cart=book_purchase_dao.delshoppingCart(shop_list.get(i).getShopnum());
				System.out.println(shop_list.get(i).getShopnum()+"getshownum");
				System.out.println(delshoppint_cart+"장바구니 삭제했다!!!!");
			}
			
			
			//기존 통합포인트
			list1.getMoney();

			//적립예종 포인트
			//int savePoint= book_purchase_dao.savepoint();
			//System.out.println(savePoint+"적립예정 업데이트");
			
			// 적립예정 update
			//int update_shopping_point_res = book_purchase_dao.UpdateShoppingPoing(savePoint);
			
			// 돈-최종결제금액
			//최종결제금액
			//int finalprice = book_purchase_dao.finalprice();
			
			System.out.println(list1.getMoney()+"원 통합");
			
//			/int update_money = list1.getMoney()-finalprice;
			
			//int update_money_res= book_purchase_dao.UpdateMoney(update_money);
				
			
			return WEB_PATH+"main.jsp";
		}
		  
		
//		장바구니로 이동
		@RequestMapping("/goshopping.do")
		public String goshopping(OrderVO vo) {
			//purchase정보 삭제
			return "redirect:shoppingCart.do";
		}
		
		

		

}