<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  		// cookie 는 PC에 저장이되므로 resp(response 레스펀스) 로 저장하고 req로 가져온다
  		//1. 쿠키 객체화 (값에 ,나 -가 있으면 에러가 난다(_ 는 뭔가를 구분을 하고 싶을때))
  		Cookie cookie = new Cookie("name","kim_ji_hoon");//key-value;
  		//2. 쿠키 수명을 지정 (언제까지 있을수 없기 때문)
  		cookie.setMaxAge(10*60);//초 단위
  		//3. 쿠키를 클라이언트(사용자PC)에 저장
  		response.addCookie(cookie);
  		
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- location(로캐이션) 이 사이트로 이동하고 싶어 -->
	<input type="button" value="쿠기 불러오기" onclick="location.href ='cookieResult.jsp'"/>
	<input type="button" value="쿠기 예제" onclick="location.href ='example/infoInput.jsp'"/>
</body>
</html>