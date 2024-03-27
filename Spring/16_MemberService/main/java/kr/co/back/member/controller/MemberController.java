package kr.co.back.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//아이디 중복 확인
	@RequestMapping(value = "/overlay.do")
	@ResponseBody
	public Map<String, Object> overlay(String id) {
		logger.info("id :"+id);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("use", backservice.overlay(id));
		
		
		return map;
	}
	
	//회원가입 페이지
	@RequestMapping(value = "/join.do",method = RequestMethod.POST)
	public String joinForm(HttpSession session,Model model,@RequestParam Map<String,String> param) {
		String page = "joinForm";
		
		if (true) {
			backservice.joinForm(param);
			page = "login";
			
		}
		
		return page;
	}
}
