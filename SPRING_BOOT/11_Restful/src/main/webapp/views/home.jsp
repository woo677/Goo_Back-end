<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<style>
		
	</style>
	</head>
	<body>
		<h3>RESTFUL  API 페이지</h3>
		<ul>
			<li>/rest/list.ajax : List 형태로 반환 <button onclick="sendAjax('list.ajax')">sample1</button> </li>
			<li>/rest/map.ajax : Map 형태로 반환 <button onclick="sendAjax('map.ajax')">sample2</button></li>
			<li>/rest/object.ajax : DTO 형태로 반환<button onclick="sendAjax('object.ajax')">sample3</button></li>
		</ul>
		<h3>복잡한 형태의 JSON 을 전송할때</h3>
		<button onclick="complex()">sample4</button>
		
		<h3>Server 에서 문자열 형태로 온 JSON 을 전달하고 싶아면?</h3>
		<p>json 형태의 문자열을 서버에서도 JAVA(JSON) 객체 형대(List,DTO,Map 등....)로 변경이 가능 하다.</p>
		<p>이때 필요한 라이브러리가 jackson-databaind 이다.</p>
	</body>
	<script>
		function sendAjax(req){
			$.ajax({
				type : 'GET'
				,url :'./rest/'+req
				,data:{}
				,dataType : 'JSON',
				success:function(data){
					console.log(data);
				},
				error:function(e){
					console.log(e);
				}
			});
		}
		
		//복잡한 json 전송 방법
		// simple :{name:'kim',age:35}
		// simple : {name:'kim',scores[10,20,30]}
		// complex : {name:'kim',scores[{subject:'java',scores:10},{subject:'db',scores:20}]}
		function complex(){
			
			var arr = [1,2,3,4,5];
			var obj = {};
			obj.name = "숫자넣기";
			obj.num = arr;
			var param = {"values":obj}; //object 안에 object
			console.log(param);
			$.ajax({
				type:'post', //post 로 보내야 한다
				url:'./rest/complex.ajax',
				data:JSON.stringify(param),// JSON 을 문자열로 변환해서 보내야 한다
				dataType:'JSON',
				contentType:'application/json; charset=utf-8', // content-type 명시
				success:function(data){
					console.log(data);
				},
				error:function(e){
					console.log(e);
				}
			});
		}
	</script>
</html>