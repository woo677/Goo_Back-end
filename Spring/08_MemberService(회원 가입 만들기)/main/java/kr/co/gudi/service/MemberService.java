package kr.co.gudi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.gudi.dao.MemberDAO;

public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public int login(String id, String pw, String name, String age, String gender, String email) {
	
		//제데로 접속 했는지 확인
		logger.info("service 접속");
		
		
		//일할 객체 선언
		MemberDAO dao = new MemberDAO();

		return dao.join(id,pw,name,age,gender,email);
	}

}
