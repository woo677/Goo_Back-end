package kr.co.gudi.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dto.MemberDTO;
import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value = "/")
	public String main() {
		return "login";
	}
	
	@PostMapping(value = "/login.do")
	public String login(String id, String pw,HttpSession session) {
		logger.info("로그인 정보 : {}",id,pw);
		String loginId= service.login(id,pw);
		String page = "login";
		
		if (loginId!=null) {
			session.setAttribute("loginId", loginId);
			page	= "redirect:/list";
		}

		logger.info("loginId"+loginId);
		return page;
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model,HttpSession session) {
		logger.info("리스트 접근");
		String loginId = (String) session.getAttribute("loginId");
		String page = "login";
		if (loginId !=null) {
			List<MemberDTO> list = service.list();
			logger.info("list : {}",list);
			model.addAttribute("list",list);
			page = "list";
		}else {
			model.addAttribute("msg","로그인이 필요한 페이지 입니다");
		}
			
		return page;
	}
	
	@GetMapping(value = "/detail")
	public String detail(String idx,Model model) {
		logger.info("idx : {}",idx);
		MemberDTO dto = service.detail(idx);
		model.addAttribute("bbs",dto);
		
		return null;
	}
	
	@GetMapping(value = "/writeForm")
	public String writeForm() {
			return "writeForm";
		
	}
	
	@PostMapping(value = "/write.do")
	public ModelAndView write(@RequestParam Map<String,Object> param) {
		logger.info("param : {}",param);
		
		
		return service.write(param);
		
	}
	
	
	
	
	//삭제
	@RequestMapping(value = "/del")
	public String del(String idx) {
		logger.info("idx : {}",idx);
		int row = service.del(idx);
		logger.info("row : {}",row);
		String page = "list";
		if (row >0) {
			page = "redirect:/list";
		}
		return page;
	}
	
	
	//로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		logger.info("loginId : {}",loginId);
		
		String page = "list";
		 if (session != null) {
		        session.invalidate();
		        logger.info("loginId : {}",loginId);
		        page = "login";
		    }
		
		return page;
	}
	
	
}
