package cho4.ex02;

import java.util.Arrays;

public class Mian {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] result = {};
		int[] num_list;
		
		num_list = new int[] {1,2,3,4,5};
		result = sol.solution(num_list);
		System.out.println("  "+Arrays.toString(result));
		
		num_list = new int[] {1,3,5,7};
		result = sol.solution(num_list);
		System.out.println("  "+Arrays.toString(result));

	}

}
