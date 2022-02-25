<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Cards</title>
	
    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/resources/mypage/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/mypage/css/sb-admin-2.min.css">
	
	<link rel="stylesheet" href="resources/css/main.css">
	<style>
		.container-fluid{}
		#td1{width: 30%; padding: 20px 0px 20px 20px;}
		#td2{width: 70%;}
		#id, #name, #gender{border: 0px;}
		#tel{width: 100px;}
		#bt{margin: 10px;}
		/* input{float:left;} */
		
		.input-form { max-width: 680px; 
			  margin-top: 80px; 
			  padding: 32px; 
			  background: #fff; 
			  -webkit-border-radius: 10px; 
			  -moz-border-radius: 10px; 
			  border-radius: 10px; 
			  -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15); 
			  -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15); 
			  box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15) 
			  }
	</style>
</head>
<script>
   /* 다음 주소 연동 */
	function execution_daum_address(){
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            
	        	// 각 주소의 노출 규칙에 따라 주소를 조합한다.
               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
               var addr = ''; // 주소 변수
               var extraAddr = ''; // 참고항목 변수

               //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                   addr = data.roadAddress;
               } else { // 사용자가 지번 주소를 선택했을 경우(J)
                   addr = data.jibunAddress;
               }

               // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
               if(data.userSelectedType === 'R'){
                   // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                   // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                       extraAddr += data.bname;
                   }
                   // 건물명이 있고, 공동주택일 경우 추가한다.
                   if(data.buildingName !== '' && data.apartment === 'Y'){
                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                   }
                   // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                   if(extraAddr !== ''){
                       extraAddr = ' (' + extraAddr + ')';
                   }
                   // 조합된 참고항목을 해당 필드에 넣는다.
                   addr += extraAddr;
               
               } else {
               	document.getElementById("address2").value = '';
                   addr += ' ';
               }

               // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //$(".postcode").val(data.zonecode);
	             $("[name=postcode]").val(data.zonecode);    // 대체가능
	             //$(".address1").val(addr);
	             $("[name=address1]").val(addr);            // 대체가능
	             
	             // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
	             document.getElementById("address2").focus();
	 
	        }
	    }).open();  
	}
   
	function send_adjust(f){
		//check
		//var tel_pattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
		var email_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		
		var id = f.id.value.trim();
		var nickname = f.nickname.value.trim();
		
		var tel1 = f.tel1.value;
		var tel2 = f.tel2.value;
		var tel3 = f.tel3.value;
		
		var postcode = f.postcode.value;
		var address1 = f.address1.value.trim();
		var address2 = f.address2.value.trim();
		var email = f.email.value.trim();
		
		///유효성 체크
		if(id == ""){
			alert("별명을 입력하셔야 합니다");
			return;
		}
		///유효성 체크
		if(nickname == ""){
			alert("별명을 입력하셔야 합니다");
			return;
		}
		
		if(!email_pattern.test(email)){
			alert("입력된 값은 이메일이 아닙니다.");
			return;
		}
		
		if(tel1==""){
			alert("전화번호를 입력해주셔야 합니다.");
			return;
		}
		
		if(tel2==""){
			alert("전화번호를 입력해주셔야 합니다.");
			return;
		}
		
		if(tel3==""){
			alert("전화번호를 입력해주셔야 합니다.");
			return;
		}
		
		
		f.method = "post";
		f.action = "adjust.do";
		f.submit();
	}
   </script>
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			 crossorigin="anonymous">
			</script> 
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" 
			crossorigin="anonymous">
			</script> 
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			 integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" 
			 crossorigin="anonymous">
	</script> 
