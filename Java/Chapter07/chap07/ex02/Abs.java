package chap07.ex02;

public abstract class Abs {
	
	//일반 메서드
	public void parent() {
		System.out.println("그냥 사용하거나 오버라이드 할 수 있는 일반 메서드");
	}
	
	/* 추상 메서드 : 반드시 만들어야만 하는 메서드를 정의(몸통이 있으면 안된다 내가 쓰는 것이 아니가 때문에)*/
	public abstract void must1();
	public abstract void must2();
}
