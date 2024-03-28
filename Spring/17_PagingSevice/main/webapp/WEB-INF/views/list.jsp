<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
      <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>    
      <script src="resources/js/jquery.twbsPagination.js" type="text/javascript"></script>
<style>
</style>
</head>
<body>
	게시판 리스트
	<hr/>
	<button onclick="del()">선택 삭제</button>
	<select id = "pagePerNum">
		<option value="5">5</option>
		<option value="10">10</option>
		<option value="15">15</option>
		<option value="20">20</option>
	</select>
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
		<tr>
		<td colspan="7">
      		<div class="container">                           
               <nav aria-label="Page navigation" style="text-align:center">
                  <ul class="pagination" id="pagination"></ul>
               </nav>               
            </div>
      	</td>
      	</tr>
	</table>
</body>
<script>

var showPage = 1;

//메서드 호출
$(document).ready(function(){ // html 문서가 모두 읽히면 되면(준비되면) 다음 내용을 실행 해라
	listCall(showPage);
});

//리스트가 체인지가 되면 그 값을 showPage로 넘긴다
$('#pagePerNum').on('change',function(){
	listCall(showPage);
});

//리스트 출력
//아작스가 들어 있는 메서드 호출
function listCall(page){
	//아작스 기본 툴
	$.ajax({
		type:'get',  //메서드 타입
		url:'./list.ajax',  //접근할 주소
		data:{
			page : page,
			cnt:$('#pagePerNum').val()
		}, //서버로 보낼 파라메터 값
		dataType:'json', // 아작스 타입
		success:function(data){ //리턴된 값을 받는 곳
			//ArrList라는 메서드 호출
			ArrList(data.list);
		
		
			$('#pagination').twbsPagination({
	        	  startPage:data.currPage, // 시작 페이지 [1] (너 몇 페이지야)
	        	  totalPages:data.totalPages, // 총 페이지 갯수 (내가 개산 해야함) 
	        	  visiblePages:5, //보여줄 페이지 수 [1][2][3][4][5]
	        	  onPageClick:function(evt,pg){ //페이지 클릭시 실행 함수
	        		  console.log(evt); //이벤트 객체
	        		  console.log(pg); //클릭한 페이지 번호
	        		  showPage = pg;
	        		  listCall(pg);
	        	  }
	          });
		
		
		},
		error:function(){
			console.log(error);
		}
	});
}

//위에서 보낸 값을 받는다
function ArrList(list){
	var con = '';
	//향상된 for문
	for(item of list){
		console.log(item);
		con += '<tr>';
		con += '<td><input type="checkbox" name ="del" value="'+item.idx+'" /> </td>';
		con += '<td>'+item.idx+'</td>';
		con += '<td>';
		var img = item.img_cnt>0 ? 'image.png' : 'no_image.png';
		con += '<img class="icon" src="resources/img/'+img+'"/>';
		con += '</td>';
		con += '<td>'+item.subject+'</td>';
		con += '<td>'+item.user_name+'</td>';
		con += '<td>'+item.bHit+'</td>';
		
		//java.sql.Date는 javascript 에서는 밀리세컨드로 변환하여 표시 한다
		//방법1. Back-end - DTO 의 반환 날짜 타입을 문자열로 변겅(단점 서버가 꺼졌ㄷ, 켜져야 된다)
		
		//방법2. Frond-end - js 에서 직접 변환
		//con += '<td>'+item.reg_date+'</td>'; 을 변경 해야 된다
		
		var date = new Date(item.reg_date);
		var dateStr = date.toLocaleDateString("ko-KR");//en-US
		//toLocaleDateString : 내가 있는 국자 날짜 추출
		
		con += '<td>'+dateStr+'</td>';
		con += '</tr>';
	}
	// 해당 요소의 텍스트 값을 가져온다.(내부 html 태그 포함)
	$('#list').html(con);
}


//선택된 글 지우기
// 체크 표시된 value을 delArr에 담아보자
// 체크 표시를 했을때 내가 선택한 값에 배열에 담김 
function del(){ //선택한 채크 박스의 값을 배열에 넣기(내가 뭘 선택했는지 보기)
	console.log('click');
	var delArr=[];
	//클릭을 했을때 .each() for 문 처럼 반복 된다
	$('input[name="del"]').each(function(idx,item){
		//:checked이 되어있는 아이템이 있는지 확인한다
		if($(item).is(':checked')){
		//있으면 this로 선택된 아이템의 값을 배열에 저장한다
		var val = $(this).val();
		console.log(val);
		delArr.push(val);
	}
		
	});
		console.log('delArr : ',delArr);
	
	
	//서버로 부터 뭐가 삭제 됬는 지 확인 하는 방법(내가 선택한 것이 제데로 삭제 됬는지 확인)
	$.ajax({ //컨트롤 러로 아작스의 데이터를 보내준다(그리고 받는다)
		type:'post', //method 전달법
		url :'./del', //주소 설정
		data:{delList:delArr},  //컨트롤러로 보낼 파라메터값(키:값)
		dataType:'json', //아작스 타입
		success:function(data){ // 성공
			if(data.cnt>0){ //삭제된 데이터가 0이상일경우
				alert('선택하신'+data.cnt+'개의 글의 삭제 되었습니다');
				$('#list').empty(); //선택한 내용을 지운다
				listCall();
			}
		},
		error:function(error){ //실패
			console.log(error);
		}
	});
}



//채크 박스를 클릭을 했을때 (채크 박스 전채 선택)
$('#all').on('click',function(){
	var $chk = $('input[name = "del"]');
	
	// attr : 정적 속성 : 처음부터 그려져 있거나 jsp 에서 그린 내용
	// prop : 동적속성 : 자바스크립트로 나중에 그려진 내용
	//.is()특정 값을 비교한 다음 t,f로 반환
	// 만약 t라면 input[name = "del"]라는 이름을 가지고 있는 input의 checked를 활성화 해라
	if($('#all').is(":checked")){
		$chk.prop('checked',true);
	}else{
		$chk.prop('checked',false);
	}
	
});


	var msg ='${msg}';
	if(msg != ''){
		alert(msg);
	}


</script>
</html>