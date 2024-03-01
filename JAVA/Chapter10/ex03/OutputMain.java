package chap10.ex03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputMain {

	public static void main(String[] args) throws IOException {
		
		String content = "Hello, JAVA I.O.";
		
		// 1. 파일 위치 지정 + 2. 파일 객체 생성
		File file = new File("C:/img/temp/write.txt");
		if(file.exists() == false) {
			file.createNewFile();
		}
		
		// 3. 빨대 준비(파일객체, 이어쓰기 여부)
		FileWriter writer = new FileWriter(file, true);
		
		// 4. 내보내기
		writer.write(content+"\r\n");
				
		// 5. 자원반납(flush+close)
		writer.flush();
		writer.close();

	}

}
