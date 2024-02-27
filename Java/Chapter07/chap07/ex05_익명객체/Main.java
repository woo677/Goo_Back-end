package chap07.ex05_익명객체;

import chap07.ex03.MouseEvent;
import chap07.ex04.window;

public class Main {

	public static void main(String[] args) {
	
		//일반적인 객체화의 경우(다형성 활용)
		MouseEvent mouse = new window();
		
		//일반적으로 인터페이스를 활용 하기 위해서는 구현해줄 클래스가 필요 하다
		
		//익명객체 활용
		//인터페이스를 구현받을 클래스의 이름이 '익명'이다
		//그러므로 인터페이스를 구현받은 클래스는 이곳 외에 어디에서도 부를 수 없다
		MouseEvent evt= new MouseEvent() {
			
			@Override
			public Double[] move() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void dvlclick(int button) {
				System.out.println(button+"button");
				
			}
			
			@Override
			public void click(int button) {
				System.out.println(button+"button");
				
			}
		};
		evt.click(1);
		evt.dvlclick(2);
	}

}
