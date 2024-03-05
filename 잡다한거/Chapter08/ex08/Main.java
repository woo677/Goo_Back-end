package chap08.ex08;

public class Main {
//	JVM에게 전가 자바 실행파일
	public static void main(String[] args) 
	//		throws NumberFormatException 이러면 오류 나는 건 똑같다
	{
		
		
		try {
		//또는 내가 쳐리
		Sub sub = new Sub();
		sub.method1(); //1.main() ->method1() 호출
		
		}catch (Exception e) { //e :예의에 대한 모든 정보가 다 들어가 있다
			System.out.println("숫자만 입력 하세요");
			
			//어떤 예외가 발생했는 지 간단하게 볼수 있다
			System.out.println(e.toString());
		}

	}

}
 