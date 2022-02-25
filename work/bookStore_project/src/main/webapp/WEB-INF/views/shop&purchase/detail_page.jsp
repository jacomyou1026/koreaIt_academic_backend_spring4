<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath }/resources/css/detail.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

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
    let  usePoint = 0;				// 사용 포인트(할인가격)
    let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)	

	$(".cart_info").each(function(index, element){
		
		/* 총 갯수 */
		totalCount += parseInt($(element).find(".bookCount_input").val());
		// 총 종류
		totalKind += 1;
	})
    // 총 갯수
	$(".totalCount_span").text(totalCount);

    // 총 종류
	$(".totalKind_span").text(totalKind);
    

}

    </script>

</head>
<body>
    <div class ="view">
        <span>주문내역상세보기</span>
    </div>
    <div class="list">
        <span>주문상품내역</span>
        <span style="    color: red;" class="totalKind_span"></span>종
		<span style="    color: red;" class="totalCount_span"></span>개
    </div>
    <div>
        <table  style="   width: 100%;
        margin-top: 20px; overflow: auto;">
            <tr class="head_table">
                <th>날짜</th>
                <th>주문자</th>
                <th style="    padding: 7px; ">상품정보</th>
                <th>수량</th>
                <th>상품금액</th>
                <th>합계</th>
                <th>배송 정보</th>
            </tr>
         <c:forEach var="vo" items="${order}" varStatus="cnt">
             <span class="cart_info" style="display:none" >
                <input type="hidden" class="bookCount_input" value="${vo.bookCnt}">
             </span>
            <tr class="tr_back">
                <td>${vo.regdate}</td>
                <td>${vo.name}</td>
                <td style=" padding: 9px;">
                    <div>${vo.subject} </div>
                    <div>${vo.author}</div>
                    <div>${vo.publishdate}</div>
                    <div>${vo.publisher}</div>
                </td>
                <td>${vo.bookCnt}</td>
                <td>${vo.price}</td>
                <td> ${vo.bookCnt * vo.price }</td>

                
                <c:if test="${vo.deliverySep eq 1}">
                    <b>배송지 변경된 주소</b>
                    <td>
                        <span>${param.deliveryname}</span>
                        <span>${param.deliverytel1} - ${param.deliverytel2} - ${param.deliverytel3}</span>
                        <span>(${param.deliverypostcode}) ${param.deliveryaddress1} ${params.deliveryaddress2} </span>
                    </td>
                </c:if>

                <c:if test="${vo.deliverySep eq 0}">
                    <td>
                        
                        (${vo.postcode}) ${vo.address1} ${vo.address2}
                    </td>
                </c:if>
            </tr>
         </c:forEach>
        </table>
        <div class="contetent_back">
            <c:if test="${finalprice gt list1.shopPoint }">
                <span class ="conten_1">
                    (총 주문금액 ${totalPrice}) + (배송료 : 0) -
                    (할인금액 : ${list1.getShopPoint()}) =   
                 </span>
            </c:if>
                
            <c:if test="${finalprice le list1.shopPoint }">
                    <span class ="conten_1">
                        (총 주문금액 ${totalPrice}) + (배송료 : 0) - (할인금액 :${totalPrice}) =    
                    </span>
            </c:if>
            <span class="conten_2">${finalprice}원</span>
        </div>
    </div>
</body>
</html>