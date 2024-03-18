package kr.co.gudi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MembereDTO;

public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public int join(String id, String pw, String name, String age, String gender, String email) {
	
		//제데로 접속 했는지 확인
		logger.info("service 접속");
		
		
		//일할 객체 선언
		MemberDAO dao = new MemberDAO();

		return dao.join(id,pw,name,age,gender,email);
	}

	public boolean login(String id, String pw) {
		MemberDAO dao = new MemberDAO();
		return dao.login(id,pw);
	}

	public List<MembereDTO> list() {
		MemberDAO dao = new MemberDAO();
		return dao.list();
	}

	public MembereDTO deatli(String id) {
		MemberDAO dao = new MemberDAO();
		return dao.deatli(id);
	}

	public int del(String id) {
		MemberDAO dao = new MemberDAO();
		return dao.del(id);
	}


}
