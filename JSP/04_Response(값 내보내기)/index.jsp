<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<p><a href="print.jsp">각 객체별 페이지 출력(response, Out, scriplet)</a></p>
 	<p><a href="response.jsp">response 객체로 다른 페이지 이동</a></p>
 	<!-- response 활용 -->
 	<form action="response.jsp" method="post">
	 	<input type="text" name="name"/>
	 	<input type="submit" name="전송"/>
 	</form>
</body>
</html>