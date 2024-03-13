package com.sprng.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sprng.main.service.HoemService;

//@Controller 때문에 이 클래스가 컨트롤러라는 걸 알 수 있다
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); //로그를 샇아주고 싶을때 있어야함	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		logger.info("controller home 접근");
		
		//서비스 기능을 사용하기 위해서 객체화 접근
		HoemService service = new HoemService();
		String msg = service.dbConnect();
		logger.info(msg);
		model.addAttribute("msg",msg);
		
		return "index";
	}
	
}
