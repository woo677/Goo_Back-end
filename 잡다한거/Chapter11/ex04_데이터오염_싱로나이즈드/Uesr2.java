package chap11.ex04_데이터오염_싱로나이즈드;

public class Uesr2 extends Thread {

	private Computer com; 
	
	public Uesr2(Computer com) {
		setName("user 2");
		this.com = com;
	}
	

	@Override
	public void run() {
		com.setScore(200);//user1 은 점수를 200점으로 만들어 놨다
	}
}