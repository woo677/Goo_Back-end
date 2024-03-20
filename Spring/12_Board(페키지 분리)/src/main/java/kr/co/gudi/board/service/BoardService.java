package kr.co.gudi.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.board.dao.BoardDAO;
import kr.co.gudi.board.dto.BoardDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired  BoardDAO dao;

	public List<BoardDTO> list() {
		return dao.list();
	}

	public void del(String idx) {
		int row = dao.del(idx);
		logger.info("삭제 갯수 : "+row);
	}
	
}
