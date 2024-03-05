package chap10.ex12;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class CopyExam {

	public static void main(String[] args) {
		//1.위치지정+ 주스트림 준비(가져올곳,내보낼곳)
		
		//2.보조스트림 준비
		
		//3.읽어오기
		
		//4.쓰기
		
		//5.자원반납(flush,close)
		
		
		//java NIO
		//1.위치지정 (가져올곳,내보낼곳)
		Path from = Paths.get("C:/img/high.gif");
		Path to = Paths.get("C:/img/nio/high.gif");;
		
		
		//2.읽어오기 + 쓰기 = copy 메서드 사용
		Files.copy(from, to ,StandardCopyOption.REPLACE_EXISTING);
		/*
		 * REPLACE_EXISTING : 이미 파일이 존재할 경우 덮어쓴다.(이 옵션이 없으면 파일 존재시 예외 발생)
		 * COPY_ATTRIBUTES  : 
		 * */

	}

}
