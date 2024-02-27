// 60.

package chap05.ex11;

import chap05.ex08.OverCalc;

public class Main {

	public static void main(String[] args) {
		// Info는 같은 패키지 안에 있기 때문에 그냥 객체화 가능
		Info info = new Info();
		System.out.println(info.age);
		System.out.println(info.job);
		
		// chap05.ex08에 있는 OverCalc를 불러온다.
		OverCalc calc = new OverCalc();	// 패키지가 다르므로 import문을 사용해야 함(자동완성으로 하면 편함. 오타도 줄이고)
		String result = calc.plus("public", "+");
		System.out.println(result);

	}

}
