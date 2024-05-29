<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link rel="stylesheet" href="res/style.css" />
	<link rel="stylesheet" href="richtexteditor/rte_theme_default.css" />
		<script type="text/javascript" src="richtexteditor/rte.js"></script>
		<script type="text/javascript" src='richtexteditor/plugins/all_plugins.js'></script>
	<style>
		table,th,td {
	border: 1px solid black;
	border-collapse: collapse; 
}
	#content{
		display: none;
	}

	</style>
	</head>
	<body>
			
				<table>
					<tr>
						<td>${bbs.subject }</td>
					</tr>
					<tr>
						<td>${bbs.user_name }</td>
					</tr>
					<tr>
						<td><div id="div_editor"></div></td>
					</tr>
					<tr>
						<td>
							
							<input type="hidden"  name="div_editor"/>
							<a href="/list.do">리스트로 돌아가기</a>
						</td>
					</tr>
				</table>
				<div id="content">${bbs.content }</div>
	</body>
	<script>

	var config = {}
	config.toolbar = "simple"; //basrc 은 거으 대부분의 기능이 나타나지만, simple 은 아무것도 나타나지 않는다.
	// simple 을 사용할 경우 필요한 툴바들을 지정해 줘애 한다
	config.toolbar_simple = "{save, print, html2pdf, code}"; //저장, 출력, pdf, html코드보기
	config.editorResizeMode="none";
	var editor = new RichTextEditor("#div_editor", config);
	editor.setHTMLCode($('#content').html());
	editor.setReadOnly();
	

	</script>
</html>