package kr.co.gudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {
	
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final MemberService service;
	
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/")
	public String home() {
		return "login";
	}
	
	
	//HttpServletRequest : 보내는 사람의 모든 정보가 있다 (IP등..)
	@PostMapping(value = "/login")
	public ModelAndView login(String id,String pw,HttpServletRequest request) {
		
		//getRemoteAddr : 로그인 하는 사람의 Ip 정보를 가져온다
		String ip = request.getRemoteAddr();
		logger.info("id : "+id);
		logger.info("pw : "+pw);
		logger.info("ip : "+ip); // 0:0:0:0:0:0:0:1 : IPv6
		// IPv6 > IPv4 로 변환할 경우
		// 개발용 : run as > run configuration > arguments > vm 선텍 후 아래 내용 추가
		// -Djava.net.preferIPv4Stack=true
	
		
		return service.login(id,pw,ip);
	}
	
	
	
	
	
	

}
