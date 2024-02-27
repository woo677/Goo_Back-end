// 14. 3항 연산자

public class Three {

	public static void main(String[] args) {
		
		int score = 90;
		//char grade = score > 90 ? 'A':'B';
		
		// 90 보다 크면 A
		// 80 보다 크면 B
		// 아니면 C
		
		/*
		char grade = score >= 80? 'B':'C';
		if (grade == 'B') {
			grade = score >= 90 ? 'A':'B';
		}
		*/
		
		char grade = score >= 90 ? 'A' : score >= 80 ? 'b':'C';
		
		
		System.out.println(score+"점은 등급: "+grade);

	}

}
