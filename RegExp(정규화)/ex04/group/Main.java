package ex04.group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {


		Pattern p = null;
		
		System.out.println("(x) : x를 그룹으로 처리 함");
		p = Pattern.compile("(6CD)");
		print("(6CD)",p.matcher("ab6CDE433fgh22ijKlmn1o"),1);
		System.out.println();

		System.out.println("(x)(y) : x와 y는 다른 그룹으로 처리 함");
		p = Pattern.compile("(6CD)|(443f)"); //6CD 와 443f 를 둘다 찾겠다
		print("(6CD)|(443f)",p.matcher("ab6CDE443fgh22ijKlmn1o"),1);
		// 어느 구룹에서 찾아낸건지 알고 싶을 경우....
		print("(6CD)|(443f)",p.matcher("ab6CDE443fgh22ijKlmn1o"),2);
		System.out.println();
		
		// 공백문자는 시작시 공백이 없어도 첫 문자면 가져와 준다.(단어의 시작과 끝을찾아내는데 유용)
		// 첫 시작 문자 두글자를 동시에 가져올 경우
		 p = Pattern.compile("\\b([\\w])([\\w])"); // \\b : 앞에 공백
		 print("\\b([\\w])([\\w])",p.matcher("my team has groups"),2);
		 
		 
		 //(?!y)이런 애만 독입적으로 움직이고 싶은때 그룹을 쓴다
		 // ?!: 뒤에 오면 안된다
		 System.out.println("x(?!y) : x 다음에 y 가 오지 않는다");
		 // 숫자 다음에 문자 오지 않도록
		 p = Pattern.compile("\\d(?![^0-9])");
		 //?! : 뒤에 있는 패턴을 포함하지 않아야 한다.(부정형 전방 탐색)
		 //1234
		 System.out.println("1234 : "+p.matcher("1234").find());
		 
		 //1f
		 System.out.println("1f : "+p.matcher("1f").find());
		 
		 //1F
		 System.out.println("1F : "+p.matcher("1F").find());
		 
		 
		 

	}
	
	public static void print(String msg,Matcher m,int cnt) {
		System.out.print(msg+ " : ");
		while (m.find()) {
			if(cnt>1) {
				System.out.print(m.group(1)+" , "+m.group(2)+" / ");
			}else {				
				System.out.print(m.group()+" ");
			}
		}
		System.out.println();
	}

}
