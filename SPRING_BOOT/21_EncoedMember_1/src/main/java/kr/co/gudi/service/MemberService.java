package kr.co.gudi.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired MemberDAO dao;
	@Autowired PasswordEncoder encoder;

	public void join(MemberDTO dto) {
		String plain_pw = dto.getPw();
		dto.setPw(encoder.encode(plain_pw));
		int row = dao.join(dto);
		logger.info("join : "+row);
	}

	public ModelAndView login(String id, String pw, HttpSession session) {
		
		String enc_pw = dao.login(id);
		logger.info("enc_pwString = "+enc_pw);
		String page = "login";
		String msg = "아이디 또는 비밀번호를 확인";
		boolean success = false;
		
		if (enc_pw != null) {
			success = encoder.matches(pw, enc_pw);
		}
		
		ModelAndView mav = new ModelAndView();
		if (success) {
			page="redirect:/list";
		}else {
			mav.addObject("msg",msg);
			session.setAttribute("loginId", id);
		}
		mav.setViewName(page);
		return mav;
	}

	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("list");
		List<MemberDTO> list =dao.list();
		mav.addObject("list",list);
		return mav;
	}
	
	
	
	
	

	
}
