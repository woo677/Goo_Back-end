package chap07.ex06;

import chap07.ex03.MouseEvent;
import chap07.ex04.KeyEvent;

//인터페이스는 규격 개녕으로 필요한 규격을 모듈처럼 가져다 붙인다
public interface Child extends KeyEvent, MouseEvent {

	public void textField(String input);
	
	public void selsctOne();

	public void checkOne();
}
