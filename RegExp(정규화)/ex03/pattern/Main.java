package ex03.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
		public static void main(String[] args) {
			
			Pattern p =null;
			
			//[xy] : x|y와 같음 (or)
			p = Pattern.compile("[to]");
			print("[to] t-world", p.matcher("t-world"));
			
			
			//[^xy] : x와 y를 제외하고
			p =Pattern.compile("[^cd]"); //조건 주입 c,d를 제외하고
			print("[^cd] abcdegg",p.matcher("abcdegg"));
			
			
			//[a-z] : a부터 z까지
			p = Pattern.compile("[a-z]");
			//print 얜 걍 출력문임
			print("[a-z] 123abc4456",p.matcher("123abc4456"));
			

			//[0-9] : 0부터 9까지 (숫자가 아니라 문자로 인식한다 그래서 11,23 같은 것도 잡는다)
			p = Pattern.compile("[0-9]");
			//print 얜 걍 출력문임
			print("[0-9] 123abc4456",p.matcher("123abc4456"));
			
			
			//특수 표현 
			// \d  :  숫자[0-9] 대신 사용 (\ : 이스케이프에 특수 능력을 없에)		
			p = Pattern.compile("[\\d]");
			//print 얜 걍 출력문임
			print("[\\d] 123abc4456",p.matcher("123abc4456"));
			
		
			
			// \ w : 아파벳, 숫자, _ 중 한문지 를 찾음
			p = Pattern.compile("[\\w]");
			//print 얜 걍 출력문임
			print("[\\w] zer0-box_mail@naver.com",p.matcher("zer0-box_mail@naver.com")); // - . @ 는 가져오지 않는다
			
			
			
			
			// \b : 문자와 공백 사이 문자
			// 패턴뒤에 a-z 까지의 문자가 이니면 인정해 준다(, . 등..)
			// 가져올때 공백은 가져오지 않는다
			p = Pattern.compile("[s]\\b");  // s라는 페턴 뒤에 공백이 있으면 가져온다
			print("[s] \\b words characters, styles. lists!",p.matcher(" words characters, styles. lists!"));
			
			
			//  \s : 공백 - 공백뒤에 뭐가 붙으면 안된다
			// 가져올때 공백도  포함해서 가져온다
			p = Pattern.compile("[s]\\s");  // s라는 페턴 뒤에 공백이 있으면 가져온다
			print("[s] \\s words characters, styles. lists!",p.matcher(" words characters, styles. lists!"));

			
			
		}
		
	
	public static void print(String target,Matcher m) {
		System.out.print(target+" : ");
		while (m.find()) {
			System.out.print(m.group()+" ");
		}
		System.out.println();
	}
}
