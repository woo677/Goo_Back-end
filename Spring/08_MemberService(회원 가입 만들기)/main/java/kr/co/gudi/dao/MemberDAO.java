package kr.co.gudi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.gudi.dto.MembereDTO;

public class MemberDAO {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	//이 클래스 아무데서나 쓸수 있게 맨위에 쓴다
	Connection conn = null;
	
	//생성자
	public MemberDAO() {
		
		//pool 메서드 설정
		
		try {
			//1.context를 객체화
			Context ctx = new InitialContext();
			
			//2 context 안에 있는 태그로 가져온다 자바이름 으로 불러서
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


	public boolean login(String id, String pw) {
		
		boolean success = false;
		
		//1. 쿼리문 준비
		String sql ="select id from member where id=? and pw = ?";
		
		//2. 실행객체 준비
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//2-1 ? 대입
			ps.setString(1, id); // 몇번째 ? 
			ps.setString(2, pw);
			
			//3. 실행
			ResultSet rs = ps.executeQuery();
			
			//4. 값 꺼내기
			success = rs.next();
			logger.info("+++ ",success);
			
			//5. 자원 반납
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}


	public List<MembereDTO> list() {
		
		//1 쿼리문 준비
		String sql = "SELECT id,name,age,email FROM member";
		
		List<MembereDTO> list = new ArrayList<MembereDTO>();
		try {
			//2.실행 객체 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//3 실행
			ResultSet rs = ps.executeQuery();
			
			
			//4 데이터 가져오기
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age =  rs.getInt("age");
				String email =  rs.getString("email");
				logger.info(id+" "+name+" "+age+" "+email);
				
				MembereDTO dto = new MembereDTO(id, name, age, email);
				list.add(dto);
			}
			
			
			//5 자원 반납
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public MembereDTO deatli(String id) {
		
		String sql = "SELECT id,pw,name,age,gender,email FROM member where id=?";
		MembereDTO dto = null;
		logger.info("dao 접근");
		
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);			
			ps.setString(1, id);			
			ResultSet rs = ps.executeQuery(); // ?가 있으면 실행쿼리() 안에 아무것도 넣으면 안된다 (넣으면 오류가 난다)
			
			if (rs.next()) {
				String member_id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				logger.info(member_id+" "+pw+" "+name+" "+age+" "+gender+" "+email);
				dto = new MembereDTO(member_id, name, age, email);
				// 방법 1 : DTO에 직접 추가
				// 방법 2 : DTO에 생성자 추가
				dto.setPw(pw);
				dto.setGender(gender);
				
				
				conn.close();
				ps.close();
				rs.close();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto; 
	}


	public int del(String id) {
		//1 쿼리 준비
		String sql = "delete from member where id =?";
		int row = -1;
		
		try {
			//2 쿼리 실행문 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//? 추가
			ps.setString(1, id);
			
			//3 실행
			row = ps.executeUpdate();
			
			//반납
			ps.close();
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	

}
