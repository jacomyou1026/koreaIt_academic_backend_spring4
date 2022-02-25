<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script>
	
		function send(f){
			
			var name = f.name.value.trim();
			var content = f.content.value;
			var pwd = f.pwd.value.trim();
			
			//유효성체크(했다쳐)
			if(name == ''){
				alert("작성자 이름을 입력해야 합니다");
				return;
			}
			
			f.action = "modify.do";
			f.method = "post";
			f.submit();
			
		}	
	
	</script>

</head>
<body>
	<form>
		<input type="hidden" name="idx" value="${ vo.idx }">
	
		<table border="1" align="center">
			<caption>::: 글 수정 :::</caption>
			
			<tr>
				<th>작성자</th>
				<td><input name="name" value="${ vo.name }"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="50">${vo.content}</textarea></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${ vo.pwd }"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정하기" onclick="send(this.form);">
					<input type="button" value="목록보기" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>











