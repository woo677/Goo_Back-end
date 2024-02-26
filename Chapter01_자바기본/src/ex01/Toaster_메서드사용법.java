package ex01;

public class Toaster_메서드사용법 {

	public static void main(String[] args) {
		
//		toaster에 식빵이라는 변수를 보낸다
		String dish = toaster("식빵");
		System.out.println(dish);
	}
//		메서드 선언
	static String toaster(String input) {
		System.out.println(input+"이 구어지고 있다");
		return "구워진"+input;
	}
	
	
	
	
	
	
	
}
