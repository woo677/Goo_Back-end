package chap11.ex04_데이터오염_싱로나이즈드;

public class Computer {

	private int score;
	
//	public void setScore(int score) {
//		
//		//내가 점수를 만들어 놓고..
//		this.score = score;
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {//2초간 자리를 비운 후(누군가 이사이 점수를 건드릴 수 있다)
//			e.printStackTrace();
//		}
//		//돌아와서 다시 점수 확인
//		System.out.println(Thread.currentThread().getName()+" : "+this.score);
//		
//	}
	
	
	//synchronized(싱크로나이즈드) : 오직 하나만 사용하고 나머지는 줄 서서 기다리게 만드는 기능
	//synchronized 메서드 : 메서드 진입 자체를 막아 버린다
//	public synchronized void setScore(int score) {
//		
//		//내가 점수를 만들어 놓고..
//		this.score = score;
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {//2초간 자리를 비운 후(누군가 이사이 점수를 건드릴 수 있다)
//			e.printStackTrace();
//		}
//		//돌아와서 다시 점수 확인
//		System.out.println(Thread.currentThread().getName()+" : "+this.score);
//		
//	}
	
	
	//synchronized 불록 - 메서드 안의 특정 영역 진입을 막는다
	public void setScore(int score) {
		
		synchronized (this) {
			
			//내가 점수를 만들어 놓고..
			this.score = score;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {//2초간 자리를 비운 후(누군가 이사이 점수를 건드릴 수 있다)
				e.printStackTrace();
			}
			//돌아와서 다시 점수 확인
			System.out.println(Thread.currentThread().getName()+" : "+this.score);
		}
		
		
	}
}
