package com.sprng.main;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	

	//get 메서드로 / 요청이 온다면 home 메서드를 실행 하라
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) { //model : 값을 보낼때 사용
		model.addAttribute("msg", "Hello SPRING"); //jsp로 보낼 값을 지정
		return "index"; //index.jsp로 이동 해라
	}
	
}
