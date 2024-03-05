package cho3.ex02;

public class Solution {

	public int solution(int n) {
        int answer = 0;
        for (int i = 0; i <= n; i++) {
			if (i%2==0) {
				answer +=i;
				System.out.println(i);
			}
		}
        return answer;
    }
}
