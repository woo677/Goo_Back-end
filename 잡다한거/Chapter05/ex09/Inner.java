package chap05.ex09;

public class Inner {

	public static void main(String[] args) {
	st_msg("hello static method");//같은 static 영역의 메서드 끼리는 편하게 부르면 된다
	//하지만 여역이 다른 h_msg("hello method")는 부를 수 없다
	Inner inner = new Inner();
	lnner.h_msg("hello method");//영역이 다른것을 부를떄는 같은 클래스라 하더라도 다른클래스에 부를때 처럼
	}
	static void st_msg(String msg) {
		System.out.println("static member method : "+msg);
	}
	void h_msg(String msg) {
		System.out.println("member method : " +msg);
		Inner.st_msg("");//다른 영역이므로 
	}

}
