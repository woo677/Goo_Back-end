// 6. Method

public class Toaster_메서드호출 {

	public static void main(String[] args) {
		String dish = toaster("식빵");	// toaster 메소드를 호출
		System.out.println(dish);
	}
	
	static String toaster(String input) {
		System.out.println(input+"이 구워지고 있다.");
		return "구워진 "+input;
	}

}
