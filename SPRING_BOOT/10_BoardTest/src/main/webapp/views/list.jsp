<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px;
	}
</style>
</head>
<body>
	<button onclick="location.href ='logout'">로그아웃</button>
	<button onclick="location.href ='writeForm'">글쓰기</button>
	<table>
 		<tr>
 			<th>글번호</th>
 			<th>제목</th>
 			<th>작성지</th>
 			<th>조회수</th>
 			<th>작성일</th>
 			<th>삭제</th>
 		</tr>

 		<c:forEach items="${list}" var="bbs">
 		<tr>
 			<td><a href="detail?idx=${bbs.idx }">${bbs.idx}</a></td>
 			<td>${bbs.subject}</td>
 			<td>${bbs.user_name}</td>
 			<td>${bbs.bHit}</td>
 			<td>${bbs.reg_date}</td>
 			<td><a href="del?idx=${bbs.idx }">삭제</a> </td>
 		</tr>
 		</c:forEach>
 	</table>

</body>
<script>

</script>
</html>