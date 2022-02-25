<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                                 <div class="booklist_nav">
                                        <div class="booklist_ul">
                                             <span>홈 > 국내도서</span> 
                       			   					<c:if test="${param.c == 101000}">
                                            			<span> > 소설</span>
                                            		</c:if>
		                                            		<c:if test="${param.c == 101001}">
		                                            			<span> > 소설 > 한국소설</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 101002}">
		                                            			<span> > 소설 > 영미소설</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 101003}">
		                                            			<span> > 소설 > 일본소설</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 101004}">
		                                            			<span> > 소설 > 중국소설</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 101005}">
		                                            			<span> > 소설 > 러시아소설</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 101006}">
		                                            			<span> > 소설 > 프랑스소설</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 101007}">
		                                            			<span> > 소설 > 독일소설</span>
		                                            		</c:if>
                                            		
                                            		<c:if test="${param.c == 102000}">
                                            			<span> > 에세이</span>
                                            		</c:if>
		                                            		<c:if test="${param.c == 102001}">
		                                            			<span> > 에세이 > 한국시</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 102002}">
		                                            			<span> > 에세이 > 해외시</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 102003}">
		                                            			<span> > 에세이 > 테마에세이</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 102004}">
		                                            			<span> > 에세이 > 나라별에세이</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 102005}">
		                                            			<span> > 에세이 > 인물/자전적에세이</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 102006}">
		                                            			<span> > 에세이 > 청소년 시/에세이</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 102007}">
		                                            			<span> > 에세이 > 시/에세이문고</span>
		                                            		</c:if>                                            		
                                            		<c:if test="${param.c == 103000}">
                                            			<span> > 경제/경영</span>
                                            		</c:if>
		                                            		<c:if test="${param.c == 103001}">
		                                            			<span> > 경제/경영 > 경영일반</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 103002}">
		                                            			<span> > 경제/경영 > 경잉이론</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 103003}">
		                                            			<span> > 경제/경영 > 경영관리</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 103004}">
		                                            			<span> > 경제/경영 > 경영전략</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 103005}">
		                                            			<span> > 경제/경영 > 경제일반</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 103006}">
		                                            			<span> > 경제/경영 > 경제이론</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 103007}">
		                                            			<span> > 경제/경영 > 경제실무</span>
		                                            		</c:if>                                                		
                                            		<c:if test="${param.c == 104000}">
                                            			<span> > 인문</span>
                                            		</c:if>
 		                                            		<c:if test="${param.c == 104001}">
		                                            			<span> > 인문 > 인문학일반</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 104002}">
		                                            			<span> > 인문 > 심리학</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 104003}">
		                                            			<span> > 인문 > 교육학</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 104004}">
		                                            			<span> > 인문 > 유아교육</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 104005}">
		                                            			<span> > 인문 > 특수교육</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 104006}">
		                                            			<span> > 인문 > 임용고시</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 104007}">
		                                            			<span> > 인문 > 철학</span>
		                                            		</c:if>                                           		
                                            		<c:if test="${param.c == 105000}">
                                            			<span> > IT</span>
                                            		</c:if>
 		                                            		<c:if test="${param.c == 105001}">
		                                            			<span> > IT > 컴퓨터공학</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 105002}">
		                                            			<span> > IT > IT일반</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 105003}">
		                                            			<span> > IT > OS</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 105004}">
		                                            			<span> > IT > 네트워크</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 105005}">
		                                            			<span> > IT > 보안/해킹</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 105006}">
		                                            			<span> > IT > 데이터베이스</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 105007}">
		                                            			<span> > IT > 개발방법로</span>
		                                            		</c:if>                                               		
                                            		<c:if test="${param.c == 106000}">
                                            			<span> > 요리</span>
                                            		</c:if>                                     		
	                                          		  		<c:if test="${param.c == 106001}">
		                                            			<span> > 요리 > 요리일반</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 106002}">
		                                            			<span> > 요리 > 요리에세이</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 106003}">
		                                            			<span> > 요리 > 테마별요리</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 106004}">
		                                            			<span> > 요리 > 베이킹/간식</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 106005}">
		                                            			<span> > 요리 > 계절요리</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 106006}">
		                                            			<span> > 요리 > 재료별요리</span>
		                                            		</c:if>
		                                            		<c:if test="${param.c == 106007}">
		                                            			<span> > 요리 > 나라별요리</span>
		                                            		</c:if>                                              		
                                            		
                                        </div>
                                         <div class="booklist_sub">
                                            <span>도서 목록</span>
                                        </div>
                                    </div>  