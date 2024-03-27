package kr.co.back.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.back.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService backservice;
	
	@RequestMapping(value = "/")
	public String home() {
		return "login";
	}
	
	//로그인 페이지
	@RequestMapping(value = "/login")
	public String login(HttpSession session,String id,String pw) {
		
		String loginId = backservice.login(id,pw);
		logger.info("loginId : "+loginId);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/join.go")
	public String join() {
		return "joinForm";
	}
	
	@RequestMapping(value = "/overlay.do")
	@ResponseBody
	public Map<String, Object> overlay(String id) {
		logger.info("id :"+id);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("use", backservice.overlay(id));
		
		
		return map;
	}
}
