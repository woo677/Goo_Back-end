package ex01;

public class Scope_메서드의사용범위 {

//	변수는 선언된 곳 보다 바깥쪽 영역에서는 사용 불가능 하다.
	
	public class Scope { // class
		
		String str = "some text"; // class 안에서 사용 가능

		public static void main(String[] args) { // method, function
			
			int num = 123; // method 안에서 사용 가능
			
			for (int i = 0; i < 5; i++) { // 문장(statement)
				int sum = num + i; // statement 안에서만 사용 가능
				System.out.println(sum);
			}
			//System.out.println(sum); // sum 은 for 문장을 넘어갈 수 없으므로 에러
		}

	}

}
