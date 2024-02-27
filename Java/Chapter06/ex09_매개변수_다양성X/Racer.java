package Chap06.ex09_매개변수_다양성X;

public class Racer {
	//이 메서드는 벤츠만 운행 가능하다
	public void drive(Benz benz) {
		String ben = benz.run();
		System.out.println(ben);
	}
	
	//BMW
	public void drive(BMW bmw) {
		System.out.println(bmw.run());
	}
	
	//아우디
		public void drive(Audi audi) {
			System.out.println(audi.run());
		}
		
	//매개변수의 객체가 달라지면 거기에 맞게 메서드를 계속 만들어 줘야 한다
	//다행히 오버로드가 지원되므로 메서드 이름을 추가로 만들거나 사용자가 이름을 하나하나 기억해야 하는 일은 없다
	//다만, 차량 객체가 추가될수록 거기에 대응하는 메서드는 게속 추가해 줘야한다
}
