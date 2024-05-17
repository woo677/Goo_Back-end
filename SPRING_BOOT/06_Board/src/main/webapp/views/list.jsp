<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<style>
		table{
            border: 1px solid black;
            border-collapse: collapse;
        }
		th,td{
			border:1px solid #000;
		}
	</style>
	</head>
	<body>
			<table>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>이름</th>
					<th>조회수</th>					
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.idx}</td>
						<td>${list.subject}</td>
						<td>${list.user_name}</td>
						<td>${list.bHit}</td>
					</tr>			
				</c:forEach>
			</table>
	</body>
	<script>
		
	</script>
</html>