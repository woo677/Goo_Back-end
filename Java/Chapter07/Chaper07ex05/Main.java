package Chaper07ex05;

import chap07ex03.MouseEvent;
import chap07ex03.Window;

public class Main {

	public static void main(String[] args) {
		
		//일반적인 객체화의 경우(다형성 활용)
		MouseEvent mouse = new Window();
		//일반적으로 인터페이스를 활용 하기 위해서는 구현해줄 클래스가 필요하다. 
		
		//익명객체 활용 
		//인터페이스를 구현받을 클래스의 이름이 '익명'이다. 
		//그러므로 인터페이스를 구현받은 클래스는 이곳 외에 어디에서도 부를 수 없다. (클래스가 없기때문에 호출이 불가능)
		MouseEvent evt = new MouseEvent() {
			
		}
		
		   	evt.click(1);
		   	evt.dblclick(2);
	}

}
