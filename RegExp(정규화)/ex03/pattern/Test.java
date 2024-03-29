package ex03.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		
		
		// 다음중 문자가 섞인 값의 인뎃스를 찾으시요
		String[]  test1 = {"123","1d2","456","ddd4","123.456","3@2"};
		for (int i = 0; i < test1.length; i++) {
			Pattern p= Pattern.compile("[^0-9]");
			Matcher m = p.matcher(test1[i]);
			if (m.find()) {
				System.out.println(i+" : "+test1[i]+"   "+m.group());
			}
		}
		
		
		System.out.println();
		
		//다음중 특수문자가 사용된 값의 인덱스를 찾으시요
		String[]  test2 = {"tester","test!!","master.id","main_id."};
		
		for (int i = 0; i < test2.length; i++) {
			Matcher m = Pattern.compile("[^\\w]").matcher(test2[i]);
			
			if (m.find()) {
				System.out.println(i+" : "+test2[i]+"   "+m.group());
			}
		}
	}

}
