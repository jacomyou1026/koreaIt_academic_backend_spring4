<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
				<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>BookStore</title>
<link rel="stylesheet" href="resources/css/main.css">
</head>
<body>


						
    <%@include file="include/header.jsp" %>	
    
    
    			
		<div class="content_area">
 

		</div>


    <%@include file="include/footer.jsp" %>	




					    <script>
					    
					  //start jQuery
						$(function() {
					//검색 버튼 이벤트 처리
					$("#searchBtn").click(function() {
						console.log("검색 버튼이 클릭됨!");
						const keyword = $("#keywordInput").val();
						console.log("검색어: " + keyword);
						
						const condition = $("#condition option:selected").val();
						console.log("검색 조건: " + condition);
						
						location.href="bookListSearch?page="+ ${pc.paging.page} + "&countPerPage="+${pc.paging.countPerPage} + "&keyword=" + keyword + "&condition="+condition;
						
					}); 
					
					
					//엔터키 입력 이벤트
					$("#keywordInput").keydown(function (key) {
						 
				        if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
				        	$("#searchBtn").click();
				        }
				 
				    });		
					
					
						});//end jQuery
				    </script>
				    <script>
$(document).ready(function(){
	
	let eResult = '<c:out value="${enroll_result}"/>';
	
	checkResult(eResult);
	
	function checkResult(result){
		
		if(result === ''){
			return;
		}
		
		alert("상품'"+ eResult +"'을 등록하였습니다.");
		
	}

});
</script>
</body>
</html>