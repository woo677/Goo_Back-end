package chap10.ex06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferMain {

	//이미지 복사하지
	public static void main(String[] args) throws Exception {
		
//		1.읽어올 위치 + 파일객체 + 읽어올 스트림
		FileInputStream fis = new FileInputStream("C:/img/1.png");//읽어 들여올 명
//		2.내보낼 위치 + 파일객체 + 내보낼 스트림
		FileOutputStream fos = new FileOutputStream("C:/img/11111.png");
	
//		보조 스트림 준비 (하는 일 프로그램을 읽고,쓰는 성능을 향상 시켜준다)
		//보조 스트림은 탑승하는 계념으로 생각 하면 편하다
		BufferedInputStream bis = new BufferedInputStream(fis); //읽어드리는 속도를 향상 시킨다
		BufferedOutputStream bos = new BufferedOutputStream(fos); //내보내는 속도를 향상 시킨다
		
		long start = 0;//속도 측정 
		long end = 0;//속도 측정
		
//		2.읽어오기 ->쓰기
		int data;
		start = System.currentTimeMillis();
		while ((data = bis.read())!=-1) {//읽어올 값이 없으면 -1로 표시된다(read : 데이터를 읽는다)
			bos.write(data);//(write : 데를 빼낸다)
		}
		System.out.println("저장 완료");
		end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(end - start)+"ms");
//		3.자원 반남
		bis.close();
		bos.flush();
		bos.close();

	}

}
