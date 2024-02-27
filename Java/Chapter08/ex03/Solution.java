package Chap08.ex03;

import java.util.Iterator;

public class Solution {

	public String solution(int age) {
		String answer = "";
		String pa = "abcdefghij";
		StringBuilder builder = new StringBuilder();
		
		/*//1.숫자를 문자열화 하여 끊고, 숫자로 다시 변환하는 방법(0.13ms~0.17ms)
		String[]num = String.valueOf(age).split("");
		
		
		for (String n : num) {
			int idx = Integer.parseInt(n);
			builder.append(pa.charAt(idx));
		}
		*/
		
		//0.03ms ~ 0.05ms
		while(age>0) {
			builder.append(pa.charAt(age%10));
			age /= 10;
		}
		
		
		answer = builder.reverse().toString();
		
		return answer;
		
	}
	
	
}
