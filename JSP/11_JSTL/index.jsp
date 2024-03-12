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
		<!-- ./ : 현재 폴터,  ../ 한칸 위 폴더 : 상대 경로 -->
			<li><a href="./taglist/setTag.jsp">*c : set (변수선언)</a></li>
			<li><a href="./taglist/ifTag.jsp">*c : if (else가 없다)</a></li>		
			<li>
				<form action="./taglist/chooseTag.jsp">
					*c : choose(스위치 : 조건이 들어간다(else 쓰고 싶으면 이거써))<br/>
					<input type="text" name="num"/>
					<input type="submit" value="전송"/>
				</form>
			</li>	
			<li><a href="./taglist/forEachTag.jsp">*c : forEach(for문)</a></li>
			<li><a href="./taglist/url.jsp">*c : url(절대,상대 경로)</a></li>
			<li><a href="./taglist/import.jsp">c : import (불러오는 역활)</a></li>
			<li><a href="./taglist/tokens.jsp">c : forTokens</a></li>
			<li><a href="./taglist/redirectTag.jsp">c : redirect</a></li>
			<li><a href="./taglist/function tag.jsp">c : function tag(fn)</a></li>
			<li><a href="#">c : catch(개별적학습)</a></li>
			<li><a href="#">c : out(개별적학습)</a></li>
		</ul>
</body>
</html>