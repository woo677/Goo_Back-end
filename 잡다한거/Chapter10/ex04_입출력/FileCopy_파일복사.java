package chap10.ex04_입출력;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopy_파일복사 {

	public static void main(String[] args) throws Exception {
//		1.읽어올 위치 + 파일 객체
//		File sre = new File("C:/img/belem-tower-1.png");
//		2.내보낼 위치 + 파일 객체
//		File dst = new File("C:/img/belem-tower-8492812_1920.jpg");
//		
//		읽어올 빨대 준비(File 이 앞에 붙이면 파일객체가 내장 되었다) - 그러므로 파일객체 안만들어도 됨
		FileInputStream fis  =new FileInputStream("C:/img/2.mp4");/*(InputStream)*/
//		내보낼 빨대 준비
		FileOutputStream fos  =new FileOutputStream("C:/img/temp/2.mp4");
//		3.읽어보기 -> 쓰기(안전성이 훨씬 좋다. 하자만 속도가 느리다)
		/*int daat;
		int i=0;
		while ((daat = fis.read())!=-1) {
			fos.write(daat);
			i++;
			System.out.println("파일 복사중... "+i);
		}
		*/
		int i=0;
		byte[]arr = new byte[1024];
		while (fis.read(arr)!=-1) {//배열을 넣으면 얼마나 옮기는지 출력,이후 더이상 읽을게 없으면 -1 을 출력
			//읽은 데이터는 매개변수로 주워진 배열에 담긴다
			fos.write(arr);
			i++;
			System.out.println("파일 복사중... "+i);
			
		}
		
//		4.자원바납(flush,close)
		fis.close();//문을 닫는다
		fos.flush();//문을 닫기전 빨대 안에 있는 내용물을 불어서 다 빼내준다
		fos.close();//그리고 문을 닫는다
	}

}
