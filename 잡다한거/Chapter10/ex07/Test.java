package chap10.ex07;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		// 이름,급여,승진 여부를 직접 입력 받아 저장해 보기
		//input_sample.dat 로 저장
		
		//1.스캐너 준비
		Scanner scan = new Scanner(System.in);
		
		//2.스태너 입력 받기
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		System.out.println("급여 : ");
		int salay = scan.nextInt();
		
		System.out.println("승진여부 : ");
		boolean pro = scan.nextBoolean();
		System.out.println(name+salay+pro);
		
		//3. 내보낼 위치 + 파일객체 + 주스트림
		FileOutputStream fos = new FileOutputStream("C:/img/temp/input_sample.dat") ;
		
		//4.자바 고유데이터 전환
		DataOutputStream dos = new DataOutputStream(fos);
		
		//5.받은 내용 쓰기
		dos.writeUTF(name);
		dos.writeInt(salay);
		dos.writeBoolean(pro);
		
		//6.종료
		scan.close();
		
		
		
		
		
		
		
		/*  내가 쓴거
//		Scanner로 이름,급여,승진 여부를 입력한다
		FileOutputStream fos = new FileOutputStream("C:/img/temp/input_sample.dat");
		
		//자바 고유데이터 전환
		DataOutputStream doa = new DataOutputStream(fos);
		
		//입력 받을 값
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름");
		String name = sc.nextLine();
		System.out.println(name);
		
		System.out.print("직급");
		String st1 = sc.nextLine();
		System.out.println(st1);
		
		System.out.print("승진");
		boolean bo  = sc.nextBoolean();
		System.out.println(bo);
		
//		입력받은 데이터를 input_sample.dat로 저장한다
		
		FileWriter wr = new FileWriter("C:/img/temp/input_sample.dat",true);
		
//		fwi.write();
		
//		자원 반납
		sc.close();
		wr.flush();
		wr.close();	
		*/	

	}

}
