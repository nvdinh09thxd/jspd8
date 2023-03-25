<%@page import="dao.CatDao"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="right">
	<h2>Danh mục</h2>
	
	<%
	ArrayList<Category> listCat = CatDao.getItems();
	if(listCat.size()>0){
	%>
	
	<ul>
	<%
		for(Category objCat: listCat){
	%>
		<li><a href="<%=request.getContextPath()%>/danh-muc?cid=<%=objCat.getId()%>"><%=objCat.getName() %></a></li>
	<%
		}
	%>
	</ul>
	<%} %>
	
</div>
<div class="clr"></div>