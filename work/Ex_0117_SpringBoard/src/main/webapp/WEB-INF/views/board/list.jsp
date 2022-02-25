<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
a {
	text-decoration: none;
	/* color: black; */
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="700" align="center">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td align="center" width="50">${ vo.idx}</td>


				<td>
					<!-- 댓글 들여쓰기  -->
					<c:forEach begin="1" end="${vo.depth }">
						&nbsp;
					</c:forEach>
					
					<!-- 댓글기호 표기 -->
					<c:if test="${vo.depth ne 0 }">
						L
					</c:if>
					
					<!-- 삭제되지 않는 게시물은 클릭이 가능 -->
					<c:if test="${vo.del_info ne -1 }">
						<a href="view.do?idx=${vo.idx }&page=${param.page}">${vo.subject}</a>
					</c:if> 
					
					<!-- 삭제된 게시글을 클릭이 불가 -->
					<c:if test="${vo.del_info eq -1 }">
						<font color= "gray">${vo.subject }</font>
					</c:if>
					
					
				</td>
				<td width="120" align="center">${vo.name}</td>
				
				<c:if test="${vo.del_info ne-1 }">
					<td align="center" width="90">${vo.regdate}</td>
				</c:if>
				
				<c:if test="${vo.del_info eq-1 }">
					<td align="center" width="90"></td>
				</c:if>
				<td align="center" width="60">${vo.readhit}</td>
				
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				${pageMenu}
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<img alt="" src="${pageContext.request.contextPath}/resources/img/btn_reg.gif" onclick="location.href='write.do'" style="cursor:pointer">
			</td>
		</tr>
	</table>
</body>
</html>