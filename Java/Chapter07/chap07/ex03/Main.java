package chap07.ex03;

public class Main {

	public static void main(String[] args) {
		
		
		//1. 인터페이스도 다형성을 활용할 수 있다
		//클래스 다형성(상속받은 클래스가 부모 클래스 형태로 들어가는 것)
		//인터페이스 다향성(구현받은 클래스가 인터페이스 형태로 들어 가는 것)
		MouseEvent mouse;
		
		mouse = new Window();
		mouse.click(1);
		mouse = new Liunx();
		mouse.click(3);
		mouse = new Mac();
		mouse.click(3);
		
		
		//2. 인터페이스는 객체화 할 수 없다()
		//인터페이스 활용해 주는 클래스가 있어야 한다(인터페이스는 규격의 개념이기 때문이다)
//		MouseEvent m=new Mou MouseEvent();			

		
		mouse.wheel(1);
		MouseEvent.setDpi(200);
	}

}
