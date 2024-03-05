package cho9.ex03;

import java.util.Arrays;

public class Solution {
	public int solution(int []a, int []b)
    {
        int answer = 0;

        //오름차순(Sort), 내림차순(reaverseOrder)
        Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i = 0; i < a.length; i++) {
//			System.out.println(i+"<>" +((a.length)-i));
        	answer += a[i]* b[(a.length-1)-i];
		}
        

        return answer;
    }
}
