package chap05.ex11;

import chap05.ex08.OverCalc;

public class Main {

	public static void main(String[] args) {

		// Info 는 같은 패키지 안에 있기 때문에 그냥 객체화 가능
		Info info = new Info();
		System.out.println(info.age);
		System.out.println(info.job);
		
		//chap02.ex08 에 있는 OverCalc 를 불러온다.
		OverCalc calc = new OverCalc(); // 패키지가 다르므로 import 문을 사용해야 함(그래서 자동완성을 사용)
		String result = calc.plus("public", "+");
		System.out.println(result);
		

	}

}
