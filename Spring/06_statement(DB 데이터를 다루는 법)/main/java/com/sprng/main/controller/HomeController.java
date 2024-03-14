package com.sprng.main.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sprng.main.dao.HomeService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		return "index";
	}

	@RequestMapping(value = "/stmt")
	public String stmt(Model model) {
		logger.info("stmt 실행요청");
		HomeService service = new HomeService();
		
		String msg = service.createTable();
		
		logger.info("결과 메시지 : "+ msg);
		model.addAttribute("result",msg);
		
		return"index";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model model,HttpServletRequest req) throws UnsupportedEncodingException {//  throws UnsupportedEncodingException : UTF-8 말고 다른게 들어 왔을때의 예외처리
		logger.info("insert 요청중");
		
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		logger.info(id+" , "+pw+" , "+name+" , "+age+" , "+gender+" , "+email);
		
		
		//객체 생성
		HomeService service = new HomeService();
		
		int row = service.insert(id,pw,name,age,gender, email);
		model.addAttribute("row",row);
		
		return "insert";
	}
	
}

