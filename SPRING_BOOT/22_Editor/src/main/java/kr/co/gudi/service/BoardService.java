package kr.co.gudi.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.BoardDAO;
import kr.co.gudi.dto.BoardDTO;

@Service
public class BoardService {


	@Autowired BoardDAO dao;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	public void write(Map<String, String> param) {
		int row = dao.write(param);
		logger.info("insert row : "+row);
		
	}

	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView("list");
		List<BoardDTO> list= dao.list();
		mav.addObject("list",list);
		return mav;
	}

	public ModelAndView detail(String idx) {
		ModelAndView mav = new ModelAndView("detail");
		BoardDTO dto = dao.detail(idx);
		mav.addObject("bbs",dto);
		return mav;
	}
	
	
}
