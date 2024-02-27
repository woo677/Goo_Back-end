package chap08.ex07;

public class Main_신버전_캐취 {

	public static void main(String[] args) {
		
		String data1 = null;
		String data2 = "1234z";
		
		//!!하자만 얘는 잘 쓰질 않는다!!
//				↓
		//multi catch : jdk 1.7부터 지원
		//여러 예외를 한 곳에서 처리 가능
		//예외 별로 각각 다른 처리는 어렵다
		//한곳에서 처리를 할수 있다
		try {//문제가 발생 예상 되는 곳
			int val1 = Integer.parseInt(data1);//숫자를 문자로
			int val2 = Integer.parseInt(data2);
		} catch (NumberFormatException | NullPointerException e) {//예외 발생시 처리 내용
			System.out.println("올바른 값이 입력 되어야 합니다");
		}finally {//무조건 실행 되어야 하는 곳
			System.out.println("data1 "+data1);
			System.out.println("data1 "+data2);
		}
	}

}
