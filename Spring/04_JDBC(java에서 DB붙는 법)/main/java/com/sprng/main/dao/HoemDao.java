package com.sprng.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HoemDao {
	
	private static final Logger logger = LoggerFactory.getLogger(HoemDao.class);

	
	
	/**
	 * 데이터베이스 접속 후 성공 여부를 반환해 주는 메서드
	 * @return 성공 여부를 true 또는 felse 로 반환
	 */
	// DB에 접속 방법 (은행에 개인 금고)
	public boolean dbConnect() {
		
		logger.info("DB가 필요하면 이게 실행되어야 한다");
		boolean success = false;
		
		//1. 접속 정보 준비
		String id = "web_user";
		String pw = "pass";
		//				  jdbc:mariadb://{host}[:{port}]/[{database}]
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String driver = "org.mariadb.jdbc.Driver"; //claaa Name
		
		//2. 드라이버 메니저를 부른다
		//일반 예외 (실행하지 안아도 에러가 뜬다)
		try {
			Class.forName(driver);
			
			//접속에 성공되면 Connection 객체 성공
			//3. 만능열쇠(Connection)을 받는다
			Connection conn = DriverManager.getConnection(url, id , pw);
			
			//4. 할거 하고
			if(conn != null) {
				success=true;
			}
			
			//5. Connection 반납 (반납을 안하면 속도가 점점 느려진다)
			conn.close();
			
			//Exception : Exceptiond의 다형성을 이용 한다
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return success;
	}
}
