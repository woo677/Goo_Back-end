package kr.co.photo.board.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import kr.co.photo.board.dao.BoardDAO;
import kr.co.photo.board.dto.BoardDTO;
import kr.co.photo.board.dto.PhotoDTO;

@Service
public class BoardService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;
	
	//사진 불러오기 시 server.xml 에 아래 내용 추가해야함
	//<Context docBase="C:/upload" path="/photo"/>
	
	//파일 저장 경로 지정 (/이게 없으면 경로가 된다)
	public String file_root = "C:/upload/";

	public List<BoardDTO> list() {
		return dao.list();
	}

	//글쓰기
	public int write(MultipartFile[] photos, Map<String, String> param) {
		int row  =-1;
		
		
		logger.info("roe : "+row);
		
		//insert 후 생성된 idx 가져오는 방법
		//조건1.  파라메터는 DTO로 넣을것
		BoardDTO dto = new BoardDTO();
		dto.setUser_name(param.get("user_name"));
		dto.setSubject(param.get("subject"));
		dto.setContent(param.get("content"));
		row = dao.write(dto);//글쓰기 완료
		
		//조건3. 이후dto 에서 저장된 키 값을 받아온다
		int idx = dto.getIdx();
		logger.info("idx = "+idx);
		
		
		if(row >0) {
			fileSave(idx, photos); //파일 저장
			
		}
		
		
		return row;
		
	}
	
	//파일 업로드
	private void fileSave(int idx,MultipartFile[] photos) {
		
		for(MultipartFile photo : photos) {
			//1. 업로드할 파일 명이 있는가
			String fileName = photo.getOriginalFilename();
			logger.info("fileName"+fileName);
			if(!fileName.equals("")) { // 파일일면이 있다면 == 업로드 파일이 있다면
				//1. 기존 파일명에서 화가장자 추출(high.gif)
				
				/*
				 * //1-1 split 활용 방법
				 * String arr[] = fileName.split("\\.");
				 * String ext ="."+arr[arr.length-1];
				 */			
				
				//1-2 substrings 활용 법(뒤어서 부터 찾는다)
				String ext = fileName.substring(fileName.lastIndexOf("."));
				
				
				//2. 새 파일명 생성
				String newFileName = System.currentTimeMillis()+".jpg";
				logger.info(fileName+"->"+newFileName);
				
				//3 파일 저장(바이널을 뽑아온다)
				try {
					byte[] bytes =  photo.getBytes(); // MultipartFile 로 부터 바이너리 추출
					Path path = Paths.get(file_root+newFileName); //저장결로 지정
					Files.write(path,bytes);//저장
					dao.fileWrite(fileName,newFileName,idx);
					Thread.sleep(1); //파일명을 위해 강제 휴식 부여
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//스플릿 : 
				//서브 스트링
			}
			
		}
			
		}
		
		
		

	public void detail(String idx, Model model) {
		dao.bHit(idx);// 조회수 증가
		BoardDTO dto = dao.detail(idx);
		model.addAttribute("bbs",dto);
		List<PhotoDTO> list = dao.photos(idx);
		logger.info("list : {} ",list);
		model.addAttribute("photos",list);
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
