<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="NewFile.css">
</head>
<body>
	<div class ="sd">
	<a>df</a>
	<c:forEach var="vo" items="${list }">
		${vo }
	</c:forEach>
	</div>
</body>
</html>