<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  		request.setCharacterEncoding("UTF-8");
  		String email = request.getParameter("email");
  		String phone = request.getParameter("phone");
  		
  		System.out.println("session : "+email+" / "+phone);
  		
  		if(email != null && phone != null){
  			session.setAttribute("email", email);
  			session.setAttribute("phone", phone);
  		}
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href ="result.jsp"> 세션 확인</a>
</body>
</html>