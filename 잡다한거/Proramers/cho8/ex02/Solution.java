package cho8.ex02;

public class Solution {
	
	public String solution(String my_string,int n) {
		
		//이번 문제 :문자열 my_string과 정수 n이 매개변수로 주어질 때,
		//my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 
		//return 하도록 solution 함수를 완성해보세요.
		
		String answer ="";
		
		//각각의 문자를 뽑아내기
		String[] arr = my_string.split("");
		StringBuffer buffer = new StringBuffer() ;
		
		//뽑아낸 문자를 n번 반복
		for(String str:arr) {
			//반복된 문자를 amwer 에 합치기
			buffer.append(str.repeat(n));
		}
		answer = buffer.toString();
		
		//반복된 문자를 answer에 합치기
		
		return answer;
	}
}
