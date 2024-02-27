package chap10.ex06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferMain {

	// 이미지 복사하기 
	public static void main(String[] args) throws Exception {
		
		// 1-1. 읽어올 위치 + 파일객체 + 읽어올 스트림
		FileInputStream fis = new FileInputStream("C:/img/high.gif");
		// 1-2. 내보낼 위치 + 파일객체 + 내보낼 스트림
		FileOutputStream fos  = new FileOutputStream("c:/img/high_copy.gif");
		
		// 보조 스트림 준비
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		long start = 0;
		long end = 0;
		
		// 2. 읽어오기 -> 쓰기
		int data;
		start = System.currentTimeMillis();
		while( (data = bis.read()) != -1 ) {
			bos.write(data);
		}
		System.out.println("저장 완료");
		end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(end-start)+" ms");
		
		// 3. 자원 반납(flush, close)
		bis.close();
		bos.flush();
		bos.close();
		

	}

}
