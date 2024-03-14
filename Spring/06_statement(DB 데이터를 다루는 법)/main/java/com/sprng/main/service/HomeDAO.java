package com.sprng.main.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeDAO.class);

	Connection conn = null;
	
	public HomeDAO() {
			
		//pool 이용
		//Constructors from superclass : 클래스를 만들때 초기화를 함
		//1 . context.xml을 객체화
		try {
			Context ctx = new InitialContext();
			
			//2. 이름으로 Resource 태그 찾아서 DataSource 로 변환
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MariaDB");
			
			//3. DataSource 로 Connection 가져오기
			conn = ds.getConnection();
			logger.info("getConnection : "+conn);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public boolean crateTable() throws SQLException {
		
		boolean success = false;
		
		//1. 쿼리문 준비 (쿼리문의 ; 은 반드시 빼줘야 한다(아니면 오류가 난다))
		//긴 쿼리문을 쓰고 싶을때는 (스트링 빌더,스트링 버퍼)를 쓰면 된다
		String sql = "create table member("
				+ "	id varchar(50) primary key"
				+ "	,pw varchar(100)"
				+ "	,name varchar(50)"
				+ "	,age int(4)"
				+ "	,gender varchar(4)"
				+ "	,email varchar(100)"
				+ ")";
		
		//2. 실행할 객체 준비(Statement(1회용) | prepareStatement(다회용))
		//모든 DB는 conn을 가지고 해야 한다
		Statement stmt = conn.createStatement();
		
		
		//3. 쿼리문 실행(executeQurey(볼때만) | executeUpdate (데이터 변환))
		int row = stmt.executeUpdate(sql);
		logger.info("영향받는 데이터 수 : "+row);
		
		//문제가 있음면 여기까지 못온다
		success = true;
		
		stmt.close();
		conn.close();
		
		return success;
	}

	public int insert(String id, String pw, String name, String age, String gender, String email) {
		int row =-1;
		//1. 쿼리문 준비 (? 나중에 값을 추가 하겠다)
		String sql = "insert into member(id,pw,name,age,gender,email)values(?,?,?,?,?,?)";
		
		
		try {
			//2. 실행 객채Statement(1회용) | prepareStatement(다회용))
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//2-1. ? 대입
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setInt(4, Integer.parseInt(age));
			ps.setString(5, gender);
			ps.setString(6, email);
			
			//3. 쿼리 실행(executeQurey(볼때만) | executeUpdate (데이터 변환))
			row = ps.executeUpdate();

			//4. 자원 정리
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return row;
	}

	public void list() {
		
		//1. 쿼리문 준비
		String sql = "select * from member";
		
		//2. 실행 객체 준비
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//2-1 ? 가 있으면 대입
			
			
			//3. 쿼리 실행
			ResultSet rs = ps.executeQuery(sql);
			
			//4. 값 가져오기
			while (rs.next()) {
				//{}이게 있어야 값이 출력이된다
				//columnLabel : 컬럼에 이름을 가져온다
				logger.info("id : {}",rs.getString("id"));//column label
				logger.info("pw : {}",rs.getString(2));//column index(배열의 번호를 알려줘야 한다)
				logger.info("name : {}",rs.getString("name"));
				logger.info("age : {}",rs.getInt("age"));
				logger.info("gender : {}",rs.getString("gender"));
				logger.info("email : {}",rs.getString("email"));
				logger.info("===================");
				
			}
			
			//5자원 정리
			ps.close();
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}



}
