<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<script>
	function send()_new{
	var _width = '750';
    var _height = '600';
 
    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
    var _left = Math.ceil(( window.screen.width - _width )/2);
    var _top = Math.ceil(( window.screen.height - _height )/2); 

	
	window.open("new_head.do", "search", 'width='+ _width +
										  ', height='+ _height +
										  ', left=' + _left + 
										  ', top='+ _top );
	}
	</script>
    
    
    		        <div class="nav">
		             <ul class="list">
		             	<% if(session.getAttribute("id") != null){ %>
		             		<li >
		                    <a href="logout.do">로그아웃</a>
		                	</li>
		                	<li >
		                    <a href="">장바구니</a>
		                	</li>
		                	<li >
		                    <a href="">주문배송</a>
		                </li>
		             	<%} %>
		             	
		             	<% if(session.getAttribute("id") == null){ %>
		             		<li >
		                    <a href="login_form.do">로그인</a>
		                	</li>
		                	<li>
		                    <a onclick="send_new()">회원가입</a>
		                	</li>
		             	<%} %>

		                <li >
		                    <a href="">고객센터</a>
		                </li>           
		            </ul>   
		        	</div>