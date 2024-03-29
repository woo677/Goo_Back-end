package ex02.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {


		Pattern p = null;
		Matcher m = null;
		boolean result;
		
		//^x : x로 시작하는... (문자열의 시작)
		p = Pattern.compile("^x");
		m = p.matcher("xlist");
		result = m.find();
		System.out.println("^x");
		System.out.println("xlist : "+result);
		
		//메서드 체이닝
		System.out.println("listx : "+p.matcher("listx").find());
		System.out.println("myxlist : "+p.matcher("myxlist").find());
		System.out.println();
		
		
		//x$ : x로 끝나는... (문자열 종료)
		p =Pattern.compile("x$");
		System.out.println("x$");
		System.out.println("listx : "+p.matcher("listx").find());
		System.out.println("myxlist : "+p.matcher("myxlist").find());
		System.out.println();
		
		//이 내용을 찾고 싶은데 이걸로 변영 될수도 있고,이걸로 변영 될수도 있다
		System.out.println("x* : x가 있을수도 있지만 없을수도 있고 반복될수도 있다");
		p =Pattern.compile("x*");
		System.out.println("y* : "+p.matcher("y").find());
		System.out.println("x* : "+p.matcher("x").find());
		System.out.println("xxx* : "+p.matcher("xxx").find());
		System.out.println("myxlist* : "+p.matcher("myxlist").find());
		System.out.println();
		
		
		
		System.out.println("x? : x가 있을수도 있지만 없을수도 있다");
		p =Pattern.compile("x?y"); //x는 있을수도 있고 없을수도 있지만 y는 있어야 한다
		System.out.println("xy : "+p.matcher("xy").find());
		System.out.println("y : "+p.matcher("y").find());
		System.out.println("x : "+p.matcher("xxx").find());
		System.out.println();
		
		
		System.out.println("x|y : x 또는 y 가 존재한다 (한가지만 존제 해야함)");
		p =Pattern.compile("two|three"); //x는 있을수도 있고 없을수도 있지만 y는 있어야 한다
		m =p.matcher("two or three");
		while (m.find()) {
			//index 값을 이용해서 substring 등에 활용 할 수 있다
			System.out.println(m.group()+" : "+m.start()+" ~ "+m.end());
		}
		System.out.println();

		
		System.out.println("x.y : x와 y 사이에 임의의 한글자가 올 수 있다(한글자만 찾음)");
		p =Pattern.compile("x.y"); //x는 있을수도 있고 없을수도 있지만 y는 있어야 한다
		System.out.println("xzy : "+p.matcher("xzy").find());
		System.out.println("x0y : "+p.matcher("x0y").find());
		System.out.println("xaay : "+p.matcher("xaay").find());
		System.out.println("xy : "+p.matcher("x").find());
		System.out.println();
		
		
	}

}
