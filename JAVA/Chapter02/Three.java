
public class Three {

	public static void main(String[] args) {
		
		int score = 80;
		//char grade = score > 90 ? 'A' : 'B';
		// 90 보다 크면 A
		// 80 보다 크면 B
		// 아니면 C
		// condition ? val1 : val2 에서 val2 는 값 또는 다른 조건이 들어갈 수 있다.
		char grade = score > 90 ? 'A' : score > 80 ? 'B' : 'C';
		
		System.out.println(score+"점은 등급 : "+grade);

	}

}
