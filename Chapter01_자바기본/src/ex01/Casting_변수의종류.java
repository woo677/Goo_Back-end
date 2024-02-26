package ex01;

public class Casting_변수의종류 {

	public static void main(String[] args) {
		
//		변수선언, 변수 이름 지정 
		char charValue;
		int intvalue;
		long longvalue;
		float floatvalue;
		double doublevalue;
		
//		변수에 값 지정
		intvalue = 74;
		charValue = (char) intvalue;
		System.out.println(charValue);
		
		longvalue = 500;
		doublevalue=3.14;
		
//		강제(명시적) 형 변환
//		long -> int
		intvalue = (int) longvalue;
		
//		double -> float
		floatvalue = (float) doublevalue;
		
//		출력문
		System.out.println(intvalue);
		System.out.println(floatvalue);

	}

}
