<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 페이지를 원래 내거 인 것처럼 합친다 include(포함하다)-->
<%@ include file="header.jsp" %>
	<h3>여기는 메인 영역 입니다</h3>
	

	<ul>
	<% for(int i =0 ; i<=10; i++){%>
		<li><%=i %></li>
	<% }%> 
	</ul>

<%@ include file ="footer.jsp" %>
</body>
</html>