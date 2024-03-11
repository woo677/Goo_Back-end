<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 빈(데이터를 담고 있는 자바 파일) 등록 -->
    <!-- id : 호출시 이름,  class : 사용할 빈의 위치와 클래스, scope : 사용영역(page, request, session, application) -->
   	<jsp:useBean id="firstBean" class="com.beans.FirstBean" scope="page"/>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>name : <%=firstBean.getName() %></h3>
	<a href="exam/form.jsp">bean 사용 예제</a>
</body>
</html>