package kr.co.back.board.service;

import java.io.File;
import java.util.List;

import javax.sound.sampled.Line;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.back.board.dao.boardDAO;
import kr.co.back.board.dto.BoardDTO;

@Service
public class BoardService {
	
Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired boardDAO boarddao;
	
	private String root_path = "C:/upload/";

	public List<BoardDTO> list() {
		logger.info("서비스 접근");
		return boarddao.list();
	}

	//파일을 삭제 하기 위해서는 여러 과정을 거처야 한다
	public int del(List<String> delList) {
		
		int cnt =0;
		
		//삭제가 한번에 여러개가 진행 될때를 대비
		for (String idx : delList) {
			logger.info("idx : "+idx);
			
			//1. 게시글에 파일명(new_filename) 확보
			List<String> files = boarddao.getFilse(idx);
			
			//2. bbs 에서 글 삭제
			cnt += boarddao.del(idx);
			
			//3. 파일 삭제
			logger.info("files : {}",files);
			delFile(files);
		}
		
		return cnt;
	}

	private void delFile(List<String> files) {
		for (String name: files) {
			File file = new File(root_path+name);
			if (file.exists()) {
				file.delete();
			}
		}
		
	}

}
