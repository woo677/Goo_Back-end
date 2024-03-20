package kr.co.gudi.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.gudi.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberService service;
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("메인페이지 접근");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model,String id,String pw,HttpSession session) {
		logger.info(id+" / "+pw);
		String page = "login";
		
	
		if(service.login(id,pw) != null) {
			session.setAttribute("loginId", id);
			page = "redirect:/list";
		}else {
			model.addAttribute("msg","아이디 또는 비밀번호를 확인해 주세요");
		}
		
		
		return page;
	}
}
