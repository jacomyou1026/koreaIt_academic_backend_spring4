<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	 function comment(a){
		var review_div = document.getElementById("nonComment"+a);
		if(review_div.style.display =='none')
			review_div.style.display = 'block';
		else if(review_div.style.display == 'block')
			review_div.style.display ='none';	 
		
	}
	 
	 


</script>
	<style>
		a{text-decoration: none;}
	</style>
	<div class="rievew_all">
		<h2>회원리뷰</h2>
		<%@include file="review_write.jsp" %>	
		<ul class="board_list">
				<li>
					<c:if test="${review_list ne null}">
					<c:forEach var="vo" items="${review_list}" varStatus="a">
						<input type="hidden" name="check" value="${vo.reviewNum }">
						<!-- 대댓글 색상표기 -->
						<div class="comment_wrap"style="<c:if test="${ vo.depth ne 0}">background-color:rgb(247,247,253); float:clear;</c:if>">
						<!-- 댓글 들여쓰기 -->
							<c:forEach begin="1" end="${vo.depth }" >	
								<div style="float:left;">
									&nbsp;ㄴ &nbsp;
								</div>
							</c:forEach>
							
							 <dl class="review_dl">
									<dt class="id">${vo.id}</dt>
									<dd class="date">${vo.regdate}	</dd>
									<dd class="rating"><%@include file="static_star-rating.jsp" %> </dd>
									<dd class="comment"><pre>${vo.content}</pre></dd>
									<c:if test="${vo.rating ne 0 }">
										<dd><input type="button" id="comment_btn" value="댓글달기" onclick="comment('${vo.reviewNum }')" ></dd>	
									</c:if>
								</dl>
							
						</div>
						<!-- 대댓글 창 -->
						<div class="big_comment_wrap">	
								<dl>
									<dd id="nonComment${vo.reviewNum}" style="display:none;padding:10px"> 
										ㄴ ${vo.id}님의 대한 댓글
										<%@include file="review_write.jsp" %>	
									</dd>
								</dl>
						</div>
					</c:forEach>
					</c:if>
				</li>
				<li >
					<div id ="pageMenu" style="text-align:center;">
						${ pageMenu }
					</div>
				</li>
		</ul>
	</div>