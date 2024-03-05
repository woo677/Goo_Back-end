package cho8.ex03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
	
	public String solution(int age) {
		
//나이를 알파벳으로 말하고 있다
//a는 0, b는 1, c는 2, ..., j는 9입니다. : 배열을 이용한다
		
//배열을 이용해 a,b,c..을 입력하고 그 배열안에 있는 배열 번호로 더한다
		
//예를 들어 23살은 cd, 51살은 fb로 표현합니다. :
		
//문제 푸는 법 : 23을 쪼개서 2,3을 만든다음 그에 맞는 알파벳을 넣어라
		
//나이 `age`가 매개변수로 주어질 때  나이를 return하도록
//solution 함수를 완성해주세요.
		
        String answer = "";
        String pa ="abcdefghij";
        StringBuilder builder = new StringBuilder();
        
		/*
		 * //1. 숫자를 문자열화 하여 끓고,숫자로 다시 변환하는 방법 String[] num =
		 * String.valueOf(age).split("");
		 * 
		 * System.out.println(Arrays.toString(num));
		 * 
		 * for (String n : num) { int idx= Integer.parseInt(n); char ch =
		 * pa.charAt(idx); } answer = builder.toString();
		 */
        
        //2.
        
        while (age>0) {
        	builder.append(pa.charAt(age%10));
        	age/=10;
		}
        
        answer = builder.reverse().toString();
        
        return answer;
    }
}
