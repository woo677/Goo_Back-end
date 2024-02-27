package Chap06.ex10_매개변수_다양성O;

public class Audi extends Car{

	@Override
	public String run() {
		return "Audi"+super.run();
	}

	
}
