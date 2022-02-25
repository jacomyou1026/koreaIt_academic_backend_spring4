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
			
			f.action = "insert.do";
			f.method = "post";
			f.submit();
			
			
		}	
	
	</script>

</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<table border="1" align="center">
			<caption>::: 새 글 쓰기 :::</caption>
			
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="50"></textarea></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>
					<input type ="file" name="photo">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="send(this.form);">
					<input type="button" value="목록보기" onclick="location.href='list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>











