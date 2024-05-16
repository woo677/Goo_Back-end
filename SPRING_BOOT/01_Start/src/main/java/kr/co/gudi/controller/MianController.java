package kr.co.gudi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //ResponseBody 없이 내보낼수 있는 컨트롤러
public class MianController {

	@RequestMapping(value = "/")
//	@ResponseBody
	public Map<String,String> home() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "OK");
		return map;
	}
	
}
