package cho4.ex02;

public class Solution {

	public int[] solution(int[] num_list) {
        int[] answer = {0,0};
        
        //1. 들어온 배열의 값이 홀수인지 짝수인지 구분
        for (int n: num_list) { //배열에 결과값을 뽑아 올려면 필요함
//			System.out.println(n);
        	if (n%2==0) { //짝수이면 answer[0]의 값의 1증가
//				answer[0] +=1;
        		answer[0] ++;
			} else { // 아니면 answer[1]의 값의 1증가
//				answer[0] +=1;
				answer[1] ++;
			}
		}
        
        
        return answer;
    }

}
