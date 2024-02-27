// 34.

public class StmtDoWhile {

	public static void main(String[] args) {
		int cnt = 11;
		
		// 조건을 먼저 보고
		while (cnt<10) {
			cnt++;		//실행한다.
		}
		System.out.println("while cnt: "+cnt);
		
		cnt = 11;
		do {				// 일단 실행하고
			cnt++;	
		} while (cnt<10); 	// 조건을 봐서 반복 여부를 결정
		
		System.out.println("do while cnt: "+cnt);
		
		// 조건이 만족되지 못하는 상황으로 시작할때는 두 구문이 다르게 반응한다.

	}

}
