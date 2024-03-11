<%@page import="javax.sound.midi.Sequence"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("id");
    	String pass = request.getParameter("pass");
    	System.out.print(id+"/"+pass); // id/pass
    	
    	if(id.equals("admin") && pass.equals("pass")){ //일치할 경우
    		session.setAttribute("longinId", id); //session 에서 loginId 값이 존대한다 == 로그인을 했다는 증표
    		
    	}else{ //일치하지 않을 경우
    		response.sendRedirect("./login.jsp"); 
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>login success</h2>
	<h3>LOGIN ID <%= session.getAttribute("loginId") %></h3>
	<input type="button" value="logout" onclick="location.href = ' ' "/>
</body>
</html>