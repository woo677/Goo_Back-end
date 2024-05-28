package kr.co.gudi.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping(value = "/")
	public String basic() {
		return "basic";
	}
	
	@PostMapping(value = "/write.do")
	//@ResponseBody
	public ModelAndView write(@RequestParam Map<String, String> param){
		logger.info("param : {}",param);
		logger.info("content : "+param.get("content"));
		logger.info("user_name : "+param.get("user_name"));
		logger.info("subject : "+param.get("subject"));
		//ModelAndView mav = new ModelAndView("basic");
		return null;
	}

}
