// 64.

package Chap06.ex03;

public class Main {

	public static void main(String[] args) {
		MyCar car = new MyCar();
		car.start();
		car.turbo = true;
		int speed = car.run();
		System.out.println("차가 "+speed+"km로 달린다.");
		car.stop();

	}

}
