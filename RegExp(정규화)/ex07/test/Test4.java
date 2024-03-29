package ex07.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {

	public static void main(String[] args) {
		
		String[] numbers = {"01033334444","027778888"};
		/*4 : 면 5개 까지 확보된다
		 *01033 O
		 *10333 O
		 *03333 O
		 *33334 O
		 *33344 O
		 *33444 O
		 *34444 O
		 *4444 X
		*/
		
		//개인정보 보호를 위해서 마지막 4자리를 제외한 나머지는 * 처리 하세요
		//01033334444 -> *******4444
		//027778888 -> *****888
		
		for (String num : numbers) {
			Matcher m = Pattern.compile("\\d(?=\\d{4})").matcher(num);
			
			while (m.find()) {
				System.out.print(m.group());
			}
			System.out.println();
			
			String answer =  num.replaceAll(".(?=.{4})", "*");
			System.out.println(answer);
			
		}

	}

}
