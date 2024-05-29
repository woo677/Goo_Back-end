package kr.co.gudi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.MainService;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MainService service;
	
	@GetMapping(value = "/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping(value = "/connect.do")
	public ModelAndView connect() {
		return service.connect();
	}
	
	@GetMapping(value = "/getElem.do")
	public ModelAndView getElem() throws InterruptedException {
		return service.getElem();
	}
	
	
	@GetMapping(value = "/event.do")
	public String event() throws InterruptedException {
		service.event();
		return "home";
	}
	
}
