<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <style>
    table{width: 350px;
		  height: 120px;
		  text-align:center;}
	#t1{padding:0px 0px 0px 80px;}
    </style>
    
    
    
    
    	<div class="wrapper">
			<div class="wrap">

        		   			<%@include file="nav.jsp" %>	
						<div class="top_area">
							<div class="logo_area">
								<a href="/main">
				                    <img src="resources/img/Logo.jpg">
								</a>
							</div>
							<div class="search_area">
							
							 
                                         <div class="search_select">
                                                <select id="condition"  name="condition">    
                                                    <option value="subject" ${param.condition == 'subject' ? 'selected' : ''}>제목</option>
                                                    <option value="publisher" ${param.condition == 'publisher' ? 'selected' : ''}>출반사</option>
                                                    <option value="author" ${param.condition == 'author' ? 'selected' : ''}>지은이</option>
                                                </select>
                                        </div>
                                    
                                        <div class="search_content">
                                                        <div class ="search_box">
                                                            <input type="text" name="keyword" id="keywordInput" value="${param.keyword}"  placeholder="검색어 입력">
                                                            <button id="searchBtn"  type="button">검색</button>
                                                        </div>
                                        </div>
				                    
							</div>
							
							
							
							<div class="login_area">


	
								<%session = request.getSession();%>
								<% if(session.getAttribute("id") != null){ %>
								<table border="1" >
									<tr>
										<td colspan="2">
												<%out.print(session.getAttribute("id") + "님 환영합니다."+ "<br>"); %>	
										</td>
									</tr>
									
									<tr>
										<td>교보코인</td>
										<td id="t1">
											<%out.print(session.getAttribute("money")); %>
										</td>
									</tr>
									<tr>
										<td>마일리지</td>
										<td id="t1">
											<%out.print(session.getAttribute("point")); %>
										</td>
									</tr>
								</table>
								<%} else{%>
									로그인 해주세요
								<%} %>


				            </div>
							<div class="clearfix"></div>			
						</div>
   							 <%@include file="category_nav.jsp" %>	
						