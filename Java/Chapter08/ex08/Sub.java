package Chap08.ex08;

public class Sub {

	void method1() throws NumberFormatException{
		method2(); //2. method1() -> method1() 호출
	}
	
	//method1() 에게 예외 처리를 전가 
	void method2()throws NumberFormatException{
		//NumberFormatException
		Integer.parseInt("a1234");
	}
}
