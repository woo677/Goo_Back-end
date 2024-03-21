package kr.co.photo.board.controller;

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

import kr.co.photo.board.dto.BoardDTO;
import kr.co.photo.board.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService service;
	
	
	//리스트 페이지 접속
	@RequestMapping(value = "/list")
	public String list(Model model,HttpSession session) {
		String page = "login";
		String id = (String) session.getAttribute("loginId");
		logger.info("리스트 접속");
		
		if(session.getAttribute("loginId")!=null) {
			page = "list";
			List<BoardDTO> list = service.list();
			model.addAttribute("list",list);
			logger.info("list.size : "+list.size());
			model.addAttribute("loginBox","<div>환영합니다"+id+"님<a href='logout'>로그아웃</a></div>");
		}else {
			model.addAttribute("msg","로그인이 필요 합니다");
		}
		
		return page;
	}
	
	//글쓰기 페이지 접속
	@RequestMapping(value = "/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	//글쓰기 (회원가입(DB한데 데이터를 저장 시킨다))
	@RequestMapping(value = "/write",method = RequestMethod.POST)
	public String write (HttpSession session,@RequestParam Map<String,String>param) {
		String page= "redirect:/list";
		String msg = "글쓰기 실폐";
		logger.info("param : {}",param);
		
		if(session.getAttribute("loginId")!=null) {
			int row = service.write(param);
			if (row !=1) {
				page = "writeForm";
			}
			
		}
		
		
		return page;
	}
	
	//자세히 보기 (DB에서 데이터를 가져온다)
	@RequestMapping(value = "/detail")
	public String detail(Model model,HttpSession session,String idx) {
		String page = "redirect:/list";
		logger.info("idx : "+idx);
		
		if(session.getAttribute("loginId")!=null) {
			BoardDTO dto =  service.detail(idx);
			page = "detail";
			model.addAttribute("bbs",dto);
		}
		
		
		return page;
	}
	
	//로그아웃 (세션에 있는 값을 지운다)
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		logger.info("loginId",session);
		return "login";
	}
	
	//페이지 수정페이지에 내용 뜨게 하기
	@RequestMapping(value = "/updateForm")
	public String updateForm(Model model,HttpSession session,String idx) {
		String page = "redirect:/";
		if(session.getAttribute("loginId")!=null) {
			page = "updateForm";
			BoardDTO dto = service.updateForm(idx);
			model.addAttribute("bbs",dto);
		}
		
		
		return page;
	}
	
	//게시판 내용 수정 (회원가입(DB에 데이터를 저장한다(수정한다)))
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(Model model,HttpSession session,@RequestParam Map<String,String> param) {
		String page = "redirect:/list";
		
		if(session.getAttribute("loginId")!=null) {
			service.update(param);
			page = "redirect:/detail?idx="+param.get("idx");
		}
		
		return page;
	}
	
	//삭제(회원 삭제)
	@RequestMapping(value = "/del")
	public String del(Model model,HttpSession session,String idx) {
		String page = "redirect:/";
		
		if(session.getAttribute("loginId")!=null) {
			service.del(idx);
			model.addAttribute("msg","삭제 성공");
			page = "redirect:/list";
		}
		
		return page;
	}
	

}
