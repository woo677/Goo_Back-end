
public class ForEach_향상된_for문 {

	public static void main(String[] args) {
			//포이치
		
		int[] score = {10,20,30,40,50};

		// 일반 for
		for (int i = 0; i < score.length; i++) {
			System.out.println("score "+i+" = "+score[i]);
			
		}
		
		System.out.println();
		
		//향산된 for
		for (int s : score) {//스코워에 있는 값을 i로 하나씩 빼준다
			System.out.println(s);
			
		}
	}

	
}
