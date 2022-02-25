<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
		function send_check(){
			
			//var f = document.getElementById("f");
			var f = document.ff;//ff라는 name을 가진 form태그를 검색
			
			//유효성체크
			
			//reply.do?idx=2&subject=제목&name=작성자명&content=내용&pwd=1111
			f.submit();
			
			
		}
	</script>

</head>
<body>
	<form name="ff" id="f" method="post" action="reply.do">
		<!-- 댓글을 달고 싶은 게시물 번호 와 페이지-->
		<input type ="hidden" name ="idx" value="${param.idx }">
		<input type ="hidden" name ="page" value="${param.page }">
		<table width="700" border="1" align="center">
			<caption>:::댓글 작성:::</caption>
			
			<tr>
				<td width="120">제목</td>
				<td><input name="subject" style="width:250px;"></td>
			</tr>
			
			<tr>
				<td width="120">작성자</td>
				<td><input name="name" style="width:250px;"></td>
			</tr>
			
			<tr>
				<td width="120">내용</td>
				<td><textarea name="content" rows="10" cols="80"></textarea></td>
			</tr>
			
			<tr>
				<td width="120">비밀번호</td>
				<td><input name="pwd" type="password" style="width:250px;"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<img src="${pageContext.request.contextPath}/resources/img/btn_reg.gif" onclick="send_check();">
					
					<img src="${pageContext.request.contextPath}/resources/img/btn_back.gif" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>



