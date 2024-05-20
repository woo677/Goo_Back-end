<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<style>
			table,th,td{
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px 10px
		}
	</style>
	</head>
	<body>
		<h1>디테일</h1>
		<table>
			<tr>
				<td>글번호</td>
				<th>${bbs.idx }</th>
			</tr>
			<tr>
				<td>조회수</td>
				<th>${bbs.bHit }</th>
			</tr>
			<tr>
				<td>제목</td>
				<th>${bbs.subject} </th>
			</tr>
			<tr>
				<td>내용</td>
				<th>${bbs.content} </th>
			</tr>
			<tr>
				<td colspan="2">
					<a href="./list">리스트 돌아가기</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>수정</button>
				</td>
			</tr>
		</table>
	</body>
	<script>
		
	</script>
</html>