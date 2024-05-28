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
		
	</style>
	</head>
	<body>
			<form action="write.do" method="post">
				<table>
					<tr>
						<td><input type="text" name="user_name" placeholder="작성자"/> </td>
					</tr>
					<tr>
						<td><input type="text" name="subject" placeholder="글제목"/> </td>
					</tr>
					<tr>
						<td><div id="div_editor"></div></td>
					</tr>
					<tr>
						<td>
							<!-- button 태그는 submit 역활도 수행한다. type="button" 으로 주면 버튼 기능만 수행하게 된다. -->
							<button type="button" onclick="save()">저장</button>
						</td>
					</tr>
				</table>
			</form>
	</body>
	<script>

	var config = {}
	config.toolbar = "basic";
	config.editorResizeMode="none";
	var editor = new RichTextEditor("#div_editor", config);
	
	function save(){
		// 에디터에 작성된 문자열을 가져온다
		var content = editor.getHTMLCode();
		console.log('에디터에 저장된 문자열 : ',content);
		//$('editor').text(content);
		
		var subject = $('input[name="user_name"]').val();
		var user_name = $('input[name="subject"]').val();
		 $.ajax({
			type:'post',
			url:'./write.do',
			data:{'content':content
					,'subject':subject
					,'user_name':user_name},
			dataType:'JSON',
			success:function(data){
				console.log(data);
			},
			error:function(e){
				console.log(e);
			}
		}); 
		//$('form').submit();
	}

	/*src="data:image/jpeg;base64
		data:image : 이미지 ba64 인코딩하여 문자열화 하는 방식
		장점 : 서버에서의 별도 파일 처리가 필요 없다(이미지의 출처를 확인하기도 어렵다)
		단점 : 용량제어가 어렵다.(정확한 이미지 파알 크기를 알기 어려움)
		기존 파일보다 용량을 더 많이 차치한다.
		
	
	 */
	</script>
</html>