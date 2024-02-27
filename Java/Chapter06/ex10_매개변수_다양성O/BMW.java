package Chap06.ex10_매개변수_다양성O;

public class BMW extends Car {
	
	@Override
	public String run() {
		return "Bmw"+super.run();
	}

}
