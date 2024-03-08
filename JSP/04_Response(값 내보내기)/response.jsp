<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	System.out.println("response.jsp 들림");
	//sendRedirect(센드 리다이렠트) : 은 지정한 페이지로 이동 시켜준다
	//response.sendRedirect("goToPage.jsp");
	//한글이 깨지는 이유 : post 방식으로 전송시 한글이 깨진다
	//post 방식으로 전송시 아래 구문을 맨 윗줄에 넣어주자
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	System.out.println(name);
	
	//받아온 이름이 '관리자' 일 경우 goToPage.jsp로 이동
	//그 외 는 index.jsp 로 이동 
	if(name.equals("관리자")){
		response.sendRedirect("goToPage.jsp");
	}else{
		response.sendRedirect("index.jsp");
	}
%>