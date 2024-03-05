package cho4.ex03;

import java.util.Arrays;

public class Mian {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] result = {};
		
		result = sol.solution(5500);
		System.out.println("  "+Arrays.toString(result));
		
		result = sol.solution(15000);
		System.out.println("  "+Arrays.toString(result));

	}

}
