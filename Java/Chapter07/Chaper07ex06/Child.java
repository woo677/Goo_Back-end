package Chaper07ex06;

import Chaper07ex03.MouseEvent;
import Chaper07ex04.KeyEvent;


//인터페이스는 규격 개념으로 필요한 규격을 모듈처럼 가져다 붙인다. 
public interface Child extends KeyEvent, MouseEvent {

	public void textField(String input);
	
	public void selectOne();
	
	public void checkOne();
	
}
