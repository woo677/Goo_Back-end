package kr.ajax.board.service;

import java.io.File;
import java.nio.file.Files;
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

	private String root_path = "C:/upload/";
	
	public List<BoardDTO> list() {
		logger.info("서비스 접근");
		return boardDAO.list();
	}

	public int del(List<String> delList) {
		
		int cnt =0;
		
		for (String idx : delList) {
			//1. 게시글에 파일명(new_filename) 확보
			List<String> files = boardDAO.getFiles(idx);
			//2. bbs 에서 글 삭제
			cnt += boardDAO.del(idx);
			//3. 파일 삭제
			logger.info("files : {}",files);
			delFile(files);
			
			
			
		}
		
		return cnt;
	}

	private void delFile(List<String> files) {
			for (String name : files) {
				File file = new File(root_path+name);
				if (file.exists()) {
					file.delete();
				}
			}
		
	}
	
}
