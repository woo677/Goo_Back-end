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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		logger.info("hoem 에 요청");
		return "home";
	}
	//값을 넣고 전송을 누르면 콘솔에 출력 되게 하라
	@RequestMapping(value = "/calc" , method = RequestMethod.POST)
	public String val(Model model ,HttpServletRequest rel) {
		
		String val1 = rel.getParameter("val1");
		String val2 = rel.getParameter("val2");
		String oper = rel.getParameter("oper");
		logger.info(val1+""+oper+""+val2);

		// Integer.parseInt : 문자열에서 정수로 바꾸는 법
		int su1 = Integer.parseInt(val1);
		int su2 = Integer.parseInt(val2);
		Object result = 0;
		
		switch (oper) {
		case "+":
			result =  su1+su2;
			break;

		case "-":
			result =  su1-su2;
			break;
			
		case "*":
			result =  su1*su2;
			break;
			
		case "/":
			result =  su1/su2;
			break;
		}
		
		model.addAttribute("result",result);
		
		return "calc";
	}
	
}
