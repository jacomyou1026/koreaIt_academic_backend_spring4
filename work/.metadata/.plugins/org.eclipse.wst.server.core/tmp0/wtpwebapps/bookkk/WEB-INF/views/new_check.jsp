<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/main.css">
</head>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
<script>
	function send(f){
		var name = f.name.value.trim();
		var tel = f.tel.value.trim();
		
		if(name=""){
			alert("이름을 입력해주세요");
			return;
		}
		if(tel=""){
			alert("전화번호를 입력해주세요");
			return;
		}
		
		var url = "check.do";
		var param = "name="+name+"&tel="+ tel;
		sendRequest(url, param, result, "POST");
	}
	
	function result(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//삭제 성공 여부에 따라서 경고창을 띄우자 
			var data = xhr.responseText; //"no" or "yes"
			if(data == 'no'){
				alert("가입하신 아이디가 있습니다.");
				return;
			}else{
				alert("가입하실수 있습니다.");
			}
			
			location.href="new.do";
		}
	}
</script>
<body>
    <%@include file="include/header.jsp" %>	
	<div class="content_area" align="center">
		<form>
		<table border="1">
		<tr>
		<td>
		<h3>이름</h3>
		</td>
       	<td><input name="name"></td>
		</tr>
		<tr>
        <td><h3>전화번호</h3></td>
        <td><input name="tel"></td>
        </tr>
        <tr >
        <td colspan="2"><input type="button" onclick="send(this.form);" value="회원가입"></td>
        </tr>
        </table>
        </form>
	</div>
    <%@include file="include/footer.jsp" %>	
    </body>
</html>