package chap11.ex02;

public class Main {

	public static void main(String[] args) {
		
		//할일 객체화
//		Job job = new Job();
		//스레드 객체화
		Thread th = new Job();//스레드 객체화(상속과 다형성 활용) //이렇게 쓸수도 있다(다형성 때문에)
		//스레드 실행
		th.start();
		
		for (int i = 0; i <5 ; i++) {
			System.out.println("Main Thread...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}

}
