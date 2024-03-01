package chap10.ex01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// system 으로 부터 받아온 것을 Scanner 로 받겠다.
		Scanner scan = new Scanner(System.in);
		
		// system 으로 부터 밖으로 내보낸다.
		// print 할 내용을(ln 은 줄 바꿈을 의미)
		System.out.print("문자열 입력> ");
		// 입력 받은 문자열 저장
		String inputStr = scan.nextLine();
		System.out.println(inputStr);
		System.out.println(); // 아무 의미 없는 공백 출력 후 줄바꿈
		
		// 정수(int)
		System.out.print("정수 입력> ");
		int inputInt = scan.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		// 실수(double)
		System.out.print("실수 입력> ");
		double doubleInput = scan.nextDouble();
		System.out.println(doubleInput);
		System.out.println();
		

	}

}
