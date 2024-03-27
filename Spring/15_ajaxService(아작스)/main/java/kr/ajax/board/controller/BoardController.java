package kr.ajax.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ajax.board.dto.BoardDTO;
import kr.ajax.board.service.BoardService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired  BoardService boardservice;
	
	// 동기 방식
	@RequestMapping(value = "/")// "/"요청이 오면..
	public String list() {
		logger.info("리스트 접근");
		
		//List<BoardDTO> list = boardservice.list();
		//model.addAttribute("list",list); //모델에 테이터를 받아서
		
		return "list"; //특정한 페이지(list.jsp)로보낸다
	}
	
	//비동기 방식 : 일단은 페이지에 도착한다음
	@RequestMapping(value = "/list.ajax")
	@ResponseBody //response 객체로 반환 하는데...
	//아작스 하고 그나마 비슷한거
	public Map<String, Object> listCall(){
		// 아작스로 값을 보내기 위해 선언
		Map<String, Object> map = new HashMap<String, Object>();
		//리스트의 데이터를 받아온다(아작스에 data값을 받아오기도 한다)
		List<BoardDTO> list = boardservice.list();
		//map.put("이름",데이터 값)Map에 (키,데이터 값)을 넣을때 쓴다
		map.put("list", list);
		return map; // 여기에서 처리된 데이터를 리턴 해준다 
	}
	
	// 배열 형태로 들어올 경우 따로 명시를 해 줘야 한다.
		@RequestMapping(value="/del", method=RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> del(@RequestParam(value="delList[]") List<String> delList){
			logger.info("del list : {}",delList);
			
			
			int cnt = boardservice.del(delList);
			logger.info("del count : "+cnt);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cnt", cnt);
			
			return map;
		}
	
}
