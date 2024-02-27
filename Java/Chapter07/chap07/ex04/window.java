package chap07.ex04;

import chap07.ex03.MouseEvent;

public class window implements MouseEvent, KeyEvent {
	
	
	//keyEvent의 추상 메서드 구현
	@Override
	public void keyDown(int key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyUp(int key) {
		// TODO Auto-generated method stub

	}
	
	
	//MouseEvent의 추상 메서드 구현
	@Override
	public void click(int button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dvlclick(int button) {
		// TODO Auto-generated method stub

	}

	@Override
	public Double[] move() {
		// TODO Auto-generated method stub
		return null;
	}

}
