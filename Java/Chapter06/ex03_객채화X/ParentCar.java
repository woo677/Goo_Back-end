package Chap06.ex03_객채화X;

public class ParentCar {

		public void start() {
			System.out.println("시동을 건다");
		}
		
		public int run() {
			return 50;
		}
		
		public void stop() {
			System.out.println("정지하다");
		}
		
		
		//finl은 read only 이기 때문에 오버라이드 할 수 없다
		//오버라이드는 기본 메서드를 수정하는 직업 이니까
		 public final void test() {
			System.out.println("자가 점검");
		}
}
