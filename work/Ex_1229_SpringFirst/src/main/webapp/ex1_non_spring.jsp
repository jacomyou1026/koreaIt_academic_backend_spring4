<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//기존 jsp에서 객체를 생성하던 방식
	PersonVO p1 =new PersonVO();
	p1.setName("일길도");
	p1.setAge(20);
	p1.setTel("010-1111-1111");

	PersonVO p2 = new PersonVO("이길동",22,"010-2222-2222");
	
	request.setAttribute("p1", p1);
	request.setAttribute("p2", p2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름/ 나이 / 전화번호<br>
	${p1.name }	/
	${p1.age}	/
	${p1.tel}<br>
		
	${p2.name }	/
	${p2.age}	/
	${p2.tel}<br>	
</body>
</html>