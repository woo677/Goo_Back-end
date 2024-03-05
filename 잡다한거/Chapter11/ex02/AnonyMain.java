package chap11.ex02;

public class AnonyMain {

	public static void main(String[] args) {

		//클래스로 익명 객체?
		Thread th = new Thread() { //class에서는 {} 이게 익명 객체제다

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("work thread....");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {							
							e.printStackTrace();
					}
				}
			} 
			
		};
		
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
