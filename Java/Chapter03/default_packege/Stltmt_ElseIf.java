package default_packege;

public class Stltmt_ElseIf {

	public static void main(String[] args) {
		//우리가 가지고 있는 음료수 : 콜리,생수,오랜지주스,사이다,에너지음료,냉커피,식혜
		String tiem = "콜라";
	
		
		///item 의 값이 가지고 있는 음료이면 000 이 나왔습니다. 라고 출력 해 보자
		if (tiem.equals("콜라")) {
			System.out.println(tiem +" 나왔습니다");
		}else  if (tiem.equals("생수")) {
			System.out.println(tiem +" 나왔습니다");
		}else if (tiem.equals("오랜지주스")) {
			System.out.println(tiem +" 나왔습니다");
		}else if (tiem.equals("사이다")) {
			System.out.println(tiem +" 나왔습니다");
		}else if (tiem.equals("에너지음료")) {
			System.out.println(tiem+" 나왔습니다");
		}else if (tiem.equals("냉커피")) {
			System.out.println(tiem +" 나왔습니다");
		}else if (tiem.equals("식혜")) {
			System.out.println(tiem +" 나왔습니다");
		}else {
			System.out.println(tiem+" 은(는) 보유하지 않고 있습니다");
		}

	}

}
