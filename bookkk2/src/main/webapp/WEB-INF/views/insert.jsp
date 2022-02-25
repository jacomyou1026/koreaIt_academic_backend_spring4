<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
				<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>BookStore</title>
<link rel="stylesheet" href="resources/css/insert.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>


						
    <%@include file="include/header.jsp" %>	
    
    
    			
		<div class="content_area">
 						               <div class="admin_content_main">
                    	<form action="/insert" method="post" id="enrollForm" enctype="multipart/form-data">
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>책 제목</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="subject">
                    			</div>
                    		</div>
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>작가</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="author" >
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>출판일</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="publishDate" autocomplete="off" readonly="readonly">
                    			</div>
                    		</div>            
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>출판사</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="publisher">
                    			</div>
                    		</div>             
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>책 카테고리</label>
                    			</div>
                    			<div class="form_section_content">
											<div class="cate_wrap">
												<span>대분류</span>
												<select class="cate1">
													<option selected value="none">선택</option>
												</select>
											</div>
											<div class="cate_wrap">
												<span>중분류</span>
												<select class="cate2">
													<option selected value="none">선택</option>
												</select>
											</div>
											<div class="cate_wrap">
												<span>소분류</span>
												<select class="cate3" name="categoryNum">
													<option selected value="none">선택</option>
												</select>
											</div> 
	

                    			</div>
                    		</div>          
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 가격</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="price">
                    			</div>
                    		</div>               
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>상품 재고</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="stock" >
                    			</div>
                    		</div>          
								<div class="inputArea">
								 <label for="img">이미지</label>
								 <input type="file" id="img" name="file" />
								 <div class="select_img"><img src="" /></div>
								 <%=request.getRealPath("/") %>
								</div>                     			
                  
                     
                     		          		
                    		<div class="form_section">
                    			<div class="form_section_title">
                    				<label>책 소개</label>
                    			</div>
                    			<div class="form_section_content">
                    				<input name="intro">
                    			</div>
                    		</div>        		
                   		</form>
                   			<div class="btn_section">
                   				<button id="cancelBtn" class="btn">취 소</button>
	                    		<button id="enrollBtn" class="btn enroll_btn">등 록</button>
	                    	</div> 
                    </div>  
		
		</div>


    <%@include file="include/footer.jsp" %>	

 <script>
  $("#img").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".select_img img").attr("src", data.target.result).width(500);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });
  
 </script>



					    <script>
					    
					  //start jQuery
						$(function() {
					//검색 버튼 이벤트 처리
					$("#searchBtn").click(function() {
						console.log("검색 버튼이 클릭됨!");
						const keyword = $("#keywordInput").val();
						console.log("검색어: " + keyword);
						
						const condition = $("#condition option:selected").val();
						console.log("검색 조건: " + condition);
						
						location.href="bookListSearch?page="+ ${pc.paging.page} + "&countPerPage="+${pc.paging.countPerPage} + "&keyword=" + keyword + "&condition="+condition;
						
					}); 
					
					
					//엔터키 입력 이벤트
					$("#keywordInput").keydown(function (key) {
						 
				        if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
				        	$("#searchBtn").click();
				        }
				 
				    });		
					
					
						});//end jQuery
				    </script>
				    

<script>

	let enrollForm = $("#enrollForm")
	
/* 취소 버튼 */
$("#cancelBtn").click(function(){
	
	location.href="/admin/goodsManage"
	
});

/* 상품 등록 버튼 */
$("#enrollBtn").on("click",function(e){
	
	e.preventDefault();
	
	enrollForm.submit();
	
});

/* 설정 */
const config = {
	dateFormat: 'yy/mm/dd',
	showOn : "button",
	buttonText:"날짜 선택",
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dayNames: ['일','월','화','수','목','금','토'],
    dayNamesShort: ['일','월','화','수','목','금','토'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
    yearSuffix: '년',
    changeMonth: true,
    changeYear: true
}
/* 캘린더 */
$(function() {
  $( "input[name='publishDate']" ).datepicker(config);
});



/* 카테고리 */
let cateList = JSON.parse('${cateList}');
let cate1Array = new Array();
let cate2Array = new Array();
let cate3Array = new Array();
let cate1Obj = new Object();
let cate2Obj = new Object();
let cate3Obj = new Object();

let cateSelect1 = $(".cate1");		
let cateSelect2 = $(".cate2");
let cateSelect3 = $(".cate3");

/* 카테고리 배열 초기화 메서드 */
function makeCateArray(obj,array,cateList, tier){
	for(let i = 0; i < cateList.length; i++){
		if(cateList[i].tier === tier){
			obj = new Object();
			
			obj.cateName = cateList[i].cateName;
			obj.categoryNum = cateList[i].categoryNum;
			obj.cateParent = cateList[i].cateParent;
			
			array.push(obj);				
			
		}
	}
}	

/* 배열 초기화 */
makeCateArray(cate1Obj,cate1Array,cateList,1);
makeCateArray(cate2Obj,cate2Array,cateList,2);
makeCateArray(cate3Obj,cate3Array,cateList,3);

/*
$(document).ready(function(){
	console.log(cate1Array);
	console.log(cate2Array);
	console.log(cate3Array);
});
*/

/* 대분류 <option> 태그 */
for(let i = 0; i < cate1Array.length; i++){
	cateSelect1.append("<option value='"+cate1Array[i].categoryNum+"'>" + cate1Array[i].cateName + "</option>");
}


/* 중분류 <option> 태그 */
$(cateSelect1).on("change",function(){
	
	let selectVal1 = $(this).find("option:selected").val();	
	
	cateSelect2.children().remove();
	cateSelect3.children().remove();
	
	cateSelect2.append("<option value='none'>선택</option>");
	cateSelect3.append("<option value='none'>선택</option>");
	
	for(let i = 0; i < cate2Array.length; i++){
		if(selectVal1 === String(cate2Array[i].cateParent)){
			cateSelect2.append("<option value='"+cate2Array[i].categoryNum+"'>" + cate2Array[i].cateName + "</option>");	
		}
	}// for
	
});

/* 소분류 <option>태그 */
$(cateSelect2).on("change",function(){
	
	let selectVal2 = $(this).find("option:selected").val();
	
	cateSelect3.children().remove();
	
	cateSelect3.append("<option value='none'>선택</option>");		
	
	for(let i = 0; i < cate3Array.length; i++){
		if(selectVal2 === String(cate3Array[i].cateParent)){
			cateSelect3.append("<option value='"+cate3Array[i].categoryNum+"'>" + cate3Array[i].cateName + "</option>");	
		}
	}// for		
	
});		
</script> 	
</body>
</html>