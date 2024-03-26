package kr.ajax.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ajax.board.dao.BoardDAO;
import kr.ajax.board.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired BoardDAO boardDAO;

	Logger logger = LoggerFactory.getLogger(getClass());

	public List<BoardDTO> list() {
		logger.info("서비스 접근");
		return boardDAO.list();
	}
	
}
