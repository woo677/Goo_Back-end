package Chap06.ex10_매개변수_다양성O;

public class Racer {

//	다형성을 매개변수에 활용 했다
//	부모인 Car를 상속받은 그 어떤 객체도 들어올수 있다
	public String drive(Car car) {
		return car.run();
	}
	
	//다만 들어오는 객체의 고유 메서드가 있다면 위의 형태로는 사용할 수 없다
}
