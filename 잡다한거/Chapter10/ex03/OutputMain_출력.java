package chap10.ex03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputMain_출력 {

	public static void main(String[] args) throws IOException {
		String content = "Hello, JAVA I.O"; //content 라는 변수에 (Hello, JAVA I.O) 라는 내용을 입력한다.
		
		//1.파일 위치 지정(1번과 2번을 합칠수 있다)
		File file = new File("C:/img/temp/write.txt"); // file 이라는 변수 종류에 file이라는 변수를 선언하고 
		
		if (file.exists() == false) {
			file.createNewFile();
		}
		//2.파일 객체 생성
		//3.빨대 준비(파일객체 , 이어쓰기 여부)
		FileWriter writer = new FileWriter(file,true);
		//4.내보내기
		writer.write(content+"\r\n");
		//5.자원반납(flush + close)
		writer.flush();
		writer.close();

	}

}
