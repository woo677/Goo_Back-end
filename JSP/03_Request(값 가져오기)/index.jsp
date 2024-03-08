<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		table, td{
			border: 1px solid black;
			border-collapse : collapse; 
		}
		td{
			padding: 5px 10px;
		}
		
</style>
</head>
<body>
	<h3>회원정보</h3>
	<!-- action(앸션) 내가 값을 보낼 파일 위치 -->
	<!-- <form action="result.jsp" method="get"> -->
	 <form action="jsUse.jsp" method="get">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<!-- 라디오 중복 선택이 불가능 -->
					<input type="radio" name="gender" value="남자"/>남
					<input type="radio" name="gender" value="여자"/>여
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<!-- 체크박스는 여러개의 값이 정송될 수 있다 -->
				<td>
					<input type="checkbox" name="hobby" value="독서"/>독서
					<input type="checkbox" name="hobby" value="게임"/>게임
					<input type="checkbox" name="hobby" value="축구"/>축구
					<input type="checkbox" name="hobby" value="영화"/>영화
				</td>
			</tr>
			<tr>
			<!-- colspan 테이블을 합친다 -->
				<td colspan="2" style="text-align : center">
				<!-- submit 설정한 서버로 값을 보내는 버튼 -->
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>