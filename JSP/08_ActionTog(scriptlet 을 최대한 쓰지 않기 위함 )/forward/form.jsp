<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="stopPage.jsp" method="post">
	<!-- hidden : 데이터를 전달하는 걸 보여주고 싶지 않을때 -->
		<input type="hidden" name="forwardPage" value="result.jsp"/>
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td><input type="submit" value="전송"/></td>
			</tr>
		</table>
	</form>
</body>
</html>