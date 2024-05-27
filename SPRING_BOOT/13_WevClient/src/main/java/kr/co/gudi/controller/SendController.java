package kr.co.gudi.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import kr.co.gudi.service.ApiService;

//내 내가 가지고 있는 서버

@RestController
public class SendController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private ApiService service;
	
	public SendController(ApiService service) {// 생성자 주입
		this.service=service;
	}
	
    //url에 값이 들어올 경우 다음과 같이 받아 준다
    // url 에 변화되는 값이있으면 {}로 표시해 준다
    //@PathVariable : 경로안에 변수가 있다 를 받겠다
	@GetMapping(value = "/get/send/{val}")
	public Map<String, String> getSend(@PathVariable String val){
		logger.info("param : "+val);
		return service.getSend(val);
	}
	
	@PostMapping(value = "/post/send/{val}")
	public List<Map<String, Object>> postSend(@PathVariable String val,
			@RequestHeader Map<String,String> header){
		logger.info("val"+val);
		logger.info("param : "+header);
		
		String key = header.get("authrorization");
		
		return service.postSend(val,key);
	}
	
	@GetMapping(value="/get/fluxTest")
	public List<Map<String, Object>> fluxTest(){
		return service.fluxTest();
	}

}
