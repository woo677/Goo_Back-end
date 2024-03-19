<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		<style>
				table,  th, td{
					border: 1px solid black;
					border-collapse: collapse; 
				}
				th , td{
					pause: 5px 10px
				}
		</style>
	</head>
	<body>
			<h2>회원관리 시스템 로그인</h2>
			<form action="login" method="post">
					<table>
						<tr>
								<th>ID</th>
								<td><input type="text" name="id"/></td>
						</tr>
						<tr>
								<th>PW</th>
								<td><input type="password" name="pw"/></td>
						</tr>
						<tr>
								<th colspan="2">
									<input type="submit" value="login"/>
									<input type="button" value="회원가입"/>
								</th>
						</tr>
					</table>
			</form>
			${msg }
	</body>
	<script>
		var msg = '${msg}';//''이 없으면 변수로 인식한다
		if(msg !=''){
			alert(msg);
			
		}
	
		// 회원 가입 페이지로 가기
		$('input[type = "button"]').on('click',function(){
			console.log('click');
			//spring 에서는 jsp 이동도 controller 를 통해야 한다(포스방식)
			location.href='joinForm';
		})
	</script>
</html>