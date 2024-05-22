<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px 10px;
}
input {
	width: 110px;
	background-color: lightgray;
}
</style>
</head>
<body>
	<table>
	<thead>
		<tr>
			<th>팀명</th>
			<th>프로젝트명</th>
			<th>팀리더</th>
			<th>팀원1</th>
			<th>팀원2</th>
			<th>팀원3</th>
			<th>팀원4</th>
			<th>팀원5</th>
		</tr>
	</thead>
	<tbody id="list">
	
	</tbody>
	</table>
</body>

<script>
listCall();
   	
   	function listCall(){
        $.ajax({
            type: 'GET',
            url: './getTeamList.ajax',
            dataType: 'json',
            success: function(data) {
            	var content = '';
            	// +=을 안쓰고 = 을쓰는 이유는 3바퀴를 돌면 누적합때문에 총3개의 데이터가 아니라 6개의 데이터가
            	// 생겨서 누적합을 싹지우고 tr을 넣겠다는 뜻이다
            	data.list.forEach(function(item){
            		//class 안에 팀 이름과 컬럼명 정보를 담는다
            		content = '<tr>';
            		content += '<td>'+item.team_name+'</td>';
            		content += '<td><input type="text" class="'+item.team_name+' project_name" value="'+item.project_name+'"/></td>';
            		content += '<td><input type="text" class="'+item.team_name+' team_leader" value="'+item.team_leader+'"/></td>';
            		content += '<td><input type="text" class="'+item.team_name+' staff1" value="'+item.staff1+'"/></td>';
            		content += '<td><input type="text" class="'+item.team_name+' staff2" value="'+item.staff2+'"/></td>';
            		content += '<td><input type="text" class="'+item.team_name+' staff3" value="'+item.staff3+'"/></td>';
            		content += '<td><input type="text" class="'+item.team_name+' staff4" value="'+item.staff4+'"/></td>';
            		content += '<td><input type="text" class="'+item.team_name+' staff5" value="'+item.staff5+'"/></td>';
            		content += '</tr>';
            		$('#list').append(content);
            	});
            	/* 항상 요소가 출력하고 나서 이벤트를 걸어줄 것!! */
            	$('input[type = "text"]').focusin(function(){
            		$(this).css({"background-color": "white"});
            	});
            	
            	$('input[type = "text"]').focusout(function(e){
            		//this : 이벤트를 당한 당사자 객체
            		//e : 이벤트 그체(이벤트 기준으로 한다)
            		$(this).css({"background-color": "lightgray"});
            		//e.target : 이벤트가 걸린 타겟
            		console.log(e);
            		//console.log(e.target.defaultValue,' - > ',e.target.value);
            		if (e.target.defaultValue != e.target.value) {
            			console.log('서버에서 변경 요청',$(this));
            			//console.log('서버에서 변경 요청',e.target);	
						//팀이름(PK), 변경할 컬럼, 변경할 값 (값을 직접 박아 넣어야 한다)
            			//UPDATE team_project SET project_name = '강아지몰' WHERE team_name="1조"
            			//3조의 팀장을 김영수로 변경
            			//UPDATE team_project SET team_leader = '김영수' WHERE team_name="3조"
            			//column,value,pk
            			reqUdtae(e.target.classList[1],e.target.value,e.target.classList[0]);
					}
            		//defaultValue : 이전 값이 있다
            		//Value : 현제 값이 있다
            		
            	});
            	
            	
            	
            },
            error: function(e) {
                console.log(e);
            }
        });
   	}
   	
   	function reqUdtae(col,val,pk){
   	 console.log('UPDATE team_project SET '+col+'='+val+' WHERE team_name='+pk);

   	 //서버에서 데이터를 보내는 방법
   	 // 1. 파라메터 형식 update?col=project_name&val = 김영수&pk3조
   	// 2. url 방식 update/project_name/김영수/3조 (데이터를 요청할때만 쓴다)
   	$.ajax({
   		type:'PUT',
   		url:'update/'+col+'/'+val+'/'+pk,
   		data:{},
   		dataType:'JSON',
   		success: function(data) {
   			
   		},
   		error: function(e) {
            console.log(e);
            //e.target.value = e.target.defaultValue;
        }
   	});
   	}
</script>

</html>