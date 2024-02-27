// 2. 변수 선언 위치

public class Scope_변수선언위치 {	// class
	
	String str = "some text";	// class 안에서 사용 가능

	public static void main(String[] args) {	// method, function
		
		int num = 123; 	// method 안에서 사용 가능
		
		for (int i = 0; i < 5; i++) { 	// 문장(statement)
			int sum = num + i; 	// statement 안에서만 사용 가능
			System.out.println(sum);
		}
		//System.out.println(sum);		// sum은 for 문장을 넘어갈 수 없으므로 에러

	}

}
