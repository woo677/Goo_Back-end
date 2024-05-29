package kr.co.gudi.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired BoardService service;
	
	
	@GetMapping(value = "/")
	public String basic() {
		return "basic";
	}
	
	@PostMapping(value = "/write.do")
	public String write(@RequestParam Map<String, String> param){
		logger.info("param : {}",param);
		service.write(param);
		//ModelAndView mav = new ModelAndView("basic");
		return "redirect:/list.do";
		
	}
	
	@GetMapping(value = "list.do")
	public ModelAndView list() {
		return service.list();
	}
	
	@GetMapping(value = "/detail")
	public ModelAndView detail(String idx) {
		logger.info(" detail  idx = "+idx);
		return service.detail(idx);
	}

}
