package chap07.ex06;

//Child,KeyEvnet,MouseEvent 의 추상메서드를 모두 강제 오버라이드 한다
public class Childlmpl implements Child {

	//KeyEvent 내용
	@Override
	public void keyDown(int key) {
		System.out.println(key + "키 누름");

	}

	@Override
	public void keyUp(int key) {
		System.out.println(key + "키 뗌");

	}

	
	//MonuseEvent 내용
	@Override
	public void click(int button) {
		System.out.println((char)button + "버튼 클릭");

	}

	@Override
	public void dvlclick(int button) {
		System.out.println((char)button + "버블 클릭");

	}

	@Override
	public Double[] move() {
		
		return null;
	}
	
	
	//Child의 내용
	@Override
	public void textField(String input) {
		System.out.println(input+"라고 입력");

	}

	@Override
	public void selsctOne() {
		System.out.println(selsctOne() +"아이템 선택");

	}

	@Override
	public void checkOne() {
		System.out.println(checkOne() +"아이템 체크");

	}

}
