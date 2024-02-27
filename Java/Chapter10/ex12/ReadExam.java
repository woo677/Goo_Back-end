package chap10.ex12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadExam {

	public static void main(String[] args) throws IOException {
		// java IO
		// 1. 위치 지정 + 주스트림 준비
		// 2. 보조스트림 준비
		// 3. 읽기
		// 4. 자원 반납
		
		// java NIO
		// 1. 위치 지정
		Path path = Paths.get("C:/img/temp/test.txt");
		
		// 2. 읽기 - 일반 바이너리 파일의 경우 readBytes(path)
		List<String> lines = Files.readAllLines(path);
		for (String str : lines) {
			System.out.println(str);
		}
		
	}

}








