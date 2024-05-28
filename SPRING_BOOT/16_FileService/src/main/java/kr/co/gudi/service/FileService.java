package kr.co.gudi.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${spring.servlet.multipart.location}")// 앱플리캐이션에 정보 가져오기
	private String root; //private 여기서 박에 안쓸거기 때문에 (캡슐화)

	public void upload(MultipartFile file) {
		logger.info("서비스 접근");
		
		// 1. 파일명 추출
		String flieName = file.getOriginalFilename();
		// 2. 새파일명 생성
		String ext = flieName.substring(flieName.lastIndexOf(".")) ; //파일 확장자 추출(.포함)
		logger.info("ext : "+ext);
		String newFlieName =System.currentTimeMillis()+ext;// 파일 이름 변경(시간 타임으로)
		logger.info(flieName+"->"+newFlieName);
		// 3. 파일면 저장
		
		try {
			byte[] bytes = file.getBytes(); //파일을 바이트 형태로 추출
			Path path = Paths.get(root+"/"+newFlieName);//파일 저장위치(경로) 지정
			Files.write(path,bytes);//저장경로와 파일 바이트값 저장하기
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//여러장 파일 업로드
	public void multiUpload(MultipartFile[] files) {
		
		for (MultipartFile file : files) { //파일을 하나씩 뽑아낸다
			upload(file);// 파일 업로드하는 메서드 호출
			try {
				Thread.sleep(1); //1ms 단위로 업로드를 하도록 지연시킴
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	//저장된 파일을 리스트 형태로 뽑아서 페이지에 출력해준다
	public List<String> fileList() {
		
//		File file = new File(root);// 내가 저장한 파일위치 가져오기
//		String[] list = file.list();// 저장한 위치에서 파일 뽑아오기
		
		String[] list = new File(root).list(); //체이닝 메서드 (앞에 있는 결과 값으로 뒤에 코드를 실행)
		
		
		return Arrays.asList(list);//가져온 데이터를 리스트 형태로 변환
	}
	
	
	//내가 자기고 있는 사진 출력(이게 없으면 사진이 깨진다(이유 : 파일에 확장자가 .png를 확장자가 아니라 그냥 문자열로 읽어서 문제가 생김))
	public ResponseEntity<Resource> imgView(String fileName) {
		
		
		// 특정 경로에서 파일을 읽어와 Resorce 로 만든다
		Resource resource = new FileSystemResource(root+"/"+fileName);
		
		// 보내질 파일의 형태를 지정해 준다.(보내줄 파일을 헤더에 지정 해야 한다)
		// 메타 데이터 타입을 보내죠서 파일유형을 알려줘 웹이 파일을 올바르게 읽게 한다
		HttpHeaders header = new HttpHeaders();
		// 예 : image/gif, image/png, image/jpg, image/jpeg
		try {
			//데이터의 다양한 형태를 알수 있다.( image/gif, image/png, image/jpg, image/jpeg)
			String type = Files.probeContentType(Paths.get(root+"/"+fileName));// 경로를 주면 해당 파일의 타입을 mim-type 알아낸다.
			logger.info("minw-type : "+type);
			header.add("content-type", type);
			logger.info("header : "+header);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//보낼 내용, 해더,  상태(200 또는 HttpStatus.OK 는 정상이라는 뜻)
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}

	public void delete(String file) {
		File deFile = new File(root+"/"+file);
		if (deFile.exists()) {
			deFile.delete();
		}
		
	}
	
	
	public ResponseEntity<Resource> download(String fileName) {
		
		
		// 특정 경로에서 파일을 읽어와 Resorce 로 만든다
		Resource resource = new FileSystemResource(root+"/"+fileName);
		
		// 보내질 파일의 형태를 지정해 준다.(보내줄 파일을 헤더에 지정 해야 한다)
		HttpHeaders header = new HttpHeaders();
		// 예 : image/gif, image/png, image/jpg, image/jpeg
		try {
			// image/... 는 이미지, text/... 는 문자열, applications/octet-stream 는 바이너리
			header.add("content-type", "applications/octet-stream");//content-type
			// 보낼 파일 이름
			// content-Disposition : 니가 보낼려는 컨텐트의 형태를 의미 한다.inline 이면 문자열, attachment 는 다운로드 파일을 의미()
			// attachment;filename="flieName.jpg"
			// 이때 파일명이 한글일 경우 깨져서 다운로드 된다. 그래서 안전하게 인코딩 해 준다.
			String oriFile = URLEncoder.encode("이미지_"+fileName, "UTF-8");
			header.add("content-Disposition", "attachment;filename=\""+oriFile+"\"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//보낼 내용, 해더,  상태(200 또는 HttpStatus.OK 는 정상이라는 뜻)
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}

}
