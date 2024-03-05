package chap10.ex03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class IngutMain_입력 {

	public static void main(String[] args) throws IOException {
		// 1.읽어올 파일 위치 설정
		String path = "C:/img/temp/text.txt";
		
		//2.파일 객체화
		File file = new File(path);
		
		//3.읽어들일 빨대(inputStream)준비
		FileReader  reader= new FileReader(file, Charset.forName("UTF-8")); //Reader는 읽어들인다(주로 한글을 읽을때 쓰인다)
		
		//4.읽어와서 출력
		//기본적으로 아스키코드로 읽어온다
		//그리고 더이상 읽을 내용이 없다면 -1반환(EOF (End of file))
		int data;
		while ((data = reader.read()) !=-1) {
			System.out.print((char)data);
		}
		
//		reader.read();
		
		//5.다쓴 빨대(InputStream) 반납
		reader.close(); //반납(문을 열고 닫고)은 반드시 해죠야 한다 안그러면 ...? 데이터가 쌓인다 

	}

}
