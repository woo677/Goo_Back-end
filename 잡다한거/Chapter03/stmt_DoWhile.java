package default_packege;

public class stmt_DoWhile {

	public static void main(String[] args) {
		
		int cnt =11;
		
		while (cnt<10) {//조건을 보고 실핼
			cnt++;//실행한다
		}
		System.out.println(cnt);
		
		cnt =11;
		do {
			cnt++;//일단 실행 하고
		} while (cnt<10);//조건을 본다(반복 여부를 결정)
		System.out.println(cnt);

		//조건이 만족되지 못하는 사황으로 시작할때는 두 구문이 다르게 반응 한다
	}

}
