package chap10.ex07;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		// 이름, 급여, 승진 여부를 직접 입력 받아 저장해 보기
		// input_sample.dat 로 저장
		
		// 1. 스캐너 준비
		Scanner scan = new Scanner(System.in);
		
		// 2. 스캐너 입력 받기
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("급여 : ");
		int salary = scan.nextInt();
		System.out.print("승진여부 : ");
		boolean pro = scan.nextBoolean();		
		System.out.println(name+" / "+salary+" / "+pro);

		// 3. 내보낼 위치 + 파일객체 + 주스트림
		FileOutputStream fos = new FileOutputStream("C:/img/temp/input_sample.dat");
		// 4. 자바고유 데이터 타입으로 내보내기(보조스트림)
		DataOutputStream dos = new DataOutputStream(fos);
		// 5. 받은 내용 쓰기
		dos.writeUTF(name);
		dos.writeInt(salary);
		dos.writeBoolean(pro);		
		// 6. 종료
		scan.close();
		dos.flush();
		dos.close();
		
		// 읽기?
		

	}

}
