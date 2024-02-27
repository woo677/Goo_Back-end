package Chap06.ex03;

public class MyCar extends ParentCar {

	// 부모로 부터 받은 메서드를 완전히 뜯어 고친다.
	/*
	@Override
	public int run() {
		
		return 200;
	}
	*/
	
	// 일부분만 변경 (부모걸 사용할수도, 안할수도 있다.)
	// super 는 부모를 의미
	
	boolean turbo = false;
	
	// 상황에 따라서 부모 메서드를 일부 사용
	@Override
	public int run() {
		if(turbo) {
			return 200;
		} else {
			return super.run();
		}
	}

	
	
	
	
	
	

}
