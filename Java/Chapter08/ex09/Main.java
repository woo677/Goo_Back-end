package Chap08.ex09;

public class Main {

	public static void main(String[] args) {
		
		JoinMember join = new JoinMember();
		
		//실행 예외: 실행 해 봐야 알 수 있는 예외 
		String id = "manager";
		try {
			join.reservedCheck(id);
		} catch (Exception e) {
			System.out.println(id+"는 예약어 입니다.");
		}
	
		//일반 예외   ->는 알려줌 네모난박스 , 안알려주면 실행 예외 
		int age = 19;
		try {
			join.ageCheck(age);
		} catch (AdultException e) {
			//e.printStackTrace(); //예외에 대한 상세 정보
			System.out.println("20세 미만은 가입 금지");
		}

	}

}
