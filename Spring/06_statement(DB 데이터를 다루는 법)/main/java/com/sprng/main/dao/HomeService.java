package com.sprng.main.dao;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sprng.main.service.HomeDAO;

public class HomeService {

	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	public String createTable() {
		logger.info("DAO 객체화 후 호출");
		
		String msg = "테이블 생성 실패";
		
		HomeDAO dao = new HomeDAO();
		
		try {
			if(dao.crateTable()) {
				msg = "테이블 생성 성공";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return msg;
	}

	public int insert(String id, String pw, String name, String age, String gender, String email) {
		
		HomeDAO dao = new HomeDAO();
		int row = dao.insert(id,pw,name,age,gender,email);
		logger.info("dao로 부터 받은 값 : "+row);
		
		return row;
	}

	public void list() {
		
		logger.info("service 접속 성공");

		HomeDAO dao = new HomeDAO();
		dao.list();
		
	}


}
