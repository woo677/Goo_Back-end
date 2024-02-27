package chap10.ex05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		
		// 1. 스캐너 준비
		Scanner scan = new Scanner(System.in);		
		System.out.print("입력 내용> ");
		// 2. 읽어서 가져오기
		String inputStr = scan.nextLine();
		System.out.println("당신이 입력한 값 : "+inputStr);
		
		// 3. 저장할 위치+파일객체+내보낼 스트림
		FileWriter writer = new FileWriter("C:/img/temp/sample.txt", true);
		// 4. 내보내기
		writer.write(inputStr);
		System.out.println("파일저장 완료");
				
		// 5. 자원 반납(flush, close)
		scan.close();
		writer.flush();
		writer.close();


	}

}