<body id="page-top">
	
    <%@include file="../include/header.jsp" %>
    <%@include file="../include/mypage_sidebar.jsp" %>
    <div class="wrapper" style="margin-top: 40px;">
    
    <div class="content_area">
       
        <div class="container col-md-8">
                 <!-- Page Heading -->
           <form class="validation-form" id="login_form" novalidate> 
		
			<div class="col-md-6 mb-3"> 
				<label for="id">ID</label> 
				<input type="text" class="form-control" name="id" id="id" placeholder="<%out.print(session.getAttribute("id")); %>"  value="<%out.print(session.getAttribute("id")); %>" readonly="readonly"
				 	   style="box-shadow: 0px 0px 6px #000;"> 
			</div>
		
			
		<div class="row"> 
		<div class="col-md-6 mb-3"> 
				<label for="name" style="margin-top: 20px;">이름</label> 
				<input type="text" class="form-control" value="<%out.print(session.getAttribute("name")); %>" 
						placeholder="<%out.print(session.getAttribute("name")); %>" readonly="readonly"
						style="box-shadow: 0px 0px 6px #000;"> 
				<div class="invalid-feedback"> 이름을 입력해주세요. </div> 
			</div>
			<div class="col-md-6 mb-3"> 
				<label for="nickname" style="margin-top: 20px;">별명</label> 
				<input type="text" class="form-control" id="nickname" name="nickname"
				placeholder="<%out.print(session.getAttribute("nickname")); %>"
				style="box-shadow: 0px 0px 6px #000;"> 
				<div class="invalid-feedback"> 별명을 입력해주세요. </div> 
			</div> 
		</div>
		
			<div class="col-md-4 mb-3"> 
				<label for="tel" style="margin-top: 20px;">전화번호</label>
				<div class="row">
				<input type="text" class="form-control" id="tel" name="tel1" 
				placeholder="<%out.print(session.getAttribute("tel1")); %>"
				style="box-shadow: 0px 0px 6px #000;">
				
				<div class="col-md-4 mb-3"> 
				<input type="text" class="form-control" id="tel" name="tel2" 
				placeholder="<%out.print(session.getAttribute("tel2")); %>"
				style="box-shadow: 0px 0px 6px #000;">
          			</div>
				<div class="col-md-4 mb-3"> 
				<input type="text" class="form-control" id="tel" name="tel3" 
				placeholder="<%out.print(session.getAttribute("tel3")); %>"
				style="box-shadow: 0px 0px 6px #000;">
              		</div>
              		
              		</div>
          		</div>
          		
						
			
			<div class="row">
			<div class="col-md-6 mb-3"> 
				<label for="email" style="margin-top: 20px;">이메일</label> 
				<input type="text" class="form-control" id="email" name="email"
				placeholder="<%out.print(session.getAttribute("email")); %>"
				style="box-shadow: 0px 0px 6px #000;">
			</div> 
			<div class="col-md-3 mb-3"> 
				<label for="jumin1" style="margin-top: 20px;">생년월일</label> 
				<input type="text" class="form-control" id="jumin1" 
				placeholder="<%out.print(session.getAttribute("jumin1")); %>" 
				value="<%out.print(session.getAttribute("jumin1")); %>" readonly="readonly"
				style="box-shadow: 0px 0px 6px #000;"> 
			</div> 
			</div>
			<div class="row">
				
				
				<div class="col-md-3 mb-3"> 
						<label for="postcode" style="margin-top: 20px;">우편번호</label> 
						<input type="text" class="form-control" style="box-shadow: 0px 0px 6px #000;" class="address_input_1" name="postcode" id="postcode" placeholder="<%out.print(session.getAttribute("postcode")); %>" readonly="readonly">
                 			<div class="invalid-feedback"> 우편번호를 입력해주세요. </div> 
				</div> 
				
			</div>
				
			<div class="mb-3"> 
				<input type="text" style="box-shadow: 0px 0px 6px #000;" class="form-control" class="address_input_2" id="address1" name="address1" placeholder="<%out.print(session.getAttribute("addr1")); %>" readonly="readonly">
			</div> 
				<div class="mb-1"> 
					<label for="address2" style="margin-top: 20px;">상세주소
					</label> 
					<input type="text" style="box-shadow: 0px 0px 6px #000;" class="form-control" class="address_input_3" id="address2" name="address2" placeholder="<%out.print(session.getAttribute("addr2")); %>">
          			</div>
				
			<div class="col-xs-3 mb-5">
				<label for="postcode" style="margin-top: 40px;"></label> 
				<div class="address_button" onclick="execution_daum_address();">
					<input type="button"  value="주소 찾기">
				</div>
			</div>
			
			<div class="row" style="margin-top: 20px;">
			<div class="col-md-5">		
			<input id="bt" type="button" value="수정" onclick="send_adjust(this.form)" style="width:300px; height:70px; margin-left:80px;">
			</div>	
			<div class="col-md-5">	
   			<input id="bt" type="button" value="취소" onclick="location.href='main.do'" style="width:300px; height:70px; margin-left:80px;">
			</div>
			</div>	
		</form>
        </div>
		<%@include file="../include/footer.jsp" %>
         </div>
      </div>
		
		 <!-- Bootstrap core JavaScript-->
    
	 <script src="${pageContext.request.contextPath}/resources/mypage/vendor/jquery/jquery.min.js"></script>
	 <script src="${pageContext.request.contextPath}/resources/mypage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	 <script src= "${pageContext.request.contextPath}/resources/mypage/vendor/jquery-easing/jquery.easing.min.js"></script>
	 <script src= "${pageContext.request.contextPath}/resources/mypage/js/sb-admin-2.min.js"></script>
	 <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
   
</body>
</html>