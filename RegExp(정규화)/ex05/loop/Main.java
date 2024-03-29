package ex05.loop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		Pattern p = null;
		
		System.out.println("x+ : x가 한번 이상 반복 될 때");
		p = Pattern.compile("x+")		;
		System.out.println("x+ : "+p.matcher("x").find());
		System.out.println("xxx+ : "+p.matcher("xxx").find());
		System.out.println("myxilst+ : "+p.matcher("myxilst").find());
		
		
		System.out.println("x{n} : x 가 n번 반복");
		p = Pattern.compile("[0-9]{3}"); //3자리 이상이면 3자리 까지 끊어서 가져온다
		print("1 23 456 7890",p.matcher("1 23 456 7890"));
		
		// 딱 3자리 숫자를 가져오려면?
		// 왜 몇자리 숫자인지 구분하는가 
		p = Pattern.compile("\\b\\d{3}\\b"); //3자리 이상이면 3자리 까지 끊어서 가져온다
		print("1 23 456 7890",p.matcher("1 23 456 7890"));
		
		System.out.println("x{n,m} : x가 최소 n번, 최대 m번 반복");
		p = Pattern.compile("\\b[0-9]{3,4}\\b");
		print("1 23 456 7890 55555",p.matcher("1 23 456 7890 55555"));
		System.out.println();
		
		
		//최소 이만큼만 반복한다 (최대는 숫자는 상관 없음)
		System.out.println("x{n,} : x가 최소 n번 반복");
		p = Pattern.compile("[0-9]{3,}");
		print("1 23 456 7890 55555",p.matcher("1 23 456 7890 55555"));
		System.out.println();
		
		// 같은 문자가 연속으로 반복 될 경우(2글자 부터)
		// 비번(111111) 이러면 오류
		System.out.println("([0-9])\\1 : 같은 숫자가 1번 이상 반복되면");
		 p = Pattern.compile("([0-9a-z])\\1");
		 print("두글자 이상",p.matcher("1bbccccdddd01223334444"));
		 System.out.println();
		
		
		 
		 System.out.println("([\\w])\\1{3,} : 같은 문자가 3번 이상 반복되면");
		 p = Pattern.compile("([\\w])\\1{3,}");
		 print("두글자 이상",p.matcher("1bbccccdddd01223334444"));
		 System.out.println();
		 
		 
		 
		 
		 String[] phones = {
			"032-234-5678",
			"02-234-5678",
			"0-234-5678",
			"010-1234-5678",
			"010-1234-567"
		 };
		 
		 p = Pattern.compile("^\\d{2,3}-\\d{3,4}-\\d{4}$");
		 
		 for (int i = 0; i < phones.length; i++) {
			 System.out.println(phones[i]+" 은 정상적인 번호 인가 ? "+p.matcher(phones[i]).find());
		}
		 
		 
		 String[] email = {
				 "qwer323@navar.com"
				 ,"dfjieijd1@gmail.com"
				 ,"dfjiwsd1@gmail.com"
				 ,"dfji2343@gmail.com"
				 ,"dfsd21@gmail.com"
				 ,"dfsd21@gmaSS.com"
				 ,"asder323@navar.com"
				 ,"dfsd21gmail.com"
				 ,"dfsd21@gmailcom"
		 };
		 
		 p =Pattern.compile("^[a-zA-z\\d]@[a-z]\\.[a-z]$");
		 
		 for (int i = 0; i < email.length; i++) {
			System.out.println(email[i]+"이 이메일 주소는 정상인가 ? "+p.matcher(email[i]).find() );
		}
		 
		
		
		
		
		
		
	}
	
	public static void print(String target,Matcher m) {
		System.out.print(target+" : ");
		while (m.find()) {
			System.out.print(m.group()+" ");
		}
		System.out.println();
	}

}
