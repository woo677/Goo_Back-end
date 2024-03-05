       
public class OutArr_배열출력 {

	public static void main(String[] args) {
		
		int[] scores = {95,75,84,35,88};
		
		//0번방 호출
		System.out.println("0번 방 : "+scores[0]);
		
		//3번방 호출
		System.out.println("3번 방 : "+scores[3]);
				
		//4번방 호출
		System.out.println("4번 방 : "+scores[4]);
		
		System.out.println();
		
		
		//모든 방의 값을 출력 해 보자
		for (int i = 0; i < scores.length; i++) {
			System.out.println("scores["+i+"] "+scores[i]);
		}
	}

}
