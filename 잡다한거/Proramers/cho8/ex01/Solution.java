package cho8.ex01;

public class Solution {
	
	public String solution(String my_string) {
		
		String answer="";
		
		//1.StringBuffer 활용 (0.07ms~0.10ms)
		StringBuffer buffer = new StringBuffer(my_string);
		answer = buffer.reverse().toString();//이거는 StringBuffer 에서만 사용이 가능하다 
		
		//2.char[] 활용 (0.02ms~0.05ms)
		char[] result = new char[my_string.length()];
		
		for (int i = 0; i < my_string.length(); i++) {
			result[(my_string.length()-1)-i] = my_string.charAt(i);
			
		}
		answer = new String(result);
		
		return answer;
	}
}
