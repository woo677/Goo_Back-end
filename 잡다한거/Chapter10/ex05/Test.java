package chap10.ex05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		
//		1.내보낼 파일 위치 설정
	
//		2.시스템에서 내용을 불러올Scanner 준비

//		3.파일로 내보낼 File Writer 준비
		
//		4.Scanner 로 읽어온 내용을 파일로 내보낸다
		
//		5.사용한 자원을 닫는다
		
		
//		1.스캐너 준비
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 내용 > ");
		
//		2.읽어서 가져오기
		String inp = scan.nextLine();
		System.out.println("당신이 입력한 값 : "+inp);
		
//		3. 저장할 위치+파일객체+내보낼 스트림
		FileWriter writer = new FileWriter("C:/img/temp/st.txt",true);

//		4.내보내기
		System.err.println("파일저장 완료");
		
//		5.자원 반납(flush,close)
		scan.close();
		writer.flush();
		writer.close();
	}

}
