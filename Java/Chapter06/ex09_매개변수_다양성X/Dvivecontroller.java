package Chap06.ex09_매개변수_다양성X;

public class Dvivecontroller {

	public static void main(String[] args) {
		
		//차량 준비
		BMW bmw = new BMW();
		Benz benz = new Benz();
		Audi audi = new Audi();
		
		//레이서에게 운전을 요청한다
		Racer racer = new Racer();
		racer.drive(audi);
		racer.drive(benz);
		racer.drive(bmw);

	}

}
