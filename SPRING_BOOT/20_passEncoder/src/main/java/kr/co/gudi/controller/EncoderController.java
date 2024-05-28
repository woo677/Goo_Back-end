package kr.co.gudi.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncoderController {

	// 아까 등록한 빈 사용
	@Autowired PasswordEncoder encoder;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private String hash = "";
	
	@GetMapping(value = "/encode/{msg}")
	public Map<String, String> encode(@PathVariable String msg){
		logger.info("평문(plain text) - "+msg);
		hash = encoder.encode(msg); // encode(인코드) : 문자를 암호화 한다
		logger.info("암호문(encoder text) - "+hash);
		
		// 같은 평문을 넣어도 암호문은 그때그때 달라진다
		// 암호화시 sault 라는 값을 넣어서 암호화 하기 때문이다
		// 그래서 평문을 암호화 하여 기존 암호화 문구와 비교하는 방식으로 암호문을 풀어낼 수 있다.
		// 암호와된 것을 
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("plain", msg);
		map.put("encode", hash);
		return map;
	}
	
	//암호화된 코드를 확인 하는 법
	@GetMapping(value = "/decode/{msg}")
	public Map<String, Boolean> decode(@PathVariable String msg){
		logger.info("평문(plain text) - "+msg);
		
		boolean success = encoder.matches(msg, hash); // matches : 암호화된 코드가 맞는지 확인한 작업
		logger.info("일치 여부 : "+success);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("match", success);
		return map;
	}
}
