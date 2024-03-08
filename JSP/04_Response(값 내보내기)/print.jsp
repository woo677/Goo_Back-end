<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 페이지 출력은 총 3가지 방법이 있다 -->
	
	
	<%= "<p>첫번째, 스크립틀릿 출력문을 이용한 방법</p>" %>
	<% out.print("<p>두번쨰,out.prin()을 이용한 방법 </p>"); %>
	<% response.getWriter().write("<p>세번쨰,request 객체를 이용한 방법 </p>"); %>
	
	<!-- 
		out 객체는 response 의 자식이다  그렇기 때문에 response 보다 느리다
		스크립틀릿 출력문은 out 객체로 만들어 졌다. 그러므로 둘의 속도는 같다
		그러므로 위에 있는 것이 먼저 찍힌다
		석어서 썻을때 출력 속도를 주의 해라
		response > scriplet == out
		response,out : java 영역
		스크립틀립 출력문 : html 영역
		response 랑scriplet 얘를 섞어 쓰지 말아라
	 -->
</body>
</html>