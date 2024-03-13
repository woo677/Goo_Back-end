package com.sprng.main;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) { //HttpServletRequest : Reques(리쿼스트)의 이름을 지정 할 수 있다
		
		String param =  req.getParameter("param");
		System.out.println("param : "+ param); // 찍힌 값만 알려준다
		logger.info("param : {}",param); // 어느 페키지에 있는 값이 찍혔는지 알려준다
		
		Object val = "";
		
		if (param!=null && param.equals("greeting")) {
			val = "안녕하세요";
		}else if (param!=null && param.equals("date")){
			val = new Date().toString();
		}
		
		model.addAttribute("msg",val); //msg 로 val값을 보낸다

		
//		switch (param) { //버전을 잘 확인 하자 (않되는 이유 : 17버전 부터 스위치 문에 문자열을 넣을수 있다
//		case "gree":
//			break;
//
//		default:
//			break;
//		}
//		
		
		return "index";
	}
	
	//컨트롤러 : 맨 앞에서 일하는 애
	//@RequestMapping(리쿼스트 멥핑) : 어떠한 요청으로 왔을때 무었을 할것인가
	//value : index 로 요청이 오면 index() 메서드를 실행 해라
	//method : get 방식 으로만 받겠다 
	@RequestMapping(value = "/index" , method = RequestMethod.GET)
		public String index(Model model) { // Model 이라는 녀석으로 jsp 에 데이터를 보낼 수 있다(Model MVC 하고 전혀 관계가 없다)
			//logger.info : 메서드가 실행 되면 콘솔에서 내용을 보내준다
			logger.info("/index 요청"); // 정상 실행이 되는 지 꼭 확인 해라
			//name(jsp 에서 el 태그호 부를때 사용하는 이름), value
			model.addAttribute("msg","index 페이지에 오셔습니다"); // msg 라는 이름으로 value값을 전송 한다
			return "index"; // String인 이유 :  가야할 jsp 이름을 명시 하기 위해서
		}
	
	
	// 문제
	// /main 으로 요청이 오면 main() 메서드를 실행 하도록
	// jsp로 전달될 문구는 "main 페이지에 오셨습니다"
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
		public String main(Model model) {
			logger.info("/main 요청");
			model.addAttribute("msg","main 페이지에 오셨습니다");
			return "index";
	}
	
	
	
	
	
	
	
	
	
}
;