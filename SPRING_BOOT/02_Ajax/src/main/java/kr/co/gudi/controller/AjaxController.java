package kr.co.gudi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//cross domain issue - CORS, 서로 다른 도메인(서버) 에 있는 자바스크립트와 서버간의 통신을 제한한다.
// 이것을 해결 하기 위해서는 서버에서 요청을 허용 하도록 해줘야 한다
// @CrossOrigin 이 클래스 위에 선언 되어 있으면 해당 메서드들은 모두 허용 한다.
// @CrossOrigin 이 메서드 위에 선언 되어 있으면 해당 메서드만 허용 된다
// @CrossOrigin(origins={"허용 url","허용  url2",})과 같이 특정 url 만 허용할 수도 있다.

@CrossOrigin
@RestController
public class AjaxController {

	@RequestMapping(value = "/")
	public Map<String, Object> home(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "Hello");
		return map;
	}
	
	@RequestMapping(value = "/list")
	public Map<String, Object> list(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		list.add("fist");
		list.add("second");
		list.add("third");
		map.put("list",list);
		return map;
	}
	
}
