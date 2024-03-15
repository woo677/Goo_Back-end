package kr.co.gudi.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.gudi.service.MemberService;

@Controller //@Controller라고 알려준다
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	//최초 페이지(로그인) 이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	
	//회원가입 페이지 이동
	@RequestMapping(value = "/joinForm",method = RequestMethod.GET)
	public String joinForm() {
		logger.info("회원가입 페이지 이동");
		return "joinForm";
	}
	
	
	//회원 가입 성공여부확인
	@RequestMapping(value = "/join" ,method = RequestMethod.POST)
	public String join(Model model,HttpServletRequest req) throws UnsupportedEncodingException {
		logger.info("회원 정보 확인");
		
		String msg = "회원가입에 실패 했습니다.";
		
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		
		//정보가 제데로 들어왔는지 확이
		logger.info(id+" , "+pw+" , "+name+" , "+age+" , "+gender+" , "+email);
		
		String page = "joinForm";
		//일 할 객체 선언
		MemberService service = new MemberService();
		int row = service.login(id,pw,name,age,gender,email);
		
		logger.info("확인 여부 : "+msg);
		
		//상황에 때라 페이지 변경 하는 법
		
		if(row ==1 ) {
			page = "login";
			msg = "회원가입에 성공 했습니다";
		}
		logger.info(page);
		
		model.addAttribute("msg",msg);
		
		return page;//상황에 따라 페이지를 다르게 접속 하는법(변수 선언)
	}
	
}
