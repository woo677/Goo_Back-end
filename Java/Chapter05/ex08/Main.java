// 56.

package chap05.ex08;

public class Main {

	public static void main(String[] args) {
		
		Calculator cal= new Calculator();
		
		int result1= cal.calculator1(2, 0);
		System.out.println("(정수+정수= int) "+result1);
		int result2= cal.calculator2(2, 1.4f);
		System.out.println("(정수+(정수)실수= int) "+result2);
		String result3= cal.calculator3("dodo", "hye");
		System.out.println("(문자열+문자열= String) "+result3);
		String result4= cal.calculator4("dodo", 0);
		System.out.println("(문자열+정수= String) "+result4);
		String result5= cal.calculator5("dodo", 'H');
		System.out.println("(문자열+문자= String) "+result5);
		String result6= cal.calculator6("dodo", 1.67f);
		System.out.println("(문자열+실수= String) "+result6);
		float result7= cal.calculator7(0, 0.235462f);
		System.out.println("(실수+실수= float) "+result7);
		float result8= cal.calculator8(2.33f, 3);
		System.out.println("(실수+(실수)정수= float) "+result8);
		
		
		
		// 오버로드는 하나의 이름으로 여러 매개변수를 줄 수 있다.
		// 사용자 입장에서는 매개변수를 넣으면 해당 메서드로 자동 연결된다.
		// 만약 오버로드가 없었다면 해당 매개변수를 사용하는 메서드를 찾아야 한다.
		
		OverCalc calc = new OverCalc();
		
		String result= calc.plus("A", 1);
		System.out.println(result);

	}

}
