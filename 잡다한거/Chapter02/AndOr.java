
public class AndOr {

	public static void main(String[] args) {
		
		int val=6;
		
		if (val>1 && val<7) { //둘다 맞아야 된다
			System.out.println(val+"은 1보다 크고 7보다 작다");
		}
		
		if (val%2==0 || val%3==0) { // 둘중 1개만 맞아도 된다
			System.out.println("2또는 3의 배수");
		}

	}

}
