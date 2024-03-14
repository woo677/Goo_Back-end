package com.sprng.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainDao {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public Connection conn = null;
	public MainDao() {
		
		try {
			Context ctx = new InitialContext();
			
		DataSource	 ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB");
			conn = ds.getConnection();
			logger.info("connect : "+conn);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	public void insert() {
		
		//1.쿼리 준비
		String sql = "INSERT INTO member(id,pw,name,age,gender,email)VALUES(?,?,?,?,?,?)";
		
		//2.쿼리 실행 객체 준비 (? 있으면 대응)
		PreparedStatement ps;
		try {
			conn.setAutoCommit(false); //auto commit 을 종료
			ps = conn.prepareStatement(sql);
			ps.setString(1, "tester3");
			ps.setString(2, "1234");
			ps.setString(3, "사용자");
			ps.setInt(4, 30);
			ps.setString(5, "여자");
			ps.setString(6, "sadfeed@naver.com");
			
			
			//3. 쿼리 실행
			//변화된 row에 갯수 다
			int row  = ps.executeUpdate();
			logger.info("영향받은 테이터 수 : "+row);
			
			row  = ps.executeUpdate();
			logger.info("영향받은 테이터 수 : "+row);
			
			
			conn.commit();//완전 성공
			
			//4.자원 반납
			ps.close();
			conn.close();
			
		} catch (Exception e) {

			e.printStackTrace();
			try {
				
				conn.rollback();//에러가 떨어지면 롤백
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
		
	}

}
