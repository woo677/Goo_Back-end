<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>


<meta charset="UTF-8">
<title>::회원가입 페이지::</title>
<link rel="stylesheet" href="/resources/css/common.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
</style>
</head>
<body>
	<h2>::회원가입::</h2>
	<hr />
	<form action="join.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" placeholder="아이디를 입력해주세요" />
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"
					placeholder="비밀번호를 입력하세요" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" placeholder="이름을 입력하세요" /></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="남" />남자
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="radio" name="gender" value="여" />여자
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<th colspan="2"><button>회원가입</button> </th>
			</tr>
		</table>
	</form>
	
</body>
<script>
</script>
</html>