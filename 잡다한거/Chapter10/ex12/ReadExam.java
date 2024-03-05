package chap10.ex12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadExam {

	public static void main(String[] args) throws Exception {
		//java IO방식
		//1.읽을 파일 위치 지정 , 파일객채 , 주스트림
		
		//2.보조스트림
		
		//3.읽기
		
		//4.반환하기
		
		
		//java NIO방식
		//1.읽을 파일 위치 지정
		Path pat = Paths.get("C:/img/temp/text.txt");

		//2.읽기 - 일반 바이너리 파일의 경우 readBytes(path)
		List<String> lines =  Files.readAllLines(pat);
		for (String str : lines) {
			System.out.println(str);
		}

	}

}
