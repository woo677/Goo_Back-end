package Chap06.ex09;

public class DriveController {

	public static void main(String[] args) {
		
		//차량 준비
		BMW bmw = new BMW();
		Benz benz = new Benz();
		Audi audi = new Audi();
		
		//레이서에게 운전을 요청 한다. 
		Racer racer = new Racer();
		racer.drive(audi);
		racer.drive(benz);
		racer.drive(bmw);
	}

}
