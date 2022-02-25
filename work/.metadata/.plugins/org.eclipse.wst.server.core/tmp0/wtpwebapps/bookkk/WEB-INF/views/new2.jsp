<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head> 
<meta charset="UTF-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>회원가입 화면 샘플 - Bootstrap</title> 
<!-- Bootstrap CSS --> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
<style> body { min-height: 100vh; 
			   background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c)); 
			   background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%); 
			   background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%); 
			   background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%); 
			   background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%); } 
.input-form { max-width: 680px; 
			  margin-top: 80px; 
			  padding: 32px; 
			  background: #fff; 
			  -webkit-border-radius: 10px; 
			  -moz-border-radius: 10px; 
			  border-radius: 10px; 
			  -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15); 
			  -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15); 
			  box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15) } 
</style>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script> 

</head> 
<body> 
<div class="container"> 
<div class="input-form-backgroud row"> 
	<div class="input-form col-md-12 mx-auto"> 
		<h4 class="mb-3">회원가입</h4> 
		<form class="validation-form" id="login_form" novalidate> 
			<div class="row"> 
				<div class="col-md-6 mb-3"> 
					<label for="id">ID</label> 
					<input type="text" class="form-control" name="id" id="id" placeholder=""required> 
					<div class="invalid-feedback"> ID를 입력해주세요. </div> 
				</div>
				<div class="col-md-6 mb-3"> 
					<label for="pwd">비밀번호</label> 
					<input type="password" class="form-control" id="pwd"  name = "pwd" placeholder="" required> 
					<div class="invalid-feedback"> 비밀번호를 입력해주세요. </div> 
				</div> 
			</div>
				
			<div class="row"> 
			<div class="col-md-6 mb-3"> 
					<label for="name">이름</label> 
					<input type="text" class="form-control" name="name" id="name" required> 
					<div class="invalid-feedback"> 이름을 입력해주세요. </div> 
				</div>
				<div class="col-md-6 mb-3"> 
					<label for="nickname">별명</label> 
					<input type="text" class="form-control" id="nickname" name="nickname" placeholder="id랑 똑같아도 됩니다" required> 
					<div class="invalid-feedback"> 별명을 입력해주세요. </div> 
				</div> 
			</div>
			
				<div class="col-md-6 mb-3"> 
					<label for="tel">전화번호</label>
					<select id="tel1" name="tel1" size="1" class="col-md-4 mb-3">
						<option value="010">02</option>
						<option value="010">010</option>
						<option value="010">011</option>
						<option value="010">012</option>
					</select>
					<div class="row">
					<div class="col-md-6 mb-3"> 
					<input type="text" class="form-control" id="tel2"  name = "tel2" placeholder="1111" value="" required> 
					</div>
					<div class="col-md-6 mb-3"> 
					<input type="text" class="form-control" id="tel3"  name = "tel3" placeholder="2222" value="" required> 
					</div>
					<div class="invalid-feedback"> 전화번호를 입력해주세요. </div> 
				</div>
				</div>
				
				<div class="mb-3"> 
					<label for="email">이메일</label> 
					<input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" value="" required> 
					<div class="invalid-feedback"> 이메일을 입력해주세요. </div> 
				</div> 
				
				<div class="mb-3"> 
					<label for="address1">주소</label> 
					<input type="text" class="form-control" id="address1" name="address1" placeholder="서울특별시 강남구" value=""  required> 
					<div class="invalid-feedback"> 주소를 입력해주세요. </div> 
				</div> 
					<div class="mb-3"> 
						<label for="address2">상세주소
						<span class="text-muted">&nbsp;(필수 아님)</span>
						</label> 
						<input type="text" class="form-control" id="address2" name="address2" value=""  placeholder="상세주소를 입력해주세요."> 
					</div>
					<div class="row">
					<div class="col-md-3 mb-3"> 
							<label for="postcode">우편번호</label> 
							<input type="text" class="form-control" name="postcode" id="postcode" value=""  placeholder="" required> 
							<div class="invalid-feedback"> 우편번호를 입력해주세요. </div> 
					</div> 
					</div>
					<div class="row"> 
						<div class="col-md-3 mb-3"> 
							<label for="jumin1">주민번호</label> 
							<input type="text" class="form-control" name="jumin1" id="jumin1" value="" placeholder="" required> 
							<div class="invalid-feedback"> 주민번호를 입력해주세요. </div> 
						</div> 
						<div class="col-md-3 mb-3"> 
						<label for="jumin2"></label> 
						<input type="password" class="form-control" name="jumin2" id="jumin2" value="" placeholder="" required> 
							<div class="invalid-feedback"> 뒷자리를 입력해주세요. </div> 
						</div>
						
						<div class="col-md-3 mb-3"> 
						<label for="gender">성별</label><br> 
						<div style="font-size: 40px;">
						<input type="checkbox" name="gender" value="male" required><i class="fas fa-male" style="margin-right:60px"></i>
						<input type="checkbox" name="gender" value="female" required><i class="fas fa-female"></i>
						</div>
					</div> 
					</div>
					
					
					<hr class="mb-4"> 
						<div class="custom-control custom-checkbox"> 
							<input type="checkbox" class="custom-control-input" id="aggrement" required> 
							<label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label> 
							</div> <div class="mb-4"></div> 
							<button class="btn btn-primary btn-lg btn-block" type="submit" onclick="send(this.form)">가입 완료</button> 
					</form> 
				</div> 
			</div> 
			<p class="mb-1">&copy; 2021 YD</p> </footer> 
		</div> 
		<script> window.addEventListener('load', () => { 
			const forms = document.getElementsByClassName('validation-form'); 
			Array.prototype.filter.call(forms, (form) => { 
				form.addEventListener('submit', function (event) { 
					if (form.checkValidity() === false) { 
						event.preventDefault(); 
						event.stopPropagation(); 
						} 
					form.classList.add('was-validated'); 
					}, false); 
				});
			}, false); 
		
		function send(f){
			//check
			//var tel_pattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
			var email_pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
			
			var id = f.id.value.trim();
			var pwd = f.pwd.value.trim();
			var name = f.name.value.trim();
			var nickname = f.nickname.value.trim();
			
			var jumin1 = f.jumin1.value;
			var jumin2 = f.jumin2.value;
			
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
			
			
			if(!email_pattern.test(email)){
				alert("입력된 값은 이메일이 아닙니다.");
				return;
			}
			
			
			f.method = "post";
			f.action = "insert.do";
			f.submit();
		}
		
		</script>
	</body> 
</html>
