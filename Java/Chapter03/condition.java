// 30. 

public class condition {

	public static void main(String[] args) {
		if (true) {
			System.out.println("조건이 참 일 경우만 실행한다.");
		}
		
		if(false) {
			System.out.println("무조건 실행되지 않는다.");
		}
		
		boolean a = true;
		boolean b = false;
		
		if (a) {
			System.out.println("a 는 true 이므로 실행된다.");
		}
		if (!b) {
			System.out.println("b 는 false 이므로 실행되지 않지만, !b 는 실행된다.");
		}

	}

}
