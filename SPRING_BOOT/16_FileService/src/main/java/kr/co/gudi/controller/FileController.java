package kr.co.gudi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gudi.service.FileService;

@Controller
public class FileController {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	private final FileService service;
	
	public FileController(FileService service) {
		this.service =service;
	}
	
	@GetMapping(value = "/")
	public String home() {
		logger.info("home 접근");
		return "home";
	}
	
	//파일 업로드
	@PostMapping(value = "/upload")
	public String upload(MultipartFile uploadFile) {
		logger.info("upload 접근");
		logger.info("upload file : "+uploadFile.getOriginalFilename());
		service.upload(uploadFile);
		return "redirect:/fileList";
	}
	
	//파일 여러장 업로드
	@PostMapping(value = "/multiUpload")
	public String multiUpload(MultipartFile[] Files) {
		logger.info("file length : "+Files.length);
		service.multiUpload(Files);
		return "redirect:/fileList";
	}
	
	// 내가 가지고 있는 사진 출력
	@GetMapping(value = "/fileList")
	public String fileList(Model model) {
		List<String> list = service.fileList();
		logger.info("list : {}",list);
		model.addAttribute("list",list);
		return "result";
	}
	
	// 내가 가지고 있는 파일 확장자 읽기
	// ResponseEntity<Resource>core.io 사용
	@RequestMapping(value = "/photo/{fileName}")
	public ResponseEntity<Resource> imgView(@PathVariable String fileName) {
		logger.info("fileName : "+fileName);
		return service.imgView(fileName);
	}
	
	//파일 삭제 방법
	@GetMapping(value = "/delete")
	public String delete(String file) {
		logger.info("delete file name");
		service.delete(file);
		return "redirect:/fileList";
	}
	
	
	@RequestMapping(value = "/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) {
		logger.info("download fileName : "+fileName);
		return service.download(fileName);
	}
	
	
	
}
