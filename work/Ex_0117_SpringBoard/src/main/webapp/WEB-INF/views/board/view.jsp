<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Ajax사용을 위한  httpReques등록-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script type="text/javascript">
/* 게시글 삭제 */
function del(){
	
	if(!confirm("삭제 하시겠습니까?")){
		return;
	}
	var f = document.ff;
	
	//지우고 싶어 입력받은 비번
	var c_pwd = f.c_pwd.value.trim();
	
	if(${list.pwd} != c_pwd){
		alert("비밀번호가 틀립니다.");
		alert(${list.pwd});
		return;
	}
	
	var url ="del.do";
	var param ="idx="+${list.idx};
	
	sendRequest(url,param,delResult,"POST");
}
	
	function delResult(){
		if(xhr.readyState ==4 && xhr.status ==200){
			var data = xhr.responseText;
			if(data ==1){
				alert('삭제 성공');
				
			}else{
				alert('삭제 실패, 관리자에게 문의하세요');
			}
			
			location.href='list.do?page=${param.page}';
		}	
	}

	function reply() {
		var f = document.ff;
		f.action = "reply_form.do";
		f.submit();
	}
	

</script>
</head>
<body>
	<form name="ff" method="post">
		<table border="1" width="700">
			<tr>
				<th width="120">제목</th>
				<td>${list.subject }</td>
			</tr>
			<tr>
				<th width="120">작성자</th>
				<td>${list.name}</td>
			</tr>
			<tr>
				<th width="120">작성일</th>
				<td>${list.regdate  }</td>
			</tr>
			<tr>
				<th width="120">내용</th>
				<td width="500">${list.content  }</td>
			</tr>
			<tr>
				<th width="120">ip</th>
				<td>${list.ip}</td>
			</tr>
			<!-- 비밀번호 -->
			<tr>
				<td width="120">비밀번호</td>
				<td><input type="password" name="c_pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- 목록으로 돌아가기--> 
					<img alt="" src="${pageContext.request.contextPath}/resources/img/btn_list.gif"
					onclick="location.href='list.do?page=${param.page}'"> 
					
					<!-- 댓글 달기 --> 
					<c:if test="${list.depth eq 0}">
						<img alt="" src="${pageContext.request.contextPath}/resources/img/btn_reply.gif" onclick="reply();">
					</c:if>
					 
					<!-- 글 삭제 --> 
					<img alt="" src="${pageContext.request.contextPath}/resources/img/btn_delete.gif"
					onclick="del();">

				</td>
			</tr>
		</table>
		
		<!--board_reply.jsp?idx=12&page=4  -->
		<input type="hidden" name="idx" value="${list.idx }">
		<input type="hidden" name="page" value="${param.page}">
		
	</form>
</body>
</html>