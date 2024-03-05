package cho4.ex01;

public class Solution {

	public int solution(int[] dot) {
        int answer =0;
        
        int x = dot[0];
        int y = dot[1];
        
//        x>0 && y>0 좌표가 모두 양수이면 제1사분면에 속합니다.
        if (x>0 && y>0) {
			answer=1;
		}
//        x<0 && y>0 좌표가 양수이면 제2사분면에 속합니다.
        if (x<0 && y>0) {
			answer=2;
		}
//        x<0 && y<0 모두 음수이면 제3사분면에 속합니다.
        if (x<0 && y<0) {
			answer=3;
		}
//        x>0 && y<0 음수이면 제4사분면에 속합니다.
        if (x>0 && y<0) {
			answer=4;
		}
        
        
        return answer;
    }

}
