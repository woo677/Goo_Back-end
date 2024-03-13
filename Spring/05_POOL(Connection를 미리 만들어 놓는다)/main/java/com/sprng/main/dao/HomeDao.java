package com.sprng.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//DB에서 요청을 처리해야 할때
public class HomeDao {

	private static final Logger logger = LoggerFactory.getLogger(HomeDao.class);
	
	public boolean dbconnection() {
		
		logger.info("DB에 붙을 준비");
		boolean connec = false;
		
		//1. DB에게 줄 정보를 준비
		String id = "web_user";
		String pw = "pass";
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String driver = "org.mariadb.jdbc.Driver";
		
		
		//2. DB메니저를 호출
		try {
			Class.forName(driver); // ()해당되는  DB클래스의 매니저를 부를건지
			
			//3. DB로 부터 만능키 (Connection(커넥션))를 받아온다
			Connection conn = DriverManager.getConnection(url, id , pw);
			// 커넥션을 사용하면 이렇게 됨 : org.mariadb.jdbc.MariaDbConnection@1412fc99
			logger.info("conn : "+conn);
			
			//4. 내가 할 일은 한다
			if(conn!=null) {
				connec = true;
			}
			
			//5. Connection 을 반납한다
			conn.close();
			
		} catch (Exception e) {


			e.printStackTrace();
		}
		logger.info("성공 실패 여부 : " + connec);
		return connec;
		
	}
	
	/*이거를 자바화 시킨다
	 <Resource
 	name = "jdbc/MariaDB" 			<- 호출할 이름
 	auth = "Container" 					<- 제어를 누가 하게 할것인가?(톰캣|Spring|개발자)
 	type = "java.sql.DataSource"	<- xml 의 태그를 자바의 어떤 데이터 타입으로 변경할 것인가 
 	driverClassName = "org.mariadb.jdbc.Driver"
 	url = "jdbc:mariadb://localhost:3306/mydb"
 	username = "web_user"
 	password = "pass"
 	>
 	</Resource>
	 */
	
	public boolean poolConnect() {
		boolean succ = false;
		logger.info("RE");
		try {
			//1. context.xml 을 자바 객체로 변환
			Context ctx = new InitialContext();
			
			//2. Resource 태그를 이름을 사용해서 찾아온다 ->java 형태로 변환 한다
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB"); //java:comp/env/[pool Name];
			logger.info("source"+ds);
			
			//3. 커넥션을 불러 온다
			Connection conn =  ds.getConnection();
			logger.info("pool connection"+conn);
			if(conn!=null) {
				succ = true;
				conn.close(); //4.  자원 반납
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return succ;
	}

	
}
