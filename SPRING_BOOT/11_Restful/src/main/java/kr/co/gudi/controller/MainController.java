package kr.co.gudi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dto.UserInfo;

@RestController
//value 의 값으로 요청이 들어오지 않으면 아래있는 코드들은 실행 되지 않는다
//@RequestMapping(value = "/rest") // /rest 로 시작하는 요청은 이 컨트롤러를 타게 된다
public class MainController {
	//@RestController 를 사용하면 모든 반환이 Response 객체에 쓰여지게 되므로 @ResponseBody 를 사용할 필요가 없다
	// 다만 view 로 페이지 이동이 블가능 하다
	// Response : 데이터를 싫을 수 없다
	
	
	Logger logger = LoggerFactory.getLogger(getClass());

	
	@GetMapping(value = "/")
	public ModelAndView home() { //ModelAndView 를 활용 하면 @RestController 에서도 페이지 이동이 가능하다
		logger.info("메인페이지 요청");
		return new ModelAndView("home");
	}

	/*Method 종류
	 * GET : 특정 데이터를 조회할 경우
	 * POST : 특정 데이터 입력을 요청할 경우
	 * DELETE : 특정 데이터 삭제를 요청할 경우
	 * PUT : 특정 데이터 수정을 요청할 경우
	 * PATCH : 특정 데이터 수정(일부)을 요청할 경우
	 */
	
	@GetMapping(value = "/rest/list.ajax")
	public List<String> list(){
		List<String> list = new ArrayList<String>();
		list.add("하나");
		list.add("둘");
		list.add("셋");
		list.add("넷");
		return list;
	}
	
	@GetMapping(value = "/rest/map.ajax")
	public Map<String, Object> map(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "hello");
		map.put("age", "33");
		map.put("married",true);
		return map;
	}
	
	@GetMapping(value = "/rest/object.ajax")
	public UserInfo object() {
		UserInfo info = new UserInfo();
		info.setName("tester");
		info.setName("홍길동");
		info.setAge(40);
		info.setPromotion(false);
		return info;
	}
	
	//파라메터를 받을때 @ResponseBody 로 받아야 한다
	@RequestMapping(value = "/rest/complex.ajax")
	public Map<String, Object> complex(
							@RequestBody Map<String, Object> param){
		
		logger.info("param : {}",param);
		//param : {values={name=숫자넣기, num=[1, 2, 3, 4, 5]}}
		
		Map<String, Object> values = (Map<String, Object>) param.get("values");
		logger.info("values : {}",values);
		//values : {name=숫자넣기, num=[1, 2, 3, 4, 5]}
		
		String name = (String) values.get("name");
		logger.info("name : "+name); // name : 숫자넣기
		
		List<Integer> num = (List<Integer>) values.get("num");
		logger.info("num : "+num); //num : [1, 2, 3, 4, 5]
	
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		
		return map;
	}
	
	
}
