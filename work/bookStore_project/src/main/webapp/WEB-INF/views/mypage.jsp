<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Cards</title>
	<style>
		@import url("resources/css/main.css");
	</style>
	
    <!-- Custom fonts for this template-->
  

    <!-- Custom styles for this template-->
   
<style>
.container{margin:50px 0px 0px 0px;
		   margin-left: auto;
		   margin-right: auto;}

</style>	

</head>
<script>
function send(){
	var _width = '750';
    var _height = '600';
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/2); 

	
	window.open("charge.do", "charge", 'width='+ _width +
										  ', height='+ _height +
										  ', left=' + _left + 
										  ', top='+ _top );
	}
</script>
<body id="page-top">
    <%@include file="include/header.jsp" %>
    <div class="wrapper">
    <div class="content_area">
    <%@include file="include/mypage_sidebar.jsp" %>
	<div class="container">
    <!-- Earnings (Monthly) Card Example -->
                  <!-- Page Heading -->
                  <div class="jumbotron">
                      <h1 class="h3 mb-0 mt-5 text-gray-800">반갑습니다...<%out.print(session.getAttribute("name")); %>님</h1>
                  </div>
			
                    <div class="row" style="margin-top:50px;	">
                    
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                금액</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%out.print(session.getAttribute("money")); %></div>
                                        </div>
                                        <div class="col-auto">
                                        </div>
                                    <input type="button" value="충전하기" onclick="send();">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Annual) Card Example -->
                        <div class="col-xl-6 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                포인트</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%out.print(session.getAttribute("point")); %></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div><!-- card 끝 -->
                    
                    <div class="recent_orer" style="margin-top:50px; margin-bottom:220px;">
                    	<table border="1" style="width:1090px; height:200px;">
                    		<tr style="text-align: center; color: blue;">
                    			<td style="width:10%; height:50px;">주문번호</td>
                    			<td style="width:10%;">주문금액</td>
                    			<td style="width:40%;">주소</td>
                    			<td style="width:10%;">수량</td>
                    			<td style="width:30%;">주문상태</td>
                    		</tr>
                            <c:forEach var="vo" items="${delivery}">
                    		<tr style="height:60%;">
                                    <td>${vo.deliveryNum}</td>
                                    <td>${vo.price}</td>
                                    <td>
                                        ${vo.deliverypostcode}<br>
                                        ${vo.deliveryaddress1} ${vo.deliveryaddress2}
                                    </td>
                                    <td>
                                        ${vo.bookCnt}
                                    </td>
                                    <td>
                                        주문완료
                                    </td>
                                </tr>
                            </c:forEach>
                    		<tr style="height:30%;">
                    			<td colspan="5">ㅎㅇ</td>
                    		</tr>
                    	</table>
                    </div>
                    
                    
            </div>
    			<%@include file="include/footer.jsp" %>
            </div>
            </div>
                    
		
		 <!-- Bootstrap core JavaScript-->
    
	 <script src="${pageContext.request.contextPath}/resources/mypage/vendor/jquery/jquery.min.js"></script>
	 <script src="${pageContext.request.contextPath}/resources/mypage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	 <script src= "${pageContext.request.contextPath}/resources/mypage/vendor/jquery-easing/jquery.easing.min.js"></script>
	 <script src= "${pageContext.request.contextPath}/resources/mypage/js/sb-admin-2.min.js"></script>
		
</body>
</html>