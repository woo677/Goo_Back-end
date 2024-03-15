package kr.co.gudi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberDAO {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	//이 클래스 아무데서나 쓸수 있게 맨위에 쓴다
	Connection conn = null;

	public MemberDAO() {
		
		//pool 메서드 설정
		
		try {
			//1.context를 객체화
			Context ctx = new InitialContext();
			
			//2 context 안에 있는 자바이름 으로 불러오기
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB");
			
			//3데이터 소스로 만능키 빼오기
			conn = ds.getConnection();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public int join(String id, String pw, String name, String age, String gender, String email) {
			
		int row = -1;
		logger.info("DAO 접속");
		//1. 쿼리 준비
		String sql = "insert into member(id,pw,name,age,gender,email)values(?,?,?,?,?,?)";
		logger.info(sql);
		
		
		try {
			//2. 쿼리 실행 준비
			PreparedStatement pa = conn.prepareStatement(sql);
			
			//2-1. ? 값 넣기
			pa.setString(1,id);
			pa.setString(2,pw);
			pa.setString(3,name);
			pa.setInt(4,Integer.parseInt(age));
			pa.setString(5,gender);
			pa.setString(6,email);
			
			//3. 쿼리 실행
			row = pa.executeUpdate();
			logger.info("쿼리 실행 여부"+row);
			
			//4. 자원반납
			pa.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return row;
	}

}
