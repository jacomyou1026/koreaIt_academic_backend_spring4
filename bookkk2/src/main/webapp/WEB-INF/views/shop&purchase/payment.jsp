<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/css/payment.css">

<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/main.css">

<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<!-- Ajax를 위한 httpRequest.js참조 -->
<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/payment.js"></script>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script> 
<script src="https://unpkg.com/systemjs@0.21.5/dist/system.js"></script> 


<meta charset="UTF-8">
<title>Insert title here</title>
<script>

$(document).ready(function(){
	
	/* 주문 조합정보란 최신화 */
	setTotalInfo();
	
});

function setTotalInfo(){

	let totalPrice = 0;				// 총 가격
	let totalCount = 0;				// 총 갯수
	let totalKind = 0;				// 총 종류
	let totalPoint = 0;				// 총 마일리지
	let usePoint = 0;				// 사용 포인트(할인가격)
	let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)	

	$(".goods_table_price").each(function(index, element){
		//총 price
		totalPrice += parseInt($(element).find(".individual_total_input").val());
		/* 총 갯수 */
		totalCount += parseInt($(element).find(".bookCount_input").val());

		// 총 종류
		totalKind += 1;
	})

	var today = new Date();
	var release_date = new Date(today.setDate(today.getDate()+2));
		

	point = totalPrice * 0.1;
	point = Math.floor(point);
	$(".point_span").text(point);



	//최종 결제금액
	finalTotalPrice = totalPrice-${user.shopPoint};


	// 총 종류
	$(".goods_kind_div_kind").text(totalKind);
	$(".totalKind_span").text(totalKind);

	// 총 가격
	$(".totalPrice_span").text(totalPrice.toLocaleString());

	// 총 갯수
	$(".totalCount_span").text(totalCount);


	$(".releasedDate_span").text(release_date.toLocaleString());
	$(".finalTotalPrice_span").text(finalTotalPrice);

	//alert($(".releasedDate_span").text());
}



	function Payment(f) {
		var checked = document.getElementById('check').checked;
	
		//배송지 변경시 이름/ 주소 / 휴대번호 유효성 검사
		
	
		//숫자 정규식
		var regex  = "/^[0-9]+$/";
	
		var update_info = document.getElementById('update_info');
	
		if(update_info.style.display == 'block'){
			var name = f.updatename.value.trim();
			var tele1 = f.updatetel1.value;
			var tele2 = f.updatetel2.value;
			var tele3= f.updatetel3.value;
		
			var addr1= f.updatepostcode.value;
			var addr2= f.updateaddress1.value;
			var addr3= f.updateaddress2.value;
		
			if(name == ''){
				alert('이름을 입력해주세요');
				return;
			}
			if(tele2== ''){
				alert('휴대번호를 입력해주세요');
				return;
			}
			if(tele3 == ''){
				alert('휴대번호를 입력해주세요');
				return;
			}
			if(addr1 == ''){
				alert('주소를 입력해주세요');
				return;
			}
			if(addr2 == ''){
				alert('주소를 입력해주세요');
				return;
			}
			if(addr3== ''){
				alert('주소를 입력해주세요');
				return;
			}
	
		if (!checked) {
			alert('주문내역확인동의(필수)');
			return;
		}
		
		//추후 구현
	  /* 	if('${user.money}' < finalTotalPrice){
				alert('돈이 부족합니다.');
				return;
		} */

 
	    if (!confirm("정말 결제하겠습니까?")) {
			return;
		}
		
			f.action = "update_success_payment.do";
			f.submit();
			return;
	
		}else{

		//변경 전
	
		if (!checked) {
			alert('주문내역확인동의(필수)');
			alert('sdfsdf');
			return;
		}
		
		//추후구현
	  /* 	if(${user.money} lt finalprice){
				alert('돈이 부족합니다.');
				return;
		}*/

		if (!confirm("정말 결제하겠습니까?")) {
			return;
		}
	

		f.action = "success_payment.do";

		f.submit();
		}

	}
	
	function startPay(){
	var IMP = window.IMP;
	IMP.init("imp14917305");
		// getter
		var money = $('input[name="cp_item"]:checked').val();
	
		IMP.request_pay({
			pg: 'kakaopay',
			merchant_uid: 'merchant_' + new Date().getTime(),
			pay_method : 'kakaopay',
		 	name: '주문명 :${user.name}',
			amount: money,
			buyer_email: '${user.email}',
			buyer_name: '${user.name}',
			buyer_tel:  '${user.tel1} ${user.tel2} ${user.tel3} ',
			buyer_addr: '${user.address1} ${user.address2}',
			buyer_postcode: '${user.postcode} '
		}, function (rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				/* msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
	*/
				 var url = "chargePoint.do";
				var param = "amount="+money;
				sendRequest(url, param, resultFn, "post"); 
	
				
			} else {
				var msg = '결제에 실패하였습니다.';
				//msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
	
		});
	}

