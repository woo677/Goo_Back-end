package chap11.ex04_데이터오염_싱로나이즈드;

public class PcRoom {

	public static void main(String[] args) {
		
		//공용 컴퓨터
		Computer com = new Computer();
		
		Uesr1 user1 = new Uesr1(com);
		Uesr2 user2 = new Uesr2(com);
		
		//사용
		user1.start();//500
		user2.start();//200

	}

}
