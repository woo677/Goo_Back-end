<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="resources/CSS/common.css" type ="text/css">
<style>
</style>
</head>
<body>
	게시판 리스트
	<hr/>
	<button onclick="del()">선택 삭제</button>
	<table>
		<thead>
		<tr>
			<th><input type="checkbox" id="all"/> </th>
			<th>글번호</th>
			<th>이미지</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>날짜</th>
		</tr>
		</thead>
		<tbody id="list">
			
		</tbody>
		<%-- <c:forEach items="${list}" var="item">
			<tr>
				<td><input type="checkbox" name ="del" value="${item.idx}" /> </td>
				<td>${item.idx}</td>
				<td>
					<c:if test="${item.img_cnt>0 }"><img class="icon" src="resources/img/image.png"/> </c:if>
					<c:if test="${item.img_cnt==0 }"><img class="icon" src="resources/img/no_image.png"/> </c:if>
				</td>
				<td>${item.subject}</td>
				<td>${item.user_name}</td>
				<td>${item.bHit}</td>
				<td>${item.reg_date}</td>
			</tr>
		</c:forEach> --%>
	</table>
</body>
<script>
function del(){ // 체크 표시된 value을 delArr에 담아보자
	var delArr = [];
	$('input[name ="del"]').each(function(idx,item){
		if($(item).is(":checked")){
			var val = $(this).val();
			console.log(val);
			delArr.push(val);
		}
		
	});
	console.log('delArr : ',delArr);
	
	$.ajax({
		type:'post',
		url:'./del',
		data:{delList:delArr},
		dataType:'JSON',
		success:function(data){
			console.log(data.cnt);
		},
		error:function(error){
			console.log(error);
		}
	});
}

$('#all').on('click',function(){	
	var $chk = $('input[name="del"]');	
	// attr : 정적 속성 : 처음부터 그려져 있거나 jsp 에서 그린 내용
	// prop : 동적속성 : 자바스크립트로 나중에 그려진 내용
	if($(this).is(":checked")){
		$chk.prop('checked',true);	
	}else{
		$chk.prop('checked',false);	
	}
});
	
	
//왔으면 요청 한다
		$.ajax({
			type:'get', //method 방식
			url:'./list.ajax', // 컨트롤러에 리퀘스트 주소
			data:{}, //보낼 파라미터 값이 있을떄
			dataType:'json', //아작스 타입
			success:function(data){ //리턴된 값을 받는곳
				drawList(data.list);
			},			
			error:function(error){
				console.log(error);
			}
		});
		
function drawList(list){
	var content ='';
	for(item of list){
		//console.log(item);
		content+='<tr>';
		content+='<td><input type="checkbox" name ="del" value="'+item.idx+'" /> </td>';
		content+='<td>'+item.idx+'</td>';
		content+='<td>';
		
		var img = item.img_cnt>0 ? 'image.png' : 'no_image.png';
		content+='<img class="icon" src="resources/img/'+img+'"/>';
		
		content+='</td>';
		content+='<td>'+item.subject+'</td>';
		content+='<td>'+item.user_name+'</td>';
		content+='<td>'+item.bHit+'</td>';
		
		//java.sql.Date는 javascript 에서는 밀리세컨드로 병환하여 표시 한다
		//방법1. Back-end - DTO 의 반환 날짜 타입을 문자열로 변경 (서버가 꺼졌다,켜져야 된다)
		
		//방법2. Frond-end - js 에서 직접 변환
		//content+='<td>'+item.reg_date+'</td>';
		
		var date = new Date(item.reg_date);
		var dateStr = date.toLocaleDateString("ko-KR"); // en-US
		//date.toLocaleDateString : 내가 있는 국가 날짜 추출
		
		content+='<td>'+dateStr+'</td>';
		content+='</tr>';
	}
	$('#list').html(content);
}
</script>
</html>