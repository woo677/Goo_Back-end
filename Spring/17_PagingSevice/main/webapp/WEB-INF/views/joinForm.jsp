<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/common.css" type ="text/css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	input[name="id"]{
	width:70%
	}
</style>
</head>
<body>
	<h3>회원가입</h3>
	<hr/>
	<form action="join.do" method = "post">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="id"/>
					<input type="button" value="중복체크" onclick="overlay()"/>
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<th>PW확인</th>
				<td>
					<input type="text" id="confirm"/>
					<span id="msg"></span>
				</td>
			</tr>
			<tr>
				<th>관리자</th>
				<td> <!--  1. member에 auth에 넣는다 [ 테이블을 손을 봐야되서 문제가 될 수 있다 ] --> <!--  관리자 여부 테이블을 만든다 [ 관리자 여부를 가져오는데 join해서 가져와야됨 -->
				<input type="checkbox" name="auth"/>
				관리자여부
				</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<th>AGE</th>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<th>GENDER</th>
				<td>
					<input type="radio" name="gender" value="남"/>남자
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" value="여"/>여자
				</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<!-- button 태그에 type="button" 을 넣으면 submit 기능이 사라진다 -->
				<th colspan="2"><button type="button" onclick="join()">회원가입</button></th>
			</tr>
		</table>
	</form>
</body>
<script>
	//사용 가능한 아이디 에만 true변환
	var overChk = false;
	
	$('#confirm').on('keyup',function(){
		if($('input[name="pw"]').val()==$(this).val()){
			$('#msg').html('비밀면호가 일치 합니다');
			$('#msg').css({'color' : 'green'});
		}else{
			$('#msg').html('비밀면호가 일치 하지 않습니다');
			$('#msg').css({'color' : 'red'});
		}
	});
	

	function join(){
		
		
		//input는 값이 없으면 null이 아니라 '공백' 으로 표시 된다
		var $id = $('input[name="id"]');
		var $pw = $('input[name="pw"]');
		var $auth = $('input[name="auth"]:checked');
		var $name = $('input[name="name"]');
		var $age = $('input[name="age"]');
		var $gender = $('input[name="gender"]:checked');
		var $email = $('input[name="email"]');
		
		//input 에 내용이 ' ' 비어있다면 실행
		if(overChk==false){ //중복 체크를 안 했다면 false 중복 체크를 해다면 overChk가 true로 변환 되서 다음줄 실행
			alert('증복 채크를 해 주세요');
			$id.focus();
		}else if ($id.val()==''){ //아이디에 값이 비어 있다면 실행
			alert('아이디를 입력 해 주세요');
			$id.focus(); //지정한 곳으로 커서 이동
		}else if ($pw.val()==''){
			alert('비밀번호를 입력 해 주세요');
			$pw.focus(); //지정한 곳으로 커서 이동
		}else if ($name.val()==''){
			alert('이름을 입력 해 주세요');
			$name.focus(); //지정한 곳으로 커서 이동
		}else if ($age.val()==''){
			alert('나이를 입력 해 주세요');
			$age.focus(); //지정한 곳으로 커서 이동
		}else if ($gender.val()==null){
			alert('성별를 체크 해 주세요');
		}else if ($email.val()==''){
			alert('이메일을 입력 해 주세요');
			$email.focus(); //지정한 곳으로 커서 이동
		}else{
		// 데이터 넣기 전에 확인 
		//정규 표현식 (장점 : 내가 필요한 패턴을 만들수 있다)
		//숫자만 입력 가능 하게 해준다
		var regExp = new RegExp('[a-zA-zㄱ-ㅎ가-힣]');
		var match = regExp.test($age.val());//위의 표현식 일치 여부
		if(match){
			alert('숫자만 입력 해 주세요');
			$age.val('');
			$age.focus();
			return false;
		}
		 
			console.log('서버로 회원가입 요청');
		// 서브밋 기능이 이있다
		$('form').submit(); //서브밋 버튼 역활
		}
		
		
	}



	var msg = '${msg}'; // 쿼터 빠지면 넣은 문구가 변수로 인식됨.
	if(msg != ''){
		alert(msg);
	}
	function overlay() {
		console.log('click');
		var id = $('input[name="id"]').val();
		//ajax를 이용한 비동기 통신 (자바스크렙트를 사용해 보안성이 좋지 못함 취약함)
		$.ajax({
			type:'post', // method 방식
			url:'overlay.do', // 요청한 주소
			data:{'id':id}, // 파라메터
			success:function(data){ // 통신 성공했을경우
			//ajax에서 XmlhttpRequest 객체를 통해 대신 받아와서
			//여기에 뿌려준다
				console.log(data);
				if(data.use > 0){
					alert('이미 사용중인 아이디 입니다.');
					$('input[name="id"]').val('');
				}else{
					alert('사용 가능한 아이디 입니다.');
					overChk = true;
				}
			}, 
			error:function(error){ // 통신 실패 시
				console.log(error);
			} 
		});
	}
</script>
</html>