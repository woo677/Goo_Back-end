package chap08.ex05;

public class Main {

	public static void main(String[] args) {
		String data1 = "12345";
		String data2 = "1234z";
		
//		int val1 = Integer.parseInt(data1);//숫자를 문자로
//		int val2 = Integer.parseInt(data2);//파이널리(finally)
//		
//		System.out.println("data1 "+data1);
//		System.out.println("data1 "+data2);
		
		//예외 처리
		try {//문제가 발생 예상 되는 곳
			int val1 = Integer.parseInt(data1);//숫자를 문자로
			int val2 = Integer.parseInt(data2);
		} catch (NumberFormatException e) {//예외 발생시 처리 내용
			System.out.println("숫자만 입력 되어야 합니다");
		}finally {//무조건 실행 되어야 하는 곳
			System.out.println("data1 "+data1);
			System.out.println("data1 "+data2);
		}
		
	}

}
