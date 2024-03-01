package chap07.ex03;

public class Mac implements MouseEvent {

	@Override
	public void click(int button) {
		System.out.println(button+" 버튼 클릭");
	}

	@Override
	public void dblclick(int button) {
		System.out.println(button+" 버튼 더블 클릭");
	}

	@Override
	public Double[] move() {
		return null;
	}

}
