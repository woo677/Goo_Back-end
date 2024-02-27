package chap07.ex03;

public class Liunx implements MouseEvent {

	@Override
	public void click(int button) {
		System.out.println("Liunx"+button + "번 버튼 클릭");
	}

	@Override
	public void dvlclick(int button) {
		System.out.println("Liunx"+button + "번 버튼 클릭");

	}

	@Override
	public Double[] move() {
		
		return null;
	}

}
