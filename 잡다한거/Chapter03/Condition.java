package default_packege;

public class Condition {

	public static void main(String[] args) {
		
		if (true) {//참일경우만 실행
			System.out.println("조건이 참 일경우만 실행 한다");
		}
		
		if(false) { //dead code 경고
			System.out.println("무조건 실행 되지 않는다");
		}
		
		boolean a =true;
		boolean b =false;
		
		if (a) {
			System.out.println("a는 true 이므로 실행 된다");
		}
		
		if (!b) { //!반전
			System.out.println("b는 false 이므로 실행되지 않는다");
		}

	}

}
