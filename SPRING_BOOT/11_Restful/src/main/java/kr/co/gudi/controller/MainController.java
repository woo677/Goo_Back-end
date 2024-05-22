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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@GetMapping(value = "/rest/strMap.ajax")
	public Map<String, Object> strMap() throws Exception{
		//json 형태의 문자열(다른 서버에 요청할 경우 이렇게 json 형태의 문자열을 받게 된다)
		String json = "{\"on\":1,\"msg\":\"HahMap 변환 완료\",\"name\":\"정민우\"}";

		//문자열을 자바로 바꾸는 법
		
		//jackson을 여기서 사용함
		ObjectMapper mapper = new ObjectMapper();
		// 어떤 문자열을, 어떤 데이터 타입으로 변환 할래?
		// Map의 제너릭이 지정되지 않아 비효율 적이라고 경고!
		// <> : 제너릭이 있는 경우에는 참조 할게 있어야한다
		//Map<String, Object> result = mapper.readValue(json, Map.class);
		Map<String, Object> result = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
		logger.info("on : "+result.get("on"));
		logger.info("msg : "+result.get("msg"));
		logger.info("name : "+result.get("name"));
		
		return result;
	}
	
	@GetMapping(value = "/rest/strObject.ajax")
	public UserInfo strObject() throws Exception{
		//json 형태의 문자열(다른 서버에 요청할 경우 이렇게 json 형태의 문자열을 받게 된다)
		String json = "{\"id\":\"json_ID\",\"name\":\"홍길동\",\"age\":33,\"promotion\":true}";

		//문자열을 자바로 바꾸는 법
		
		//jackson을 여기서 사용함
		ObjectMapper mapper = new ObjectMapper();
		
		//<> 제너릭이 없기 때문에 참조할것이 따로 없다
		UserInfo info = mapper.readValue(json, UserInfo.class);
		logger.info("id : "+info.getId());
		logger.info("name : "+info.getName());
		logger.info("age : "+info.getAge());
		logger.info("Promotion : "+info.isPromotion());
		
		return info;
	}
	
	
}
