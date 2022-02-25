<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send1(f) {
		var age = f.age.value.trim();
		var tel = f.tel.value.trim();
		//숫자 3자릿수까지 가능
		var num_pattern = /^[0-9]{1,3}$/;
		
		if(!num_pattern.test(age)){
			alert("나이는 세자리 이하의 정수로만 입력하세요");
			return;
		}
		var tel_patter = /^01([0|6])-?([0-9]{3,4})-?([0-9]{4})$/;
		if(!tel_patter.test(tel)){
			alert("전화번호를 -를 포함하여 정확하게 입력해주세요");
			return;
		}
		
		//insert1.do?name =홍길동&age=20&tel=010-111-1111
		f.action = "insert1.do";
		f.submit();
		
	}
	
	function send2(f) {
		//유효성 체크 했다침
		
		f.action = "insert2.do";
		f.submit();
		
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input name = "name"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input name ="age"></td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input name ="tel"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="낱개로 전송" onclick="send1(this.form);">
					<input type="button" value="묶어서 전송" onclick="send2(this.form);">
				</td>
			</tr>
		</table>


	</form>
</body>
</html>