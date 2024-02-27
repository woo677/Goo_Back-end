package Chaper07ex04;

import Chaper07ex03.MouseEvent;

public class Window implements MouseEvent, KeyEvent {

	/*KeyEvent의 추상 메서드 구현*/
	@Override
	public void keyDown(int key) {}
		


	@Override
	public void keyUp(int key) {}
		


	/*MouseEvent 의 추상 메서드 구현*/
	@Override
	public void click(int button) {}
		

	
	@Override
	public void dblclick(int button) {}
		

	
	@Override
	public Double[] move() {
	
		return null;
	}

}
