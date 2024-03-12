<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>url 생성을 도와주는 기능을 한다</li>
		<li>사용 법 : c:url value="생성할 url 값" var="저장할 변수 명"</li>
		<li>c: param 을 이용해 파라메터를 추가할 수 있다</li>
	</ul>
	<!-- https://search.daum.net/search?w=news%q=독도 -->
	<c:url value="https://search.daum.net/search?w=news%q=독도" var="searchUrl">
		<c:param name="w">news</c:param>
		<c:param name="q">독도</c:param>
	</c:url>
	
	<a href="${searchUrl}">다음 링크로 이동</a>
	
	
	<!-- 상대 경로 :  내 위치로 중심으로 표현한 경로 또는 주소 -->
		<ul>
			<li><a href="./setTag.jsp">현재 위치에 있는 setTag.jsp(상대 경로)</a> </li>
			<li><a href="../index.jsp">현재 위치에서 한칸 올라간 곳에 있는 index.jsp(상대 경로)</a> </li>
		</ul>
	<!--  http://localhost:8080/11_JSTL/taglist/setTag.jsp -->
		
		
	<!-- 절대 경로 :  절대 위치(서버)로 부터 표현한 경로 또는 주소 -->
	<!--	1.http://localhost:8080/setTag.jsp	 -->
	<ul>
		<li><a href="/setTag.jsp">서버에 있는 setTag.jsp</a> </li>
		<li><a href="/11_JSTL/taglist/setTag.jsp">11_JSTL 이라는 컨텍스 아래 taglist 라는 폴더 안에 있는 setTag.jsp</a> </li>
	</ul>
	
	
	<!-- c:url 을 사용하면 절대결로의 context(콘텍스트) 경로를 신경 쓸 필요가 없어진다 -->
	<!-- 사이트에서 URL 주소 중간내용을 변경해도 알아서 잡아준다 -->
	<p><a href="<c:url value='/taglist/setTag.jsp'/>">setTag.jsp</a></p>
</body>
</html>