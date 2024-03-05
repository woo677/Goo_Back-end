package chap11.ex04_데이터오염_싱로나이즈드;

public class Uesr1 extends Thread {

	private Computer com; 
	
	public Uesr1(Computer com) {
		setName("user 1");
		this.com = com;
	}
	

	@Override
	public void run() {
		com.setScore(500);//user2 은 점수를 500점으로 만들어 놨다
	}
}