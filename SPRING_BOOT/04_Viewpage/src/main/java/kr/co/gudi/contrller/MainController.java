package kr.co.gudi.contrller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/")
	public String home() {
		logger.info("메인페이지 요청");
		//main 이라는 문자열에
		// prefix = /views/
		// suffix = .jsp
		//를 이용하여 /views/main.jsp을 찾아서 이동 시킨다.
		return "main";
	}
	
	@RequestMapping(value = "/calc",method = RequestMethod.POST)
	public String clac(int val1,int val2, String oper,Model model) {
		logger.info("계산 처리중");
		logger.info("val1 : "+val1);
		logger.info("val2 : "+val2);
		logger.info("oper : "+oper);
		int result = 0;
		
		if (oper.equals("+")) {
			result = val1+val2;
		}
		if (oper.equals("-")) {
			result = val1-val2;
		}
		if (oper.equals("*")) {
			result = val1*val2;
		}
		if (oper.equals("/")) {
			result = val1/val2;
		}
		logger.info("결과 : "+result);
		model.addAttribute("result",result);
		
		return "result";
	}
	
}
