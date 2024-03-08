<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// session 세션은 서버에 접속하면 그냥 주워지는 객체다
    	System.out.println("session ID : " + session.getId());
    	
    	// 서버를 떠나거나 인위적으로 지울때까지 유지된다
    	// 또한 기본 30분이나 지정된 시간동안 아무런 동작을 하지 않으면 초기화 된다
    	// session 세션 시간을 임의로 값을 지정할수 있다
    	//session.setMaxInactiveInterval(10);//10초 동안 동작이 없으면 세션 초기화
    	System.out.println(session.getMaxInactiveInterval()+ "초");
    	// ex : 은행,네이버 로그인
    	
    	//세션에 저장된 값 확인
    	String name =  (String)session.getAttribute("name");
    	
    	//세션에서 로그인 을 할때 사용한다
    
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 테스트</h2>
	<a href="sessionSet.jsp">세션에 값 저장</a><br/>
	<p>세션에 저장된 name 값 : <%=name %></p>
	<a href="sessionDel.jsp">세션에 값 삭제</a><br/>
	<a href="sessionInit.jsp">세션에 값 초기화</a><br/>
</body>
</html>