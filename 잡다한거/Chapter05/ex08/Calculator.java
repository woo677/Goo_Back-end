package chap05.ex08;

public class Calculator {
	
		public int name;
		public float goal;
		String str;
		long lo;
		double dou;

	//두 수 또는 문자를 더하는 메서드 만들기
	// int float String long double
	
		public int plusli(int number,int number2) {
			return number+=number;
		}
		
		public int pluslf(int number,float float2) {
			return number+=float2;
		}
		
		public int plusls(int number,String String2) {
			return (String)number+=String2;
		}
		
}
