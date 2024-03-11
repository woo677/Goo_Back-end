<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    	String id  = request.getParameter("id");
    	String name = request.getParameter("name");
    	System.out.println("application : "+id+" / "+name);
    	
    	if(id != null && name !=null){
    		//application 영역에 저장 (세션하고 저장하는 법은 동일하다)
    		application.setAttribute("id", id);
    		application.setAttribute("name", name);
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="session.jsp" method="post">
			<table border="1">
				<caption>session 에 저장될 내용</caption>
					<tbody>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="email"/></td>
						</tr>
						<tr>
							<th>연락처</th>
							<td><input type="text" name="phone"/></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="전송"/></td>
						</tr>
					</tbody>
			</table>
		
		</form>
</body>
</html>