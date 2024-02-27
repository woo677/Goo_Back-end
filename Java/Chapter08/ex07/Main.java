package Chap08.ex07;

import java.text.NumberFormat;

public class Main {

	public static void main(String[] args) {
		
		
		String data1 = null;
		String data2 = "1234z";
		
		//multi catch : jdk 1.7 부터 지원 
		//여러 예외를 한 곳에서 처리 가능 
		//예외 별로 각기 다른 처리는 어렵다.
		try { //문제 발생 예상 되는 곳
			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			
		} catch (NumberFormatException | NumberFormat) {
			System.out.println();
		} finally {
			System.out.println(("data1: "+data1));
			System.out.println(("data2: "+data2));
			
		}
		
	}

}
