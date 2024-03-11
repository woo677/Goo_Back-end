<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form.jsp 에서 보낸 내용을 beanProc.jsp 에서 저장시키고 beanResult.jsp 에서 내용을 확인한다 -->
		<form action="beanProc.jsp">
			이름 : <input type="text" name="userName"/>
			<button>전송</button><!-- botton 태그는 form 안에 있으면 submit 역활을 수행 -->
		</form>
</body>
</html>