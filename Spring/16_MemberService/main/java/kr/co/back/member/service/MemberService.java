package kr.co.back.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.back.member.dao.MemberDAO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO backDAO;

	public String login(String id, String pw) {
		
		return backDAO.login(id,pw);
	}

	public int overlay(String id) {

		return backDAO.overlay(id);
	}




}
