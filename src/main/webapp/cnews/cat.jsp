<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="inc/header.jsp"%>

  <div class="body">
    <div class="body_resize">
      <div class="left">
        
        <%
        @SuppressWarnings("unchecked")
      	ArrayList<News> listNewsByIdCat = (ArrayList<News>) request.getAttribute("listNewsByIdCat");
      	if(listNewsByIdCat!=null && listNewsByIdCat.size()>0){
      		for(News objNews: listNewsByIdCat){
        %>

		<div class="item">
        	<h2><a href="detail.html" title=""><%=objNews.getName() %></a></h2>
	        <img src="<%=request.getContextPath() %>/cnews/images/img_1.jpg" alt="" width="585" height="156" />
	        <div class="clr"></div>
	        <p><%=objNews.getDescription() %></p>
		</div>

		<%}}else{ %>
		<h4>Không có tin nào!</h4>
		<%} %>
		
      </div>
      
      <%@include file="inc/right-bar.jsp"%>
      
    </div>
  </div>
  
  <%@include file="inc/footer.jsp"%>
