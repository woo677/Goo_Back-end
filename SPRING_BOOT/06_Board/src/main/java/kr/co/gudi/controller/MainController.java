package kr.co.gudi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gudi.dto.BoardDTO;
import kr.co.gudi.service.MainService;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MainService service;
	
	@RequestMapping(value = "/")
	public String list(Model model) {
		List<BoardDTO> list  = service.list();
		model.addAttribute("list",list);
		logger.info("list : {}",list);
		
		return "list";
	}
	
	
	
}
