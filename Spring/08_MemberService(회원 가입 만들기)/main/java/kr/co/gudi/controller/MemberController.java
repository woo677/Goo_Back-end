package kr.co.gudi.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.gudi.dto.MembereDTO;
import kr.co.gudi.service.MemberService;

@Controller //@Controller라고 알려준다
public class MemberController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	//최초 페이지(로그인) 이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	
	//회원가입 페이지 이동
	@RequestMapping(value = "/joinForm",method = RequestMethod.GET)
	public String joinForm() {
		logger.info("회원가입 페이지 이동");
		return "joinForm";
	}
	
	
	//회원 가입 성공여부확인
	@RequestMapping(value = "/join" ,method = RequestMethod.POST)
	public String join(Model model,HttpServletRequest req) throws UnsupportedEncodingException {
		logger.info("회원 정보 확인");
		
		String msg = "회원가입에 실패 했습니다.";
		
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		
		//정보가 제데로 들어왔는지 확이
		logger.info(id+" , "+pw+" , "+name+" , "+age+" , "+gender+" , "+email);
		
		String page = "joinForm";
		//일 할 객체 선언
		MemberService service = new MemberService();
		int row = service.join(id,pw,name,age,gender,email);
		
		logger.info("확인 여부 : "+msg);
		
		//상황에 때라 페이지 변경 하는 법
		
		if(row ==1 ) {
			page = "login";
			msg = "회원가입에 성공 했습니다";
		}
		logger.info(page);
		
		model.addAttribute("msg",msg);
		
		return page;//상황에 따라 페이지를 다르게 접속 하는법(변수 선언)
	}
	
	//================================================
	
	//로그인
	@RequestMapping(value = "/login")
	// (HttpServletRequest)Request 구 버전에서 신버전으로 넘어오면서 Request.getParameter을 입력하지 않고 직접 받아오는게 가능 해졌다
	public String login(Model model, String id,String pw,HttpSession session) { //Request 대신 이렇게 써도 된다
	
		
			 String page = "login";
			 String msg = "아이디 또는 비밀면호를 확인해 주세요";
			 
			 logger.info(id+" / "+pw);
			 
			 MemberService service = new MemberService();
			 
			 if(service.login(id,pw)) {
				 //"list"은 list.jsp파일로 이동하는 것
				 //redirect:/list 는 같은 컨드롤러(클래스)에 /list라는 요청이 있으면으면 거기로 이동을 한다
				// /list요청으로 이동을 했을때 list하고 다른 점이 없어 보이는 이유는 /list에 return이 있기 때문이다
				 
				 page ="redirect:/list"; //list 라는 요청으로 이동시켜라 /list라는 곳으로 이동 시켜라
				 //msg = id+"님 환영 합니다"; //redirect 사용시 model 의 값을 전달 할 수 없다
				 session.setAttribute("loginId", id);
			 }else {
				 model.addAttribute("msg",msg);
				 
			 }
			 
			 
			 
		return page;
	}
	
	//회원 리스트
	//method = 를 지정하지 않으면 GET,POST,PUT,DELETE 다 받는다
	//보안이 안좋아 지기 때문에 개발이 끝난 다음에 다시 써넣어야 한다
	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		logger.info("회원 리스트 요청");
		String page = "login";
		
		if (session.getAttribute("loginId")!=null) {// 로그인 상태이면
			page = "list";
			MemberService service = new MemberService();
			List<MembereDTO> list =  service.list(); // 여러 개의 대이터를 한번에 묶어서 가져 오는 법
			logger.info("size : {} ",list.size());
			model.addAttribute("list",list);
		}else {
			page = "redirect:/";
		}
		
		return page;
	}
	
	//회원 상세 보기
	@RequestMapping(value = "/detali")
	public String detali(Model model, String id, HttpSession session) {
		logger.info("detali");
		String page = "redirect:/";
		
		if(session.getAttribute("loginId") != null) {
			logger.info("id : " +id);
			
			MemberService service = new MemberService();
			MembereDTO dto = service.deatli(id); //한 컬럼만 가져 올때는 이 방법을 쓴다 // id 는 pk라 id 만으로 가져와도 된다
			model.addAttribute("member",dto);
			
			page = "detali";
		}
		
		return page;
	}
	
	//회원 삭제
	@RequestMapping(value = "/del")
	public String del(Model model,String id , HttpSession session) {
			//1 제데로 접속 했는지 로거 찍기
		logger.info("del 접근");
		
		
		String page = "redirect:/";
		//3 로그인 했는지 확인 하기
		if(session.getAttribute("loginId") != null) {
			logger.info("로그인 성공");
			
			//4 일 할 객제 선언
			MemberService service = new MemberService();
			if(service.del(id)!=-1) {
				logger.info("회원 탈퇴");
				page = "redirect:/list";
			}
			
			
		}
		
		// list 페이지에 뭔가 있어야 반응을 한다
		//그래서 list가 아닌 redirect를 이용 해야한다
		return page;
	}
	
}