/* 	$(".input_hidden").each(function(index, element) {

		let shopnum = $(element).find(".individual_shopnum_input").val();
		shopnum.l

		let id_input = 	"<input name='orders[" + orderNumber + "].id' type='hidden' value='" + id + "'>";

		form_contents += id_input;

	}) 

 */	
	
</script>
</head>


<body>
	<%@include file="../include/shop&order_header.jsp"%>

	<div class="mainbox">
		<form action="">

			<header>
				<img src="${ pageContext.request.contextPath }/resources/img/order.PNG" alt="">
				<div class="head">
					<ul class="heand_ul">
						<!-- 이름추가 -->
						<li>${user.id}님의통장현황</li>
						<li>캐시 : ${user.money }</li>
						<!-- 포인트 추가 -->
						<li>통합포인트 :${user.shopPoint } P</li>
					</ul>
				</div>
			</header>

			<div class="flex">
				<main>
					<div class="order_info">
						<ul class="owner">
							<li>주문자</li>
							<!--주문자| 번호 |이메일 등록  -->
							<li>${user.name }</li>
							<li>${user.tel1 } - ${user.tel2} - ${user.tel3}</li>
							<li>${user.email }</li>
						</ul>
					</div>

				
						
					<div class="info">
						<h2>배송정보</h2>
						<div id="delivery" class="de_info">
							<!-- 사용자 이름/ 주소 넣기 -->
							<div>
								<span id="delivery_rec" class="blue">[기본 배송지]</span> 
								<span id="user_name">${user.name }</span>
								<!-- 이름 -->
								<input class="update" type="button" value="배송지 변경" onclick="update(this.form);">
							</div>

							<!--우편번호와 주소 넣기  -->
							<div id="address" style="font-size: 11px;">(${user.postcode })
								(${user.address1} ${user.address2})</div>
							<!--휴대번호넣기  -->
							<div>
								<span>${user.tel1 } - ${user.tel2} - ${user.tel3}</span>
							</div>
						</div>

						<!-- 배송지 변경 -->
						<div id="update_info" class="update_info" style="display: none;">
							<form action="">
								<div>
									<span style="color: red; font-size: 13px;"> 이름 * </span>
									<div>
										<input name="updatename" class="new_name"
											style="font-size: 13px;" type="text" placeholder="10자리 내 입력">
									</div>
								</div>
								<div>
									<span style="color: red; font-size: 13px;"> 휴대폰 * </span>
									<div>
										<select class="updatetel1" name="updatetel1" id="">
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
											<option value="017">017</option>
											<option value="018">018</option>
											<option value="019">019</option>
										</select>
										 <span>
											  <input class="tel2" name="updatetel2" style="width: 17%; text-align: center;" type="text"  maxlength="4">
										 </span>
										 <span> 
											 <input class="tel3" name="updatetel3" style="text-align: center; width: 17%;" type="text" maxlength="4">
										</span>
									</div>
								</div>

								<div>
									<span style="color: red; font-size: 11px;"> 주소 * </span>
									<div>
										<div class="address_input_1_boxs">
											<div class="address_input_1_box">
												<input type="text" id="address_input_1" class="postcode" name="updatepostcode" readonly="readonly" size=15>
											</div>
											<div class="address_button">
												<input type="button" class="find_add" value="주소 찾기" onclick="execution_daum_address(); ">
											</div>
										</div>
										<div style="margin-bottom: 4px;">
											<div class="address_input_2_box">
												<input type="text" class="add_input_2" id="address_input_2" name="updateaddress1" readonly="readonly" size=15>
											</div>

										</div>
										<div>
											<div class="address_input_3_box">
												<input type="text" id="address_input_3" class="add_input_3" name="updateaddress2" readonly="readonly" size=15>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>

					<!-- id넘겨주기 -->
					<input type="hidden" name ="id" value="${user.id}">

					<!-- 주문상품 개수넣기 -->
					<div class="order_item">
						<h2>주문상품 </h2>
						<span class="totalKind_span"></span>종
						<span class="totalCount_span"></span>개
						
						<div>
							<table>
								<tr class="table_head">
									<td>상품정보</td>
									<td>판매가</td>
									<td>배송/판매자</td>
								</tr>

								<!--상품이미지 상품정보 판매가 수량 넣기  -->
								<c:forEach var="vo" items="${order}" varStatus="cnt">
									<div class="goods_table_price">
											<div class="input_hidden">
												가격:
												<input type="text" name="price" class="individual_price_input" value="${vo.price}"><br>
												책수량:
												<input type="text" name="bookCnt" class="bookCount_input" value="${vo.bookCnt}"><br>
												총합
												<input type="text" class="individual_total_input" value="${vo.price * vo.bookCnt}"><br>
												주제:
												<input type="text" class="subject" value="${vo.subject}">
												샵번호:
												<input type="text" class="individual_shopnum_input" value="${vo.shopnum}">
												북넘:
												<input type="text" name="bookNum" class="individual_booknum_input" value="${vo.bookNum}">

											</div>


										<tr>
											<td class="td_one"><img src="" alt=""> <!-- image -->
												<span>${vo.subject }</span> <!--상품이름  -->
											</td>

											<td>
												<span class="table_border">${vo.price}원 </span> 수량 ${vo.bookCnt }개<br> <!-- 판매가 수량 넣기--> <!-- 한 책당  총가격(수량 * 가격)-->
												총 가격 ${vo.price * vo.bookCnt}원 <br>
											</td>
											<td>교보문고배송</td>
											
											<!-- <input type="text" name ="purchaseNum" value="${vo.purchaseNum}"> -->
										</tr>
									</div>
								</c:forEach>
								</div>
							</table>
						</div>

						<div class="discount">
							<h2>할인/적립</h2>
							<table>
								<tr>
									<td class="total_point_" style="padding: 23px; width: 25%;">통합포인트</td>
									<td style="border-top: 1px solid;">
										<div style="font-size: 11px;" id="all_points">${user.shopPoint } 원</div>

									</td>
								</tr>
								<tr>
									<td class="save_money">적립</td>
									<td style="border-bottom: 1px solid; width: 24px;">
										<!-- 총 판매금액의 10% 적립 포인트 -->
										<div style="display: flex; flex-direction: column;">
											<span>총 판매금액의 10% 적립됩니다.</span>
											<!--적립금액 작성  -->
											<span class="point_span"> </span>원
										</div>
									</td>
								</tr>

							</table>
						</div>
						<div class="charge" style="width: 69%;">
							<h2 style=" margin-bottom: 18px;
							margin-top: 20px;">충전</h2>

							<div id="card_body" class="card-body bg-white mt-0 shadow">
								<span>현재 캐시 : ${user.money }</span>
								<p style="    font-weight: bold;
								padding: 10px;
								text-align: center;">카카오페이 현재 사용가능</p>


								<div class="box_radio_frame">
								<label
									class="box-radio-input"><input type="radio" 
									name="cp_item" value="5000"><span>5,000원</span></label> 
								<label
									class="box-radio-input"><input type="radio"
									name="cp_item" value="10000"><span>10,000원</span></label>
								<label
									class="box-radio-input"><input type="radio"
									name="cp_item" value="15000"><span>15,000원</span></label> 
								<label
									class="box-radio-input"><input type="radio" 
									name="cp_item" value="20000"><span>20,000원</span></label> <label
									class="box-radio-input"><input type="radio"
									name="cp_item" value="25000"><span>25,000원</span></label> <label
									class="box-radio-input"><input type="radio"
									name="cp_item" value="30000"><span>30,000원</span></label> <label
									class="box-radio-input"><input type="radio"
									name="cp_item" value="35000"><span>35,000원</span></label> <label
									class="box-radio-input"><input type="radio"
									name="cp_item" value="40000"><span>40,000원</span></label> <label
									class="box-radio-input"><input type="radio"
									name="cp_item" value="50000"><span>50,000원</span></label>
								</div>
								<p style="        color: #6482FF;
								font-size: 18px;
								text-align: center;
							">
									카카오페이의 최소 충전금액은 5,000원이며 <br />최대 충전금액은 50,000원 입니다.
								</p>

								<div>
									<button type="button" class="btn btn-lg btn-block  btn-custom" id="charge_kakao" onclick="startPay();">충전 하기</button>
								</div>
							</div>

						</div>
					</div>
					<div>
				</main>

				<aside>
					<div class="d">
						<div class="d_blue">
							<div class="date">배송일정</div>
							<span class="d_location">배송지 - ${user.address1}
								${user.address2} </span>
							<!-- 배송지 넣기 -->
							<span> </span>
							<!-- sysdate를 이용하여 계산 -->
							<div calss="release_frame"
								style="border: 1px solid; padding: 23px; display: flex; justify-content: space-evenly;">
								<span class="relaese" style="font-size: 19px;">출고예정</span>
								 <span class="releasedDate_span" style="font-size: 27px;"></span>
							</div>
						</div>
						<div class="price_tag">
							<!-- 가격설정 -->
							<div class="one">
								<span>상품금액</span> <span>배송비</span> <span>할인금액</span>
							</div>
							<div class="two">

								<!-- 상품금액넣기-->
								<div>

									<span class="totalPrice_span" ></span>
									<span>원</span>
								</div>
									<!-- 배송비넣기 -->
								<span class="mon">0원</span>
								<!-- 할인금액넣기-->
								<span class="mon">-${user.shopPoint }원</span>

								
							</div>
						</div>
						<div class="final_pr">
							<span style="color: red;">최종 결제금액</span> 
							<span  class="" style="color: red; font-weight: bold; font-size: 22px;" >${finalprice}</span>원
							<!-- 최종금액넣기 -->
						</div>
						<div class="totals">
							<div class="totals_points" style="width: 100%;">
								<span class="total_point">적립예정 통합포인트</span> 
								<span class="point_span" style="font-size: 17px; font-weight: bold;"></span>원P
							</div>
							<!-- 적립넣기 -->
							<div>
								<div class="contents">쿠폰,통합포인트 사용시 주문완료 후 적립예정포인트가 변동될 수
									있습니다.</div>
							</div>
						</div>
						<div class="agree">
							<input id="check" style="padding: 5px 12px;" type="checkbox">
							<span style="margin-left: 10px;">주문내역확인동의(필수)</span>
						</div>

						<div class="btn">
						
							<input class="pay" style="padding: 10px;" type="button" value="결제하기" onclick="Payment(this.form);">
							<input class="shopping" style="padding: 10px;" type="button" value="장바구니가기" onclick="goshopping();"  style="cursor:pointer">
						</div>
					</div>
				</aside>
			</div>
		</form>
	</div>

	<%@include file="../include/footer.jsp"%>
</body>
</html>