<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		<style>
				
		</style>
	</head>
	<body>
			<form action="calc" method="post">
				<input type="text" name="val1"/>
				<!-- select : 선택창 -->
				<select name="oper">
					<option value="+">+</option>
					<option value="-">-</option>
					<option value="*">*</option>
					<option value="/">/</option>
				</select>
				<input type="text" name="val2"/>
				<input type="submit" value="전송"/>
			</form>
	</body>
</html>