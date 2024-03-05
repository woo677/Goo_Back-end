package chap08.ex09;

public class Main {

	public static void main(String[] args) {
		
		JoinMember jojn = new JoinMember();
		String id = "manager";
		
		//실행 예외
		try {
			jojn.reservedCheck(id);
			
		} catch (Exception e) {
			System.err.println(id+"는 예약어 입니다");
		}
		
		//일반 예외
		int age = 19;
		try {
			jojn.ageCehck(age);
		} catch (AdultException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();//예외에 대한 상세 정보 //이게 있어아 어디서 예외가 발생 했는지 알수 있다
			System.out.println("20세 미만은 가입 금지");
		}
		
	}

}
