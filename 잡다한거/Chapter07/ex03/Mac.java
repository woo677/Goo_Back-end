package chap07.ex03;

public class Mac implements MouseEvent {

	@Override
	public void click(int button) {
		System.out.println("Mac"+ button + "번 버튼 클릭");

	}

	@Override
	public void dvlclick(int button) {
		System.out.println("Mac"+ button + "번 버튼 클릭");

	}

	@Override
	public Double[] move() {
		// TODO Auto-generated method stub
		return null;
	}

}
