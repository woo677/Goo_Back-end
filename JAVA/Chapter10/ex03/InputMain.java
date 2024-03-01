package chap10.ex03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class InputMain {

	public static void main(String[] args) throws IOException {
		// 1. 일어올 파일 위치 설정 + 2. 파일 객체화
		File file = new File("C:/img/temp/test.txt");
		
		// 3. 읽어들일 빨대(InputStream) 준비
		FileReader reader = new FileReader(file, Charset.forName("UTF-8"));
				
		// 4. 읽어와서 출력
		// 아스키코드로 읽어온다.
		// 그리고 더이상 읽을 내용이 없다면 -1 반환(End Of File)
		int data;
		
		while((data=reader.read()) != -1) {
			System.out.print((char)data);
		}
			
		// 5. 다쓴 빨대(InputStream) 반납
		reader.close();
		
		
	}

}
