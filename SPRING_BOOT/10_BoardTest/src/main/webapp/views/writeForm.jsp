<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link rel="stylesheet" href="css/common.css" type="text/css">
	<style>

	</style>
	</head>
	<body>
	<form action="write.do" method = "post">
	<table>
		<tr>
			<th>제목</th>
			<td><input type ="text" name = "subject"/></td>
		</tr>	
		<tr>
			<th>작성자</th><!-- sessionScope.loginId는 세션에 있는 값을 가져온다 -->
			<td><input type ="text" name = "user_name" value="${sessionScope.loginId}" readonly/></td>
		</tr>
		<tr>
		<th>내용</th>
			<td><textarea name="content"></textarea></td>
		</tr>
		<tr>
			<th colspan="2"><!-- ./list ./는(지금있는 위치) 상대경로다 -->
			<input type="button" onclick="location.href='./list'" value="취소"/>
			<button>글쓰기</button>
			</th>
		</tr>
	</table>
	</form>
	</body>
	<script>
		
	</script>
</html>