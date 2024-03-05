package cho9.ex04;

import java.util.Arrays;

public class Solution {
	boolean solution(String s) {
        boolean answer = true;
        
        //딜히으로 시작하면 애초에 비교할 가지도 없다
       if (s.startsWith(")")) {
		return false;
	}
       //(가 있으면) 가 꼭 있어햐 한다
       int sum = 0;

       for (int i = 0; i  < s.length(); i++) {
		if(s.charAt(i) == '('){//'(' 일경우 값 증가
			sum++;
		}else {// ')' 일경우 값 감소
			if (sum>0) {
				sum--;
			}else {
				return false;
			}
		}
		
	}
       answer = sum ==0;//0이라는 것은 열기와 닫기가 한 쌍 이라는 것
        return answer;
    }
}

