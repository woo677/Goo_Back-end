package com.sprng.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sprng.main.service.HomeService;

 // 뷰 파일에서 보낸 요청을  컨트롤러로 받는다
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		
		logger.info("hoem 으로 접속");
		
		HomeService ser = new HomeService();
		String msg = ser.dbConnection();
		logger.info(msg);
		model.addAttribute("msg",msg);
		
		return "index";
	}
	
	
	
	@RequestMapping(value = "/pool",method = RequestMethod.GET)
	public String pool(Model model) {
		
		logger.info("/pool 요청");
		HomeService service = new HomeService();
		
		String msg =  service.poolConnect();
		logger.info("msg"+msg);
		model.addAttribute("msg",msg);
		
		return "index";
	}
	
}
