package kr.co.gudi.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gudi.service.MemberService;

@Controller
public class MemerController {

		Logger logger = LoggerFactory.getLogger(getClass());
		//MemberService 를 객제화 해서 service라는 곳에 담긴다
		@Autowired MemberService service;
	
		//의존성 주입 (파일주소와 jsp를 입력하지 않아도 자동으로 찾아간다)
		@RequestMapping(value = "/")
		public String home() {
			logger.info("main page");
			return "login";
		}
		
		@RequestMapping(value = "/joinForm")
		public String joinForm() {
			logger.info("joinForm 이동");
			return "joinForm";
		}
		
		// 파라미터를 묶어서 가져오는 법 해쉬맥
		@RequestMapping(value = "/join")
		public String join(Model model, @RequestParam Map<String,String> param) {
			String page = "joinForm";
			String msg ="회원가입에 실패 했습니다";
			
			logger.info("param : "+param);
			
			int row = service.join(param);
			logger.info("insert count : "+row);
			
			if(row ==1) {
				page="login";
				msg = "회원가입에 성공 했습니다";
			}
			
			
			model.addAttribute("msg",msg);
			
			return page;
		}
}
