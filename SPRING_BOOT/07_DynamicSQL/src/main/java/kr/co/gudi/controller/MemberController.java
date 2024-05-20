package kr.co.gudi.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dto.MemberDTO;
import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {

	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value = "/")
	public String joinForm() {
		logger.info("회원가입");
		return "joinForm";
	}
	
	
	//parameter 받아오는 방식 : String, HasMap, List , DTO
//	dto 를 파라메터로 이용 하려면 post 방식으로 보내야 한다.
	//파라메터 명과 dto 필드 명이 서로 일치 해야 한다.
//	인설트를 시키는 동시에 키 값을 받아올때 쓴다(ex : 사진저장)
//	@PostMapping : post로 만 받겠다
	@PostMapping(value = "/join.do")
	public ModelAndView join(MemberDTO dto) {
		//Model :  보낼 데이터를 담는 오브젝트, 인터페이스 이미로 무조건 컨트롤러에서 받아서 넘겨줘야 한다.
		//ModelAndView : model + view, 객체이므로 사용하고 싶은 곳에서 객체화 하여 사용 가능하다. (보낼 데이터와 페이지를 담을 수 있다)
		logger.info(dto.getId()+" / "+dto.getPw());
		
		
		return service.join(dto);
	}
	
	@GetMapping(value = "/list.do")
	public ModelAndView list(@RequestParam Map<String, String> params) {
		logger.info("params : {}",params);
		
		return service.list(params);
	}
	
	//{} : 복수개의 메서드를 수용하는 법
	//@RequestMapping은 복수개의 메서드를 수용 할 수 있다.
	@RequestMapping(value = "/multi.do",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView multi(@RequestParam List<String> name) {
		logger.info("name = "+name);
		return service.multi(name);
	}
	
	@PostMapping(value = "/update.do")
	public ModelAndView update(@RequestParam Map<String, Object> param) {
		logger.info("param : "+param);
		
		return service.update(param);
	}
	
}
