package chap08.ex08;

public class Sub {

	//main()에게 전가
	void method1() throws NumberFormatException{
		method2();//1.method1() ->method2() 호출
	}
	
	//method1() 에게 예외 처리를 전가
	void method2() throws NumberFormatException{//던지는 방법 (쓰러우스)
		//NumberFormatException
		Integer.parseInt("a1234");
	}
}
