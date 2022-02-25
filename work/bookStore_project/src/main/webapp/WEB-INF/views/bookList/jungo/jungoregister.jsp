<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>BookStore</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bookList/jungo/jungoregister.css"/>
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

</head>
<body>


						
    <%@include file="../../include/jungoheader.jsp" %>	
    
    			
		<div class="content_area">
		
		
	    		<%@include file="../../include/jungo_nav.jsp" %>   
                        
                        
						  <div class ="content">
                            <div id ="main_box">
                            	
                            

                    
                <div class="jungo_reg">
                <span>중고 상품 등록</span>
                </div>

                <div class="register_box">
                        <form action="/jungoregister" method="post" id="enrollForm" enctype="multipart/form-data">
                           	<input type="hidden" id="id" name="id" value= <%=session.getAttribute("id")%>>
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>책 제목</label>
                                </div>
                                <div class="register_content">
                                    <input name="Jsubject">
                                </div>
                            </div>
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>작가</label>
                                </div>
                                <div class="register_content">
                                    <input name="Jauthor" >
                                </div>
                            </div>            
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>출판일</label>
                                </div>
                                <div class="register_content">
                                    <input name="JpublishDate" autocomplete="off" readonly="readonly">
                                </div>
                            </div>            
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>출판사</label>
                                </div>
                                <div class="register_content">
                                    <input name="Jpublisher">
                                </div>
                            </div>             
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>책 카테고리</label>
                                </div>
                                <div class="register_content">
                                            <div class="cate_wrap">
                                                <span>1차분류</span>
                                                <select class="cate1">
                                                    <option selected value="none">선택</option>
                                                </select>
                                            </div>
                                            <div class="cate_wrap">
                                                <span>2차분류</span>
                                                <select class="cate2">
                                                    <option selected value="none">선택</option>
                                                </select>
                                            </div>
                                            <div class="cate_wrap">
                                                <span>3차분류</span>
                                                <select class="cate3" name="categoryNum">
                                                    <option selected value="none">선택</option>
                                                </select>
                                            </div> 
    

                                </div>
                            </div>          
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>상품 가격</label>
                                </div>
                                <div class="register_content">
                                    <input name="Jprice">
                                </div>
                            </div>               
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>상품 재고</label>
                                </div>
                                <div class="register_content">
                                    <input name="Jstock" >
                                </div>
                            </div>          
                                <div class="resgister_form">
                                 <label>이미지</label><br/>
                                 <input type="file" id="Jimg" name="file" />
                                 <div class="select_img"><img src="" /></div>
                                </div>                              
                  
                    
                            
                            <div class="resgister_form">
                                <div class="register_title">
                                    <label>책 소개</label>
                                </div>
                                <div class="register_content bbb">
                                    <textarea id ="txt" name="Jintro"></textarea>
                                </div>
                            </div>                            
                            
                                          
                        </form>
                            <div class="btn_section">
                                <button id="cancelBtn" class="btn">취 소</button>
                                <button id="enrollBtn" class="btn enroll_btn">등 록</button>
                            </div> 

                    </div>  

   
                            
                            
                            
                            
                            </div> 
                        </div>
                <div class="clearfix"></div>  

		</div>


    <%@include file="../../include/footer.jsp" %>	



 <script>
 $(document).ready(function(){
	 
	 
  $("#Jimg").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".select_img img").attr("src", data.target.result).width(200);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });

					    
	//검색 버튼 이벤트 처리
	$("#searchBtn").click(function() {
		const keyword = $("#keywordInput").val();
		const condition = $("#condition option:selected").val();
		location.href="jungoSearch?page=1&countPerPage="+${search.countPerPage} + "&keyword=" + keyword + "&condition="+condition;						
	}); 


//엔터키 입력 이벤트
$("#keywordInput").keydown(function (key) {
	 
       if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
       	$("#searchBtn").click();
       }

   });		
					
					
						

let enrollForm = $("#enrollForm")

/* 취소 버튼 */
$("#cancelBtn").click(function(){
	
	location.href="/sellerPage?id="${param.id};
	
});

// 상품 등록 버튼  유효성검사 포함
$("#enrollBtn").on("click",function(e){
	
	e.preventDefault();
	
	//유효성검사
	let subjectCk = false;
	let authorCk = false;
	let publishDateCk = false;
	let publisherCk = false;
	let categoryNumCk = false;
	let priceCk = false;
	let stockCk = false;
	let introCk = false;
	let imgCk = false;
	
	let Jsubject = $("input[name='Jsubject']").val();
	let Jauthor = $("input[name='Jauthor']").val();
	let JpublishDate = $("input[name='JpublishDate']").val();
	let Jpublisher = $("input[name='Jpublisher']").val();
	let categoryNum = $("select[name='categoryNum']").val();
	let Jprice = $("input[name='Jprice']").val();
	let Jstock = $("input[name='Jstock']").val();
	let Jintro = $("textarea#txt").val();

	// 숫자 유효성 검사
	var num_check=/^[0-9]*$/;
	
	
	if(Jsubject){
		subjectCk = true;
	} else {
		alert("아이디를 입력해주세요.");
		subjectCk = false;
	}
	if(Jauthor){
		authorCk = true;
	} else {
		alert("지은이를 입력해주세요.");
		authorCk = false;
	}
	if(JpublishDate){
		publishDateCk = true;
	} else {
		alert("출판날짜 입력해주세요.");
		publishDateCk = false;
	}
	if(Jpublisher){
		publisherCk = true;
	} else {
		alert("출판사를 입력해주세요.");
		publisherCk = false;
	}	
	if(categoryNum != 'none'){
		categoryNumCk = true;
	} else {
		alert("카테고리번호를 입력해주세요.");
		categoryNumCk = false;
	}
	if(num_check.test(Jprice)){
		priceCk = true;
	} else {
		alert("가격란에는 숫자를 입력해주세요.");
		priceCk = false;
	}
	if(num_check.test(Jstock) ){
		stockCk = true;
	} else {
		alert("상품재고란에는 숫자를 입력해주세요.");
		stockCk = false;
	}
	if($('#Jimg').val() != ""){
		imgCk = true;
	} else {
		alert("이미지를 등록해주세요.");
		imgCk = false;
	}
	
	if(Jintro){
		introCk = true;
	} else {
		alert("책소개를 입력해주세요.");
		introCk = false;
	}
	
	if(subjectCk && authorCk && publishDateCk && publisherCk && categoryNumCk && priceCk && stockCk && imgCk && introCk ){
		enrollForm.submit();
	} else {
		return false;
	}

	
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
  $( "input[name='JpublishDate']" ).datepicker(config);
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
 });	
    </script>
</body>
</html>