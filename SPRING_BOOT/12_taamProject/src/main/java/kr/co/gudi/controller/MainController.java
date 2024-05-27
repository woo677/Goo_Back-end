package kr.co.gudi.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.service.MainService;

// 페이지 이동보다 ajax 통신이 더 많을거 같으면...
@RestController
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Autowired MainService service; // 필드 주업
	// 서비스가 서비스를 부를때 순환패턴이 발생할 수 있다
	// 서비스가 컨트롤러를 부를 수는 없다
	private final MainService service;
	
	public MainController(MainService service) {
		this.service = service;
	}
	
	
	
	@RequestMapping(value="/")
	public ModelAndView home(Model model) {
		return new ModelAndView("list");
	}
	
    @GetMapping("/getTeamList.ajax")
    public Map<String, Object> list() {
    	logger.info("팀원 리스트 페이지 이동");
    	return service.getTeamList();
    }
    
    //url에 값이 들어올 경우 다음과 같이 받아 준다
    // url 에 변화되는 값이있으면 {}로 표시해 준다
    //@PathVariable : 경로안에 변수가 있다 를 받겠다
    @PutMapping(value = "/update/{col}/{val}/{pk}")
    public Map<String, Object> update(@PathVariable Map<String, String> param){
    	service.update(param);
    	logger.info("update 요청 : "+param);
    	
    	return null;
    }

}
