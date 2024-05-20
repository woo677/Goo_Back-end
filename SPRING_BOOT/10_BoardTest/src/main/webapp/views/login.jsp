<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<style>
		table, td, th{
					border: 1px solid black;
					border-collapse: collapse; 
				}
	</style>
	</head>
	<body>
		<h1>로그인 페이지</h1>
		<form action="login.do"  method="post">
		<table>
			<tr>
				<th>
					ID : 
				</th>
				<td>
					<input type="text" name="id"/><br/>
				</td>
				
			</tr>
			<tr>
				<th>
					PW : 
				</th>
				<td>
					<input type="text" name="pw"/><br/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인"/>
				</td>
			</tr>
		</table>
		</form>
	</body>
	<script>
		var msg = '${msg}';
		if (msg != '') {
		alert(msg);			
		}
	</script>
</html>