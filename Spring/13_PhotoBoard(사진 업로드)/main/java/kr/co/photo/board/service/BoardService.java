package kr.co.photo.board.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.photo.board.dao.BoardDAO;
import kr.co.photo.board.dto.BoardDTO;

@Service
public class BoardService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;

	public List<BoardDTO> list() {
		return dao.list();
	}

	public int write(Map<String, String> param) {
		int row = dao.write(param);
		logger.info("roe : "+row);
		return row;
		
	}

	public BoardDTO detail(String idx) {
		dao.bHit(idx);// 조회수 증가
		return dao.detail(idx);
	}

	public BoardDTO updateForm(String idx) {
		return dao.detail(idx);
	}

	public void update(Map<String, String> param) {
		int row = dao.update(param);
				logger.info("수정 적용 확인 : "+row);
	}

	public void del(String idx) {
		int row = dao.del(idx);
		logger.info("삭제 적용 확인 : "+row);
	}

}
