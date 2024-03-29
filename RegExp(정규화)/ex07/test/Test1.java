package ex07.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
	
	public static void main(String[] args) {
		
		/*- 11 개월 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음 밖에 할 수 없습니다.
		- 그리고 네 가지 발음을 조합해서 만들 수 있는 발음도 할 수 있습니다.
		- 그리고 연속해서 같은 발음을 하는 것을 어려워합니다.
		- Babbling 에 주워진 단어 중 몇 개를 발음 할 수 있을 까요?*/
		
		String[] babbling = {"aya", "yee", "u", "maa", "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		
		Pattern p = Pattern.compile("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))$");
		Matcher m = null;
		
		int cnt = 0;
		for (String str : babbling) {
			m = p.matcher(str);
			if (m.find()) {
				System.out.println(m.group());
				cnt++;
			}
			
		}
		System.out.println("cnt : "+cnt);
		
		
		
	}

}
