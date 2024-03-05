package chap07.ex06;

public class Main {

	public static void main(String[] args) {
		Child child = new Childlmpl();
		
		child.click(1);
		child.dvlclick(2);
		
		child.keyDown(47);
		child.keyUp(47);

		child.selsctOne();
		child.checkOne();
		child.textField("아무거나 입력");
	}

}
