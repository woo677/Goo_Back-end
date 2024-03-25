package kr.co.photo.member.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.photo.member.dao.MemberDAO;
import kr.co.photo.member.dto.MemberDTO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO dao;
	
	public int join(Map<String, String> param) {
		logger.info("회원가입 param값");
		return dao.join(param);
	}

	public String login(String id, String pw) {
		logger.info("아이디 패스워드 들어왔다.");
		return dao.login(id,pw);
	}

	public List<MemberDTO> memberList() {
		return dao.memberList();
	}

}
