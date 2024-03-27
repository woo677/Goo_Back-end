package kr.co.back.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.back.board.dto.BoardDTO;
import kr.co.back.board.service.BoardService;


@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardService boardService;
	
	@RequestMapping(value = "/list")
	public String list() {
		return "list";
	}
	
	@RequestMapping(value = "/list.ajax")
	@ResponseBody
	public Map<String, Object> listCall(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BoardDTO> list = boardService.list();
		
		map.put("list", list);
		
		return map;
	}
	
	//배열 형태로 들어올 경우 따로 명시를 해 줘야 한다
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> del(@RequestParam (value = "delList[]") List<String> delList){
		logger.info("delList : {}",delList);
		
		int cnt = boardService.del(delList);
		logger.info("del count : "+cnt);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cnt", cnt);
		
		
		return map;
	}
}
