package Chap06.ex03_객채화X;

public class MyCar extends ParentCar{


	//부모로 부터 받은 메서드를 완전히 뜯어 고친다
	
	/*@Override //@받을걸 고쳐 쓰는 거라는걸 알려준다
	public int run() {
		
		return 200;
	*/

		//일부분만 변경(부모걸 사용 할수도 안할수도 있음)
		//super는 부모를 의미
	
	boolean turbo = false;
	
	@Override
	public int run() {//상황에 따라서 부모 메서드를 일부 사용
		if (turbo) {
			return 200;
		}else {
			return super.run();			
		}
	}
	
}
