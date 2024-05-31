package kr.co.gudi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${prof.name}") private String name;
	@Value("${db.addr}") private String addr;
	@Value("${db.username}") private String username;
	@Value("${db.password}") private String password;
	
	@GetMapping(value = "/")
	public String home() {
		logger.info("profile name : "+name);
		logger.info("profile addr : "+addr);
		logger.info("profile username : "+username);
		logger.info("profile password : "+password);
		
		// run as  > Run Configuration
		
		// 1. 내장 톰캣
		// Spring Boot App 옵션 에서 profile 을 dev 로 선택후 실행
		
		// 2. 외장 톰캣
		// arguments 에서 -Dspring.profiles.active=dev 추가
		// Environment 에서 spring.profiles.active 와 dev 를 추가
		
		//3. 실제 톰캣에서 배포시
		// conf/catalina.properties 에 다음 내용을 추가 해 준다.
		// spring.profiles.active=dev
		
		
		return "OK";
	}
}
