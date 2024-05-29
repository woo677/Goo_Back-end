package kr.co.gudi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.JsoupService;

@Controller
public class JsoupController {
	
	Logger logger  = LoggerFactory.getLogger(getClass());
	
	@Autowired JsoupService service;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	//한 페이지 자체를 뜯어온다
	@GetMapping(value = "/connect.do")
	public String connect(Model model) throws IOException {
		
		// 가저 오고 싶은 사이트에 URL을 선언
		String url = "https://sports.news.naver.com/wbaseball/record/index";
		
		//?category=mlb&year=2024
		// URL 뒤에 ?(파라메터)뒤에 값을 입력해 주고 싶으면 선언,입력 
		Map<String, String> param = new HashMap<String, String>();
		
		//파라메터 뒤에 들어갈 파라메터 값
		param.put("category", "mlb");
		param.put("league", "AL");
		param.put("year", "2024");
		
		// 필요한 사이트에 정보를 가져온다
		// connect : 정보를 가져올 url 입력
		// data : ?(파라메터) 뒤에 들어갈 값 입력
		// get : 사이트에 정보를 가져온다
		Document doc = Jsoup.connect(url).data(param).get();
		logger.info(doc.toString());
		model.addAttribute("elem",doc);
		return "result";
	}
	
	
	//내가 원하는 값만 가져오기
	@GetMapping(value = "/getElem.do")
	public ModelAndView getElem() throws IOException {
		
		//필요한 정보에 사이트 주소 선언
		String url = "https://www.itworld.co.kr/howto";
		
		//data에 원하는 파라메터의 값을 직접 입력 할 수 있다.
		Document doc = Jsoup.connect(url).data("page","1").get();//data 에는 ? 뒤에 값을 넣으면 된다
		
		return service.getElem(doc);
	}
	

}
