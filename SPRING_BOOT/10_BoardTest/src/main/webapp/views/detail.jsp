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
		<h1>디테일</h1>
		<table>
			<tr>
				<td>글번호</td>
				<th>${dto.idx }</th>
			</tr>
			<tr>
				<td>조회수</td>
				<th>${dto.bHit }</th>
			</tr>
			<tr>
				<td>제목</td>
				<th>${dto.subject} </th>
			</tr>
			<tr>
				<td>내용</td>
				<th>${dto.content} </th>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location.href='./list'">리스트</button>
					<button onclick="location.href ='modify?idx=${bbs.idx }'">수정</button>
				</td>
			</tr>
		</table>
	</body>
	<script>
	location.href ='modify
	</script>
</html>