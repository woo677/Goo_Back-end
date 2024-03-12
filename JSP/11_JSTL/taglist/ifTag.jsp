<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>자바에서 if 문과 비슷한 기능을 제공한다</li>
		<li>사용법 : c:if test= "조건" var="변수 명"</li>
		<li>var 안에는 test 안의 조건 결과(true|false)를 지정된 변수에 저장 할 수 있다</li>
		<li>c:if 에는 else 가 없다</li>
	</ul>
	
	<!-- 기존에 쓰던 방식 -->
	<%
		if(true){%>
			항상 실행 된다<br/>
		<%}%>
		
	<!-- c 테그를 이용한 방식 -->
		<c:if test="true">
			항상 실행 된다<br/>
		</c:if>
		
		<!-- 변수 선언 -->
		<c:set var = "myId">admin2</c:set>
		
		<c:if test="${myId == 'admin' }">
			myId 는 admin이 맞습니다<br/>
		</c:if>
		
		<c:if test="${myId != 'admin' }">
				myId 는 admin이 아닙니다<br/>
			</c:if>
		
</body>
</html>