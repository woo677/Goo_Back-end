<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] sports = {"축구","야구","농구","골프","수영","볼링",};
	HashMap<String, String> map= new HashMap<String, String>();
	map.put("name", "kim");
	map.put("age", "37");
	map.put("mobile", "010-1654-4968");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>forEach 는 향상된 for문과 비슷하다</li>
		<li>c:forEach var = "변수" items = "덩어리" begin="시작값" end="끝값  step="증가값"</li>
		<li>item 속성에는 Array,  Collection, Map 등이 올 수 있다</li>
	</ul>
	
	<!-- 일반적인 for 문 처럼 쓸 수 있다 -->
	<c:forEach var="i" begin="1" end="10" step="1">${i}</c:forEach>
	<hr/>
	
	<!-- (향상되 for)  sports 배열에 있는 모든 값을 출력 -->
	<!-- varStatus : 상테를 저장하는 법 (배열의 위치 뽑아내는 법)-->
	<c:forEach var="i" items="<%=sports %>" varStatus="stat" >
		${stat.index}:${i}<br/>
	</c:forEach>
	<hr/>
	
	<!-- sports 배열에 있는 1,2,3 번 인덱스 출력 -->
	<c:forEach var="item" items="<%=sports %>" varStatus="stat" begin="1" end="3" step="1">
	${stat.index}:${item}<br/>
	</c:forEach>
	
	
	<!-- map 에 있는 모든 내용 출력 하기 -->
	<c:forEach var="item" items="<%=map %>">
		${item.key}:${item.value}<br/>
	</c:forEach>
</body>
</html>