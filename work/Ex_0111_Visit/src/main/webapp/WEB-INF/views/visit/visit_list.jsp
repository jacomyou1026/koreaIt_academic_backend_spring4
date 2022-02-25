<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <!-- pageContext.request.contextPath : webapp폴더까지의 경로 -->
	<link rel="stylesheet" 
	href="${ pageContext.request.contextPath }/resources/css/visit.css">
	
	<!-- Ajax를 위한 httpRequest.js참조 -->
	<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>

	<script>
		function modify( f ){
			//수정
			var pwd = f.pwd.value;
			
			var c_pwd = f.c_pwd.value;
			var idx = f.idx.value;
			
			if( pwd != c_pwd ){
				alert("비밀번호가 올바르지 않습니다");
				return;
			}
			
			f.action = "modify_form.do";
			f.method = "post";
			f.submit();
			
		}
		function del( f ) {
			//삭제
			var pwd = f.pwd.value; //원본 비밀번호
			var c_pwd = f.c_pwd.value; //지우려고 입력한 비밀번호
			var idx = f.idx.value;//삭제를 위한 게시물의 일련번호
			
			if( pwd != c_pwd ){
				alert(pwd);
				alert("비밀번호가 올바르지 않습니다");
				return;
			}
			
			//삭제확인
			if( !confirm("정말 삭제하시겠습니까?") ){
				return;
			}
			
			//삭제하고싶은 게시물의 idx를 Ajax를 통해 컨트롤러로 전달
			var url = "delete.do";
			var param = "idx="+idx;
			sendRequest(url, param, resultFn, "POST");
		}
			
		/* 삭제결과를 돌려받을 콜백메서드 */
		function resultFn(){
			if( xhr.readyState == 4 && xhr.status == 200 ){
				
				//삭제성공 여부에 따라서 경고창을 띄우자
				var data = xhr.responseText;//"no" or "yes"
				
				if( data == 'no' ){
					alert("삭제실패. 관리자에게 문의하세요");
					return;
				}
				
				alert("삭제성공");
				location.href = "list.do";
			}
				
		}
		
	</script>

</head>
<body>
	<div id="main_box">
		<h1>::: 방명록 :::</h1>
		
		<div align="center">
			<input type="button" value="새 글 쓰기" onclick="location.href='insert_form.do'">
		</div>
		
		<c:forEach var="vo" items="${ list }">
			
			<div class="visit_box">
				
				<div class="type_content"><pre>${ vo.content }</pre><br>
					<!-- 첨부된 이미지가 있을때만 -->	
					<c:if test ="${vo.filename ne 'no_file' }">
					
						<img src="${ pageContext.request.contextPath }/resources/upload/${vo.filename}"
								 width="200">
					</c:if>
				</div>
				<div class="type_name">작성자:${ vo.name }(${ vo.ip })</div>
				<div class="type_regdate">작성일:${ vo.regdate }</div>
				
				<div class="type_bottom">
					<form>
						<input type="hidden" name="idx" value="${ vo.idx }">
						<input type="hidden" name="pwd" value="${ vo.pwd }">
						
						비밀번호:<input type="password" name="c_pwd">
						
						<input type="button" value="수정" onclick="modify(this.form);">
						<input type="button" value="삭제" onclick="del(this.form);">
					</form>
				</div>
				
			</div>
			
		</c:forEach>
	</div>
</body>
</html>















