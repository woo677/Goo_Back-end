package my.project.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import my.project.member.dao.MemberDAO;
import my.project.member.dto.MemberDTO;
import my.project.member.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	//매인페이지
	@RequestMapping(value = "/")
	public String main(Model model) {
		logger.info("main에 접근");
		
		String page = "login";
		
		return page;
	}
	
	//회원 가입 이동
	@RequestMapping(value = "/joinForm")
	public String joinForm() {
		logger.info("joinForm 로 이동");
		return "joinForm";
	}

	//회원 가입 버튼을 클릭했을때 반응한다
	//회원 가입이 성공 했다면 성공 메시지를 띠우고(실패 했다면 실패 메시지를 띠우고) join에서 로그인 페이지로 간다
	// 파라메터 값을 여러게 받아와야 할때 : 해쉬맥 을쓴다
	//join을로 왔을때
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(Model model, @RequestParam Map<String, String> param) {
		logger.info("join 접속");
		
		//실패를 가정한다
		String page = "login";
		String msg = "회원가입 실패";
		logger.info("param {} : "+param);
		
		//데이터가 성공적으로 들어갇는지 확인한다
		int row = service.join(param);
		
		//제데로 생성이 됬는지 확인
		if(row ==1) {
			page ="login";
			msg = "회원가입 성공";
		}
		
		
		model.addAttribute("msg",msg);
		
		return page;
	}
	
	//로그인 
	@RequestMapping(value = "/login", method = RequestMethod.POST )
	public String login(Model model ,HttpSession session,String id, String pw) {
		logger.info("login 접근");
		
		//실패 정의
		String page = "/login";
		logger.info("id :{} / pw : {}"+id,pw);
		
		//걍 2개 이하는 파라메터 값을 받아와라
		String lonigId = service.login(id,pw);
		logger.info("login : "+lonigId);
		
		if(lonigId !=null) {
			page = "redirect:/list";
			session.setAttribute("lonigId", lonigId);
		}else {
			model.addAttribute("msg","아이디 또는 비밀번호를 확인 해주세요");
			
		}

		return page; 
	}
	
	//회원 리스트 불러오기
	@RequestMapping(value = "/list")
	public String list(Model model,HttpSession session) {
		logger.info("list 접근");
		String page = "redirect:/";
		
		if (session.getAttribute("lonigId")!=null) {
			page = "list";
			//여러 데이터를 받아올때
			List<MemberDTO> list = service.list();
			model.addAttribute("list",list);
		}
		
		return page;
	}
	
	//회원 자세히 보기
	@RequestMapping(value = "/detali")
	public String detali(Model model,HttpSession session,String id) {
		//실패 가정
		String page = "list";
		
		if(session.getAttribute("lonigId") != null) {
		page = "detali";
		MemberDTO dto = service.detali(id);
		model.addAttribute("member",dto);
		}
		
		
		return page;
	}
	
	
	// 회원 삭제
	@RequestMapping(value = "/del")
	public String del(Model model, HttpSession session,String id) {
		String page = "list";
		int msg =-1;
		
		if(session.getAttribute("lonigId")!=null) {
			page = "redirect:/list";
			msg = service.del(id);
			model.addAttribute("memebr",msg);
		}
		
		return page;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
