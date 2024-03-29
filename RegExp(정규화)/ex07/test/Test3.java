package ex07.test;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
	
	public static void main(String[] args) {
		
		int result = 0;
		result = solution("0123456789");
		System.out.println(result);
		
		result = solution("aAb1B2cC34oOp");
		System.out.println(result);
		
		result = solution("1a2b3c4d123");
		System.out.println(result);
		
		
	}
	
		public static  int solution(String my_string) {
			int answer =0;
			
			
			//1. 정규 표현식 + replaceAll
			/*
			 * String[] strNum = my_string.replaceAll("[a-zA-Z]","").split("");
			 * 
			 * for (String str : strNum) { 
			 * 		answer += Integer.parseInt(str); 
			 * }
			 */
			
			Matcher m =  Pattern.compile("[0-9]").matcher(my_string);
			
			while (m.find()) {
				answer += Integer.parseInt(m.group());
			}
			
			return answer;
			
			/*
			 *문자열 my_string이 매개변수로 주어집니다. 
			 *my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
			 */
		}
	}



