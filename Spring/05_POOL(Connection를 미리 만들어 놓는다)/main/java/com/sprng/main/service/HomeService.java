package com.sprng.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sprng.main.dao.HomeDao;

//클래스에서 일을 시키면 그 일을 처리 하고 컨트롤러에 전달()
public class HomeService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	public String dbConnection() {
		
		logger.info("service 접근");
			
		logger.info("컨트롤러에서 요청을 하면");
		logger.info("DB가 필요 없으면 여기서 처리");
		logger.info("DB 가 필요 하면 DAO로 넘김");
		
		String msg = "DB 접속에 실패 했습니다";
		
		HomeDao dao = new HomeDao();
		if(dao.dbconnection()) {
			msg = "BD 접속에 성공 했습니다";
		}
		
		return msg;
	}
	
	

	public String poolConnect() {
		logger.info("pool service");
		String msg = "pool 접속에 실패 했습니다";
		
		HomeDao dao = new HomeDao();
		
		if(dao.poolConnect()) {
			msg = "pool 접속에 성공 했습니다";
		}
		
		return msg;
	}

}
