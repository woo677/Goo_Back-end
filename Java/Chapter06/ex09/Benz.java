package Chap06.ex09;

import Chap06.ex10.Car;

public class Benz extends Car {

	@Override
	public String run() {
		
		return "Benz"+ super.run();
	}

	
	
}
