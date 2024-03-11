<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Expression Language Tag (뭔가를 출력 할때 쓰는 법) -->
	<!-- 스크립틀릿의 출력문을 대체 -->
	session 의 내용 출력 : ${sessionScope.sessionId}
	<br/>
	paramter 값 출력 :  ${param.userId}
</body>
</html>