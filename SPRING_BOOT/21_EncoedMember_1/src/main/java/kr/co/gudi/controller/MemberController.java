package kr.co.gudi.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dto.MemberDTO;
import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final MemberService memberService;
	
	private MemberController(MemberService memberService) {
		this.memberService = memberService;
		
	}
	//초기 진입시 
	@GetMapping(value = "/")
	public String home() {
		return "login";
	}
	// 로그인
	@PostMapping(value="/login.do")
	public ModelAndView login(String id, String pw,HttpSession session) {
		
		logger.info(id+" / "+pw);
		
		return memberService.login(id,pw,session);
	}
	
	// 회원가입
	@GetMapping(value = "/join.go")
		public String joinForm() {
			logger.info("회원가입 페이지 이동");
			return "join";
		}
	
	@PostMapping(value = "/join.do")
	public String join(MemberDTO dto) {
		
		logger.info("id : "+dto.getId());
		logger.info("pw : "+dto.getPw());
		memberService.join(dto);
		
		return "login";
	}
	
	@GetMapping(value = "/list")
	public ModelAndView list() {
		return memberService.list();
	}
	
	
}
