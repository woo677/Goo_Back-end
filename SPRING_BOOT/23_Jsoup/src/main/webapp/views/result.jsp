<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<style>
		div{
			/* margin: 20px; */
			width: 600px;
		}
		#title{
		 	margin: 20px;
			font-size: 20px;
			font-weight : 600; 
		}
		#desc{
		 	margin: 20px;
			border-bottom: 1px solid black;
			margin-bottom: 10px;
		}
		#link{
			margin: 20px;
		}
	</style>
	</head>
	<body>
		${elem}
		<c:forEach items="${elem}" var="list">
		<div id="list">
			<div id="title">
				${list.title }
			</div>
			<div id="link">
				<a href="${list.link }">이동</a> 
			</div>
			<div id="desc">
				${list.desc }
			</div>			
		</div>
		</c:forEach>
	</body>
	<script>
		
	</script>
</html>