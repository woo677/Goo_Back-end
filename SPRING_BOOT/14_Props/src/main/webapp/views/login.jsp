<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>::LOGIN PAGE::</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>

</style>
</head>
<body>
	<h2>관리자 로그인</h2>

	<form action="login" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" placeholder="아이디"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw" placeholder="패스워드"></td>
			</tr>
			<tr>
				<th colspan="2">
					 <input type="submit" value="로그인"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
var msg = '${msg}';
if(msg != ''){
	alert(msg);
}
</script>
</html>