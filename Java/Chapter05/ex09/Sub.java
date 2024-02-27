package chap05.ex09;

public class Sub {
	
	// static은 원본 저장,
	// static이 없다면 복제 가능
	
	static int sFiled = 134;
	int field = 1;
	
	static int plus(int x, int y) {
		return x+y;
	}
	
	static int minus(int x, int y) {
		return x-y;
	}
	
	int multi(int x, int y) {
		return x*y;
	}

}
