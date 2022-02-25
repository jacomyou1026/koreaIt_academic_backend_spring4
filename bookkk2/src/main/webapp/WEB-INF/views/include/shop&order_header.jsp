<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>





<div class="wrapper" style="overflow: auto;">
	<div class="wrap">

		<%@include file="nav.jsp"%>
		<div class="top_area">
			<div class="logo_area">
				<a href="../login/main.jsp"> 
				<img src="${pageContext.request.contextPath}/resources/img/Logo.jpg">
				</a>
			</div>
			<div class="search_area">
				<div id="search_box">
					<input id="search_input" type="text" placeholder="검색어 입력">
					<button id="search_button">검색</button>
				</div>
			</div>
		</div>
	</div>
</div>

