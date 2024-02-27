package Chaper07ex06;

public class Main {

	public static void main(String[] args) {
		
		Child child = new Childimpl();
		
		child.click(1);
		child.dblclick(2);
		
		child.keyDown(47);
		child.keyUp(47);

		child.selectOne();
		child.checkOne();
		child.textField("아무거나 입력");
	}

}
