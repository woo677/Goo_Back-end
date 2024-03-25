package kr.co.photo.member.controller;

import java.util.List;
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

import kr.co.photo.member.dto.MemberDTO;
import kr.co.photo.member.service.MemberService;

@Controller
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value = "/error/404")
	public String norFound(Model model) {
		model.addAttribute("code","404");
		model.addAttribute("msg","없는 페이지");
		return "error";
	}
	
	@RequestMapping(value = "/error/500")
	public String serverError(Model model) {
		model.addAttribute("code","500");
		model.addAttribute("msg","서버 오류");
		return "error";
	}
	
	@RequestMapping(value="/")
	public String home() {
		logger.info("main page");
		return "login";
	}
	
	@RequestMapping(value="/joinForm")
	public String joinForm() {
		logger.info("회원가입 페이지 이동");
		return "joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Model model, @RequestParam Map<String, String> param) {
		String page = "joinForm";
		String msg = "회원가입에 실패 했습니다.";
		logger.info("param : "+param);
		
		int row = service.join(param);
		logger.info("insert count : " +row);
		
		if(row==1) {
			page = "login";
			msg = "회원가입에 성공 했습니다.";
		}
		
		model.addAttribute("msg", msg);
		return page;
	}
	
	@RequestMapping(value="/login")
	public String login(Model model, HttpSession session, String id, String pw) {
		String page = "login";
		
		logger.info("id : {} / pw : {}",id,pw);
		String loginId = service.login(id,pw);
		
		if (loginId != null) {
			page = "redirect:/list";
			session.setAttribute("loginId", loginId);
		}else {
			model.addAttribute("msg", "아이디 또는 패스워드를 확인해주세요.");
		}
		
		return page;
	}
	
	
	@RequestMapping(value = "/member_list")
	public String list(Model model,HttpSession session) {
		String page = "redirect:/list";
		
		if(session.getAttribute("loginId")!=null) {
			List<MemberDTO> list = service.memberList();
			model.addAttribute("list",list);
			page = "member_list";
		}
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	

	
}