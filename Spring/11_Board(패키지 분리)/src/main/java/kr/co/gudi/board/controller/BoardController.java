package kr.co.gudi.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gudi.board.dto.BoardDTO;
import kr.co.gudi.board.service.BoardService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired  BoardService service;

	//리스트
	@RequestMapping(value = "/list")
	public String list(Model model,HttpSession session) {
		
		String page = "login";
		String id = (String)session.getAttribute("loginId");
		
		if(id !=null) {
			page = "list";
			List<BoardDTO> list = service.list();
			model.addAttribute("list",list);	
			logger.info("list size : "+ list.size());
			model.addAttribute("loginBox","<div>안녕하세요 "+id+"님<a href='logout'>로그아웃</a></div>");
		}else {
			model.addAttribute("msg","로그인이 필요한 서비스 입니다");
			
		}
		
		return page;
	}
	
	//글 지우기
	@RequestMapping(value = "/del")
	public String del(Model model,HttpSession session,String idx) {
		String page = "redirect:/";
		logger.info("idx : "+idx);
		
		
		if(session.getAttribute("loginId")!=null) {
			page = "redirect:/list";
			service.del(idx);
			model.addAttribute("msg","삭제 성공");
		}
		return page;
	}
	
	//로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	
}
