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
	<p>redirect 를 시켜주는 기능 (실제 그 주소로 보내 버린다 (localhost 가 아니라 https://www가 된다))</p>
	<p>redirect 태그가 실행되면 이후 태그는 실행되지 않는다(고로 태그를 넣지 말자)</p>
	<!-- https://www.youtube.com/results?search_query=jsp -->
	<c:redirect url="https://www.youtube.com/results">
		<c:param name="search_query">jsp</c:param>
	</c:redirect>

</body>
</html>