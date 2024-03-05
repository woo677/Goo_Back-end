package cho2.ex06;

public class Mian {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result = 0;
		//양꼬치 1인분에 12,000원, 음료수는 2,000원입니다.
		result = sol.solution(10,3);
		System.out.println("124000  "+result);
		result = sol.solution(64,6);
		System.out.println("760000   "+result);

	}

}
