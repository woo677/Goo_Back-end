<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 태그가 완전히 종결된 이후나 아예 처음에 주석을 넣을것 -->
	<jsp:include page="header.jsp"/>
	
	<!-- 파라미터 추가 -->
	<jsp:include page="body.jsp"/>
		<jsp:param value="my content" name="name"/>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>