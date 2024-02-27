package default_packege;

public class Stmt_While {

	public static void main(String[] args) {
		
		int i=1;
		while (true) {
			System.out.println(i);
			i++;
			if (i==100) {
				break;//멈출수 있는 코드로 변함
			}
			
		}
		//unreahable code(언리치어드 코드) : 현재 이 상황 대로라면 여기 까지 닿지 않는다
		//해결방법 1 : 에러코드를 지워준다
		//해경방법 2 : while 문이 멈출 수 있는 방법을 마련해 준다
		int cup=1;
		System.out.println(cup);

	}

}
