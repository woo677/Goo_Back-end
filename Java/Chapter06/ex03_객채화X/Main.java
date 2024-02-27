package Chap06.ex03_객채화X;

public class Main {

	public static void main(String[] args) {

		MyCar car = new MyCar();
		car.start();
		car.turbo=true;
		int speed = car.run();
		System.out.println("차가 시속"+speed+"Km 으로 달린다");
		car.start();
	}

}
