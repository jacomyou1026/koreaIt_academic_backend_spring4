package com.spring.controller;

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
import vo.DeliveryVO;
import vo.OrderVO;
import vo.UserVO;

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

	@RequestMapping(value = "/purchase.do")
	public String list(Model model) {

		
		// 유저 정보
		String id = (String) session.getAttribute("id");
		
		UserVO list1 = user_dao.selectOne(id);
		
		// 책정보
		List<BookVO> list2 = book_dao.selectlist();
		
		
		// 책테이블 +shopping cart 
		List<OrderVO> list3 = book_purchase_dao.selectlist(id);
		
		//<!--책테이블 +BOOK_PURCHASE+BOOK_USER--
		List<OrderVO> purchaselist = book_purchase_dao.purchaselist(id);
		
		for (int i = 0; i < purchaselist.size(); i++) {
			int saleprice = (int) ((int)purchaselist.get(i).getPrice()*0.9);
			System.out.println(saleprice+"원 saleprice");
			purchaselist.get(i).setPrice(saleprice);
			
		}
		 
		

		int total = 0;
		for (int i = 0; i < purchaselist.size(); i++) {
			total +=(purchaselist.get(i).getBookCnt() * (purchaselist.get(i).getPrice()*0.9));
		}
		System.out.println(total + "total");

		

		// int totalPrice =book_purchase_dao.totalPrice(id);

		// 최종결제금액
		// int finalprice = book_purchase_dao.finalprice();

		// 적립
		// int savePoint= book_purchase_dao.savepoint();
		
		
		System.out.println(list1.getShopPoint() + "shoppoint");
		int finalprice = 0;
		int savePoint = 0;
////		// 총합이 shoppoint보다 클때 전체shoppoint 쓰기
		if (total > list1.getShopPoint()) {
			finalprice = (total - list1.getShopPoint());
			// 적립(적립) -- 모두가됨
			savePoint = (int) (finalprice * 0.1);
		} else {
			// shoppoint가 총합보다 클 경우
			finalprice = 0;
			savePoint =0;
		}
		
		
		System.out.println(savePoint + "적립");

		System.out.println(finalprice + "finalprice원");

		model.addAttribute("user", list1);
		model.addAttribute("book", list2);
		model.addAttribute("purchaselist", purchaselist);

		// model.addAttribute("totalcnt", totalcnt);
		// model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("finalprice", finalprice);
		// model.addAttribute("released",releasedDate );

		model.addAttribute("savePoint", savePoint);

		return WEB_PATH + "payment.jsp";

	}

	// 배송지 변경 후 주문 완료 화면으로 이동
	@RequestMapping("update_success_payment.do")
	public String update_success_payment(Model model, DeliveryVO vo1) {
		
		String id = (String) session.getAttribute("id");
		//변경 후 1로 변경
		book_purchase_dao.updatedeliverysep(id);
		
		UserVO list1 = user_dao.selectOne(id);

		List<OrderVO> list3 = book_purchase_dao.purchaselist(id);
		for (int i = 0; i < list3.size(); i++) {
			int updateDelivery = book_purchase_dao.updatedeliverys(vo1);
		}
		
		int total = 0;
		for (int i = 0; i < list3.size(); i++) {
			total +=(list3.get(i).getBookCnt() * (list3.get(i).getPrice()*0.9));
		}
		
		int finalprice = 0;
		int savePoint = 0;
////		// 총합이 shoppoint보다 클때 전체shoppoint 쓰기
		if (total > list1.getShopPoint()) {
			finalprice = (total-list1.getShopPoint());
			// 적립(적립) -- 모두가됨
			savePoint = (int) (finalprice * 0.1);
			
		} else {
			// shoppoint가 총합보다 클 경우
			finalprice = 0;
			savePoint =0;
		}
		
		System.out.println(total + "total");
		System.out.println(savePoint);
		

		
//		int totalcnt = book_purchase_dao.totalcnt(id);
//		System.out.println(totalcnt+"총cNT");

		// 적립
		// int savePoint= book_purchase_dao.savepoint();

		//model.addAttribute("totalcnt", totalcnt);
		model.addAttribute("savePoint", savePoint);
		model.addAttribute("order", list3);
		return WEB_PATH + "success_payment.jsp";

	}

	// 주문완료화면으로 이동(주문 완료 페이지)
	@RequestMapping("success_payment.do")
	public String success_payment(Model model,UserVO vo) {

		// 주문테이블 insert
		String id = (String) session.getAttribute("id");

		UserVO list1 = user_dao.selectOne(id);

		List<OrderVO> list3 = book_purchase_dao.purchaselist(id);

		int total = 0;
		for (int i = 0; i < list3.size(); i++) {
			total +=(list3.get(i).getBookCnt() * (list3.get(i).getPrice()*0.9));
		}
		
		int finalprice = 0;
		int savePoint = 0;
////		// 총합이 shoppoint보다 클때 전체shoppoint 쓰기
		if (total > list1.getShopPoint()) {
			finalprice = (total - list1.getShopPoint());
			// 적립(적립) -- 모두가됨
			savePoint = (int) (finalprice * 0.1);
		} else {
			// shoppoint가 총합보다 클 경우
			finalprice = 0;
		}
		
		
		for (int i = 0; i < list3.size(); i++) {
			DeliveryVO updatevo1 = new DeliveryVO();
			updatevo1.setId(list3.get(i).getId());
			updatevo1.setBookNum(list3.get(i).getBookNum());
			updatevo1.setBookCnt(list3.get(i).getBookCnt());
			updatevo1.setPrice(list3.get(i).getPrice());
			updatevo1.setDeliverypostcode(list3.get(i).getPostcode());
			updatevo1.setDeliveryaddress1(list3.get(i).getAddress1());
			updatevo1.setDeliveryaddress2(list3.get(i).getAddress2());
			updatevo1.setDeliverytel1(list3.get(i).getTel1());
			updatevo1.setDeliverytel2(list3.get(i).getTel2());
			updatevo1.setDeliverytel3(list3.get(i).getTel3());
			updatevo1.setDeliveryname(list3.get(i).getName());
			
			
			
			System.out.println("updateVO1="+updatevo1.getId()+","+updatevo1.getBookNum()+","+updatevo1.getPrice());
			System.out.println(updatevo1.getDeliverypostcode());
			System.out.println(updatevo1.getDeliveryaddress1());
			System.out.println(updatevo1.getDeliveryaddress2());
			System.out.println(updatevo1.getDeliverytel1());
			System.out.println(updatevo1.getDeliverytel2());
			System.out.println(updatevo1.getDeliverytel3());
			
			int updateDelivery = book_purchase_dao.delivery(updatevo1);
		}
		

		
		
	//	model.addAttribute("totalcnt", totalcnt);	
		model.addAttribute("savePoint", savePoint);
		model.addAttribute("order", list3);
		return WEB_PATH + "success_payment.jsp";
	}

	// 주문 상세페이지
	@RequestMapping("/detail_page.do")
	public String content_page(Model model) {

		String id = (String) session.getAttribute("id");

		List<OrderVO> list3 = book_purchase_dao.purchaselist(id);

		UserVO list1 = user_dao.selectOne(id);

		
		int total = 0;
		for (int i = 0; i < list3.size(); i++) {
			total +=(list3.get(i).getBookCnt() * (list3.get(i).getPrice()*0.9));
		}
		
		int finalprice = 0;
		int savePoint = 0;
////		// 총합이 shoppoint보다 클때 전체shoppoint 쓰기
		if (total > list1.getShopPoint()) {
			finalprice = (total - list1.getShopPoint());
			// 적립(적립) -- 모두가됨
			savePoint = (int) (finalprice * 0.1);
		} else {
			// shoppoint가 총합보다 클 경우
			finalprice = 0;
		}
		
		// 최종결제금액
//		 finalprice = book_purchase_dao.finalprice();
		

		model.addAttribute("order", list3);
		model.addAttribute("totalPrice", total);
		model.addAttribute("finalprice", finalprice);
		//model.addAttribute("totalcnt", totalcnt);

		return WEB_PATH + "detail_page.jsp";
	}

	@RequestMapping("chargePoint.do")
	@ResponseBody
	public String charge(int amount) {
		String id = (String) session.getAttribute("id");
		UserVO vo =new UserVO();
		vo.setId(id);
		vo.setAccount(amount);
		System.out.println(vo.getAccount()+"충고");
		
		
////		수정요함
		int res = user_dao.insert_pay(vo);
		
		System.out.println(res+"카카오페이");

		String str = "no";// 안됨

		if (res == 1) {
			str = "yes";// 됨
		}

		return str;
	}

	// 메인화면으로 이동(주문환료후)
	// 적립포인트 더하기
	// 장바구니삭제
	@RequestMapping("/main.do")
	public String main(OrderVO vo) {
		
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		vo.setId(id);
		
		System.out.println(vo.getId());
		
		System.out.println(vo.getId()+"아이디가 보도");
		
		List<OrderVO> list3 = book_purchase_dao.purchaselist(vo.getId());
		// 기존배송지로 초기화 - 0으로 바꿈
		book_purchase_dao.initdeliverysep(id);
		// 유저 정보
		UserVO list1 = user_dao.selectOne(vo.getId());
		
		// 기존 통합포인트
		list1.getMoney();
		for (int i = 0; i < list3.size(); i++) {
			//장바구니삭제
			int delgoshoppurchse = book_purchase_dao.delshoppingCart(list3.get(i).getShopnum());
			System.out.println(delgoshoppurchse+"장바구니 삭제");
			
		}
		int delpurchase = book_purchase_dao.delppurchse(id);
		
		
		int total = 0;
		for (int i = 0; i < list3.size(); i++) {
			total +=(list3.get(i).getBookCnt() * (list3.get(i).getPrice()*0.9));
		}
		
		int finalprice = 0;
		// 총합이 shoppoint보다 클때 전체shoppoint 쓰기
		int savePoint= 0;
		if (total > list1.getShopPoint()) {
			finalprice = (total-list1.getShopPoint());
			// 적립예종 포인트
			savePoint=(int) (finalprice*0.1);
			System.out.println(savePoint + "적립예정 업데이트");
			
			vo.setSavePoint(savePoint);
			vo.setId(id);
			System.out.println(vo.getSavePoint());
			// 적립예정 update
			int update_shopping_point_res = book_purchase_dao.UpdateShoppingPoing(vo);
			System.out.println(update_shopping_point_res +"update"+list1.getShopPoint());
		} else {
			savePoint = 0;
			//사용자 포인트 - 상품금액 업데이트
			int bigshop = (list1.getShopPoint()-total);
			vo.setBigshop(bigshop);
			int bigshoppingpointt = book_purchase_dao.bigshoppingpoint(vo);
			
		}

	
		 System.out.println(savePoint+"적립예정 업데이트");
		 
		 System.out.println(list1.getShopPoint()+"사용자 포인트");
		 
		//적립예정 update
		 //int update_shopping_point_res = book_purchase_dao.UpdateShoppingPoing(vo);
		 
		 

		System.out.println(list1.getMoney() + "원 통합");
		System.out.println(finalprice+"최종 결제 금액");

		int update_money = list1.getMoney()-finalprice;
		System.out.println(update_money +"최종");
		
		vo.setUpdate_money(update_money);
		
		int update_money_res= book_purchase_dao.UpdateMoney(vo);
		
		 
		 System.out.println(list1.getMoney());
		 

		return "/WEB-INF/views/main.jsp";
	}

//	장바구니로 이동
	@RequestMapping("/goshopping.do")
	public String goshopping(OrderVO vo) {
		
		String id = (String) session.getAttribute("id");
		
		List<OrderVO> list3 = book_purchase_dao.purchaselist(id);
		
		int delpurchase = book_purchase_dao.delppurchse(id);
		
		System.out.println(delpurchase + "delpurchase");
		

		return "redirect:shoppingCart.do";
	}
	
	

}