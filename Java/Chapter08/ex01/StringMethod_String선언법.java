package chap08.ex01;

public class StringMethod_String선언법 {

	public static void main(String[] args) {
		//문자열 만드는 방법
		String str1 = "asdfg";//리터럴 방식
		
		String str2 = new String("asdf");//생성자 오버로드
		
		char[] arr = {'a','b','c','d','e'};
		String str3 = new String(arr);

	}

}
