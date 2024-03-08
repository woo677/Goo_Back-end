<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String val = "";
    	//1.  쿠기 들을 가져온다
    	Cookie[] cookies = request.getCookies();
    	
    	//2. 쿠키들 중에서 이름이 long인 녀석을 찾는다
    	for(Cookie c : cookies){
    		if(c.getName().equals("lang")){
    			val = c.getValue();
    			//쿠키 삭제(0초만 살도록 변경)
    			c.setMaxAge(0);
    			response.addCookie(c);
    			
    			//원하는 값을 찾으면 끈어 버린다
    			break;
    		}
    	}
    	//3.lang 의 값에 따라 환영 문구를 다르게 보이게 한다
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 3.lang 의 값에 따라 환영 문구를 다르게 보이게 한다 -->
		<%
		if(val.equals("kor")){%>
			<h3>한글 페이지에 오신것을 환영 합니다</h3>
		<%}else{%>
			<h3>Welcome to English Page!!</h3>
		<%}
		%>	
</body>
</html>