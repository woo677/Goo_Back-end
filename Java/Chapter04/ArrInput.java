// 42.

public class ArrInput {

	public static void main(String[] args) {
		
		// 10개의 방 생성
		int[] scores = new int[10];
		
		System.out.println("크기: "+scores.length);
		

		scores[0] = 10; 	// 0번 방에 10
		scores[1] = 50; 	// 1번 방에 50
		scores[2] = 70; 	// 2번 방에 70
		scores[3] = 100; 	// 3번 방부터 끝까지 100
		scores[4] = 100;
		scores[5] = 100;
		scores[6] = 100;
		scores[7] = 100;
		scores[8] = 100;
		scores[9] = 100;
		
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		for (int i = 3; i < scores.length; i++) {
			System.out.println(i);
			scores[i] = 100;
		}
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		

	}

}
