package chap05.ex07;

public class Car {
	
	int gear = 0;				// 기어
	boolean on = false;		// 시동 상태

	//시동이 걸렸습니다
	public Car() {
		gear = 0;
		on = false;
	}
	
	void start () {
		if (on) {
			System.out.println("시동이 걸려있습니다.");
		} else {
			System.out.println("시동이 걸렸습니다.");
		}
		
	}
	
	// 기어 몇 단 변동
	void change(int gear) {
		System.out.println(gear+" 단으로 변속 되었습니다.");
		this.gear= gear;
	}

}
