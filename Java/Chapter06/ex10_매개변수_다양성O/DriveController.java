package Chap06.ex10_매개변수_다양성O;

public class DriveController {

	public static void main(String[] args) {
		
		//차량 준비(필드 다형성)
		Car car;
		//레이서 준비
		Racer racer = new Racer();
		//운전
		car = new Audi();//필드 다형성
		System.out.println(racer.drive(car));
//		racer.drive(car);//매개변수 다형성
		car = new Benz();
		System.out.println(racer.drive(car));
//		racer.drive(car);
		car = new BMW();
		System.out.println(racer.drive(car));
	}

}
