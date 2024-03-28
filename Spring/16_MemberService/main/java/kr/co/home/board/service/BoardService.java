package kr.co.home.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.home.board.dao.BoardDAO;
import kr.co.home.board.dto.BoardDTO;

@Service
public class BoardService {
	@Autowired BoardDAO BoardDAO;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public List<BoardDTO> list() {
		return BoardDAO.list();
	}

	public int del(List<String> delList) {
		int cnt = 0;
		//1.게시글에 연결된 파일명
		for (String idx : delList) {
			List<String> files = BoardDAO.getFiles(idx);
			//2.bbs 에서 해당 글 삭제
			cnt += BoardDAO.del(idx);
			//3.파일 삭제 List로 받아야 겠지 for문으로 돌려서 하나씩 지워라
			logger.info("files : {} ",files);
			delFile(files);
		}
		
		
		return cnt;
	}

	private void delFile(List<String> files) {
		
	}
}
