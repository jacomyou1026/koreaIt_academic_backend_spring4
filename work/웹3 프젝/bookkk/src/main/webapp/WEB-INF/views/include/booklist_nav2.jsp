<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


                                 <div class="booklist_nav">
                                        <div class="booklist_ul">
                                             <span>홈 > 외국도서</span> 
                       			   					<c:if test="${param.c == 201000}">
                                            			<span> > 문학</span>
                                            		</c:if>
		                                            		<c:if test="${param.c == 201001}">
		                                            			<span> > 문학 > 소설</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 201002}">
		                                            			<span> > 문학 > 시</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 201003}">
		                                            			<span> > 문학 > 희곡</span>
		                                            		</c:if>
                                            		
                                            		<c:if test="${param.c == 202000}">
                                            			<span> > 인문/사회</span>
                                            		</c:if>
		                                            		<c:if test="${param.c == 202001}">
		                                            			<span> > 인문/사회 > 교양</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 202002}">
		                                            			<span> > 인문/사회 > 철학</span>
		                                            		</c:if>
                                            		<c:if test="${param.c == 203000}">
                                            			<span> > 경제/경영</span>
                                            		</c:if>
		                                            		<c:if test="${param.c == 203001}">
		                                            			<span> > 경제/경영 > 경제학</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 203002}">
		                                            			<span> > 경제/경영 > 경영학</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 203003}">
		                                            			<span> > 경제/경영 > 투자</span>
		                                            		</c:if>
                                            		<c:if test="${param.c == 204000}">
                                            			<span> > 과학/기술</span>
                                            		</c:if>
 		                                            		<c:if test="${param.c == 204001}">
		                                            			<span> > 과학/기술 > 교양과학</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 204002}">
		                                            			<span> > 과학/기술 > 물리학</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 204003}">
		                                            			<span> > 과학/기술 > 수학</span>
		                                            		</c:if>
                                            		
                                        </div>
                                       	<div class="booklist_sub">
                                            <span>도서 목록</span>
                                        </div>
                                    </div>  