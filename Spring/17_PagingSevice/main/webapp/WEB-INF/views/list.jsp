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
   <select id="pagePerNum">
	   	<option value="5">5</option>
	   	<option value="10">10</option>
	   	<option value="15">15</option>
	   	<option value="20">20</option>
   </select>
   <table>
   <thead>
      <tr>
         <th><input type="checkbox" id="all"/></th>
         <th>글번호</th>
         <th>이미지</th>
         <th>제목</th>
         <th>작성자</th>
         <th>조회수</th>
         <th>날짜</th>
      </tr>
      </thead>
      <tbody id="list"></tbody>
      <tr>
      <!-- 플러그인 사용법 -->
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
//얘를 바꾸면 마지막 페이지가 유지됨
var showPage = 1 //n번 부터

$(document).ready(function(){ // html 문서가 모두 읽히면 되면(준비되면) 다음 내용을 실행 해라
	listCall(showPage);
});

//리스트가 체인지가 되면 그 값을 showPage로 넘긴다
$('#pagePerNum').on('change',function(){
	//페이지당 보여줄 게시물의 숫자를 변경하면 전체 페이지 수의 변화가 생기므로
	//페이징 처리 객체를 파괴하고 다시 만들도록 해야 한다.
	$('#pagination').twbsPagination('destroy');
	
	//체인지 된 값을 showPage에 넣고 listCall()을 호출한다
	listCall(showPage);
});

//호출을 하면 반응한다 ()에 showPage(1)에서 값을 받아온 값이 들어 간다
function listCall(page){
	//아잨스 선언법 
    $.ajax({
       type:'get', // 메서드 방식
       url:'./list.ajax', //접근할 주소
       data:{
    	   'page':page, 
    	   cnt:$('#pagePerNum').val() //cnt라는 이름에 pagePerNum에 value값이 들어간다
       }, //서버로 보낼 파라메터 값
       dataType:'json', //아잨스 방식
       //성공 했을때
       success:function(data){
    	   //리스트 생성
          drawList(data.list);
          console.log("총패이지 수 :",data);
          
          var startPage = data.currPage >  data.totalPages ? data.totalPages : data.currPage;
          
          //플러그인 추가
          $('#pagination').twbsPagination({
        	  startPage:startPage, // 시작 페이지 [1] (너 몇 페이지야)
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
       error:function(error){
          console.log(error);
       }
    });
}

function drawList(list){
 var content = '';
 for(item of list){
    //console.log(item);
    content += '<tr>';
    content += '<td><input type="checkbox" name="del" value="' + item.idx +'"/></td>';
    content += '<td>' + item.idx + '</td>';
    content += '<td>';
    
    var img = item.img_cnt > 0 ?'image.png' : 'no_image.png';
    content += '<img class="icon" src="resources/img/' + img + '"/>';
 

    content += '</td>';
    content += '<td>' + item.subject + '</td>';
    content += '<td>' + item.user_name + '</td>';
    content += '<td>' + item.bHit +'</td>';
    
    //java.sql.Date 는 javascript에서는 밀리세컨드로 변환하여 표시한다.
    //방법 1. Back-end : DTO의 반환 날짜 타입을 문자열로 변경 (서버를 껐다 켜야하니 웬만하면 프론트에서 해야햄)
    //content += '<td>' + item.reg_date + '</td>';
    //방법 2. Front-end : js에서 직접 변환
    var date = new Date(item.reg_date);
    var dateStr = date.toLocaleDateString("ko-KR"); //en-US
    content += '<td>' + dateStr + '</td>';
    
    
    content += '</tr>';
 }
 
 $('#list').html(content);
}



function del() {
    var delArr = [];
    $("input[name='del']").each(function(index, item) {
      if ($(item).is(":checked")) {
         var val = $(this).val();
         console.log(val);
         delArr.push(val);
      }
   });
     $.ajax({
         type:'post' // method 방식
         ,url:'./del.ajax' // 요청할 주소 // 파라미터 
         ,data:{delList:delArr}
        ,dataType:'json' // 기본 데이터 타입은 JSON 이다
         ,success:function(data){
            if(data.cnt>0){
            	alert('선택하신'+data.cnt+'개의 클이 삭제되었습니다.');
            	$('#list').empty();
            	listCall();
            }
        	 console.log(data);
         } 
         ,error:function(error){ // 통신 실패한 경우
             console.log(error);
         }
     });
}

$('#all').on('click',function(){
	var $chk = $('input[name="del"]');
	// attr : 정적 속성 : 처음부터 그려져 있거나 JSP에서 그린 내용
	// prop : 동적 속성 : 자바스크렙트로 나중에 그려진 내용 ※ 초보자들 시점 문제가 큼 : 
	// -> 렛갈림 시행 할려는 내용이 그려지는것보다 먼저면 attr 사용하면 안됨  
	if($(this).is(":checked")){
		$chk.attr('checked',true);	
	}else{
		$chk.attr('checked',false);
	}
	
});




      
</script>
</html>