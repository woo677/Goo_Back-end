package chap10.ex04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) throws Exception {
		/* 1-1. 읽어올 위치 + 파일 객체
		File src = new File("C:/img/low.gif");
		// 1-2. 내보낼 위치 + 파일 객체
		File dst = new File("C:/img/temp/low_copy.gif");
		*/		
		// 2-1. 읽어올 빨대 준비File 이 앞에 붙으면 파일객체가 내장 되었다.) - 그러므로 파일객체 안만들어도 됨
		FileInputStream fis = new FileInputStream("C:/img/high.gif");		
		// 2-2. 내보낼 빨대 준비
		FileOutputStream fos = new FileOutputStream("C:/img/temp/high_copy.gif");
		
		int i = 0;
		/* 3. 읽어오기 -> 쓰기(안정성이 훨씬 낫다. 하지만 속도가 느리다.)
		int data;		
		while((data = fis.read()) != -1) {
			fos.write(data);
			i++; // 별 의미 없이 그냥 성능 체크 용도
			System.out.println("파일 복사 중..."+i);
		}
		*/
		byte[] arr = new byte[1024];		
		while(fis.read(arr) != -1) { // 배열을 넣으면 얼마나 옮기는지 출력, 이후 더이상 읽을게 없으면 -1 반환
			// 읽은 데이터는 매개변수로 주워진 배열에 담긴다.
			fos.write(arr);
			i++; // 별 의미 없이 그냥 성능 체크 용도
			System.out.println("파일 복사 중..."+i);
		}
		
		
		// 4. 자원반납(flush, close)
		fis.close();
		fos.flush();
		fos.close();
	}

}
