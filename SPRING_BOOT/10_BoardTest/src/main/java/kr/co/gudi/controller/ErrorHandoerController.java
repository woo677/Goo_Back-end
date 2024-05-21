package kr.co.gudi.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandoerController implements ErrorController{

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/error")
	public String error(HttpServletRequest request,Model model) {
		
		//이미 에러가 있어서 인터페이스로 빌려와서 써야 오류가 안난다
		
		logger.info("error 요청");
		int code = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		model.addAttribute("code",code);
		//아래 내용을 사용자에게 보여줘서는 안되는 내용
		model.addAttribute("excpetion",request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
		
		return "error";
	}
	
}
