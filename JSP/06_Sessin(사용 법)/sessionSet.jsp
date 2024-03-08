<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//session 에 name 이라는 이름으로 "kim,ji-hoon"(서버는 _ 가 아니여도 다 들어간다) 이라는 값을 저장한다
    	session.setAttribute("name", "kim,ji-hoon");
    	response.sendRedirect("index.jsp");
    %>