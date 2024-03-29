package ex07.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		String result = "";
		result = sol.solution("bus");
		System.out.println(result);
		
		result = sol.solution("nice to meet you");
		System.out.println(result);
		
		
	}
}
	
	class Solution {
		public String solution(String my_string) {
			String answer = "";
			
			Pattern p = null;
			Matcher m =null;
			
			p = Pattern.compile("[aeiou]");
			m=p.matcher(my_string);
			while (m.find()) {
				System.out.println(m.group());
			}
			
			answer = my_string.replaceAll("[aeiou]", "");
			
			return answer;
			
			/*
			 * 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 
			 * 문자열 my_string이 매개변수로 주어질 때 모음을 제거한
			 * 문자열을 return하도록 solution 함수를 완성해주세요.
			 */
		}
	}



