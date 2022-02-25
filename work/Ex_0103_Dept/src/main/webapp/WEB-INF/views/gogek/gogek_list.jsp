<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>고객번호</td>
			<td>고객이름</td>
			<td>고객주소</td>
		</tr>
	<c:forEach var="vo" items="${ list }">		
		<tr>
			<td>${ vo.gobun }</td>
			<td>${ vo.goname }</td>
			<td>${ vo.goaddr }</td>
		</tr>
	</c:forEach>
		
	</table>


</body>
</html>