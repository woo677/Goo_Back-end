<%@page import="java.util.Arrays"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// java 영역
	
	// request 객체 : 요청하는 모든 정보를 담고있는 객체
	// jap 에서 request 는 객체화 하지 않고 사용한다(스텍틱)
	// 미리 객체화 해서 저장하고 있기 때문에(내장 객체)
	
	//getParameter : ? 뒤에 있는 값을 가져온다
	String userName = request.getParameter("userName");
	System.out.println(userName);
	
	String gender = request.getParameter("gender");
	System.out.println(gender);
	
	//체크박스 처럼 하나의 이름으로 여러 값을 보낼때
	String hobby[] =  request.getParameterValues("hobby");
	System.out.println(Arrays.toString(hobby));
	
%>
 
 <!-- HTML 영역 -->
 <p>userName :<%=userName %></p> 
<%if(gender.equals("남자")){%>
	 <p>gender : 남자입니다</p>
<%}else{%>
	<p>gender : 여자입니다</p>
<%} %>
 <!--<p>gender :   (남자입니다 | 여자 입니다(if문 사용))</p> -->
 <p>취미  :  
 <%for(int i =0;i<hobby.length;i++) {%>
		<%=hobby[i] %> <!--(선택한 취미 하나하나 다 찍어 줄것 (for 문 사용))--> 
 <%} %>
 </p>
 
 <p>도매인 : <%=request.getServerName() %> </p>
 <p>포트번호 : <%=request.getServerPort() %> </p>
 <p>URL : <%=request.getRequestURL() %> </p>
 <!-- IPV6 알려줌(IPV4로 변환할수 있다) -->
 <p>IP : <%=request.getRemoteAddr() %></p>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  