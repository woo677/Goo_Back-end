package chap05.ex08;

public class Calculator {
	
	// 멤버 필드는 굳이 사용할 필요 없음.
	// 두 수 또는 문자를 더하는 메서드 만들기
	// double과 long은 제외
	// char+char, char+숫자는 안됨.
	
	int x = 0;
	int y = 0;
	String str1, str2;
	char ch1, ch2;
	float f1 = 0, f2= 0, f3=0;
	
	int calculator1 (int x, int y) {
		this.x= x;
		this.y= y;
		return x+y;
	}
	int calculator2 (int x, float f1) {
		this.x= x;
		this.y= (int)f1;
		return x+y;
	}
	String calculator3 (String str1, String str2) {
		this.str1= str1;
		this.str2= str2;
		return str1+str2;
	}
	String calculator4 (String str1, int x) {
		this.str1= str1;
		this.x= x;
		return str1+x;
	}
	String calculator5 (String str1, char ch1) {
		this.str1= str1;
		this.ch1= ch1;
		return str1+ch1;
	}
	
	String calculator6 (String str1, float f) {
		this.str1= str1;
		this.f1= f;
		return str1+f;
	}
	
	float calculator7 (float f1, float f2) {
		this.f1= f1;
		this.f2= f2;
		return f1+f2;
	}
	float calculator8 (float f1, int x) {
		this.f1= f1;
		this.f3= (float)x;
		return f1+f3;
	}

	

}
