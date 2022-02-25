<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
		.main-box{align : center;
			  padding-top : 10px;}
	h1 {padding:10px 5px 40px 20px;}
	
	table{padding-left: 420px;
		  border: 1px;
		  table-layout:fixed;
		  font-size: 20px;
		  font-weight: 400;}
	td{padding:0px 40px 25px 0px;}
	#j1{margin-right : 20px;}
	input{padding : 7px 100px 0px 0px;
		  font-size: 17px;}
	#g1{padding-right: 20px}
	jumin1{padding-right: 20px}   
</style>
<link rel="stylesheet" href="resources/css/main.css">
</head>
	<script src="/controller/resources/js/httpRequest.js"></script>
	<script>
		function send(f){
			//check
			var tel_pattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
			var email_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
			
			var id = f.id.value.trim();
			var pwd = f.pwd.value.trim();
			var name = f.name.value.trim();
			var nickname = f.nickname.value.trim();
			
			var jumin1 = f.jumin1.value;
			var jumin2 = f.jumin2.value;
			
			var tel = tel1 + tel2+ tel3
			var tel1 = f.tel1.value;
			var tel2 = f.tel2.value;
			var tel3 = f.tel3.value;
			
			var postcode = f.postcode.value;
			var address1 = f.address1.value.trim();
			var address2 = f.address2.value.trim();
			var email = f.email.value.trim();
			var gender = f.gender.value;
			
			//유효성 체크
			if(id == ""){
				alert("아이디를 입력하셔야 합니다");
				return;
			}
			
			if(pwd == ""){
				alert("비밀번호를 입력하셔야 합니다");
				return;
			}
			if(name == ""){
				alert("이름을 입력하셔야 합니다");
				return;
			}
			if(nickname == ""){
				alert("별명을 입력하셔야 합니다");
				return;
			}
			if(jumin1==""){
				alert("주민번호를 입력해");
				return;
			}
			if(jumin2==""){
				alert("뒷자리 입력해");
				return;
			}
			
			if(!tel_pattern.test(tel)){
				alert("입력된 값은 번호가 아닙니다.");
				return;
			}
			if(!email_pattern.test(email)){
				alert("입력된 값은 이메일이 아닙니다.");
				return;
			}
			
			
			f.method = "post";
			f.action = "insert.do";
			f.submit();
		}
		
	</script>
<body>
	<%@include file="include/header.jsp" %>	
		<div class="content_area">
		<div class="main-box">
				<h1 align="center"> 회원가입</h1>
				<form>
				<table>
					<tr>
						<td >아이디</td>
						<td ><input name="id"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					
					<tr>
						<td>이름</td>
						<td><input name="name"></td>
					</tr>
					
					<tr>
						<td>별명</td>
						<td><input name="nickname"></td>
					</tr>
					
					<tr>
						<td>주민번호</td>
						<td><input name="jumin1" id="j1"><input type="password" name="jumin2"></td>
					</tr>
					
					<tr>
						<td>전화번호</td>
						<td><select name="tel1" size="1">
								<option value="010">010</option>
								<option value="010">011</option>
								<option value="010">012</option>
						</select>
						</td>
						<td><input  name="tel2"></td>
						<td><input  name="tel3"></td>
					</tr>
					
					<tr>
						<td>우편번호</td>
						<td><input name="postcode"></td>
						<!--  <td><input type="button" value="주소찾기" onclick="DaumPostcode()"></td>-->
					</tr>
				
					<tr>
						<td>주소</td>
						<td><input name="address1"></td>
					</tr>
					
					<tr>
						<td>상세주소</td>
						<td><input name="address2"></td>
					</tr>
					
					<tr>
						<td>이메일</td>
						<td><input name="email"></td>
					</tr>
					
					<tr>
						<td>성별</td>
						<td><input type="radio" name="gender" value="남성">남성</td>
						<td><input type="radio" name="gender" value="여성">여성</td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="button" value="회원가입" onclick="send(this.form);">
							<input type="button" value="취소" onclick="location.href='main'">
						</td>
					</tr>
				</table>
				</form>
				</div>
			</div>
		 <%@include file="include/footer.jsp" %>
</body>
</html>