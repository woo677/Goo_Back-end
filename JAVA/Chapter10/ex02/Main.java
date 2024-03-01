package chap10.ex02;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		// java.io.File 객체는 파일과 디렉토리에 관련된 모든 기능을 가지고 있다.
		File dir = new File("C:/img/temp");
				
		// 1. 폴더가 존재하지 않으면 생성 하기
		if(dir.exists() == false) {
			System.out.println("폴더 없음 생성 시작!");
			dir.mkdirs();
		}
				
		// 2. 파일 생성 하기
		File file = new File("C:/img/temp/test.txt");
		file.createNewFile();
		
		// 3. 폴더 정보 알아보기
		dir = new File("C:/");
		
		/* 어떤 파일들이 있는지?(이름만 알아보기) - 파일과 폴더 이름을 다 알려 주는데 구분은 안 해 준다.
		String[] fileNames = dir.list();
		for (String name : fileNames) {
			System.out.println(name);
		}
		*/
		
		File[] files = dir.listFiles();
		for (File f : files) {			
			String gubun = "[파일]";			
			if(f.isDirectory()) {
				gubun = "[폴더]";
			}			
			System.out.println(gubun+" "+f.getName()+" "+(f.length()/1024)+"KB");
		}
		

	}

}
