// 29.
import java.util.Iterator;

public class StmtElseIf {

	public static void main(String[] args) {
		// 우리가 가지고 있는 음료수: 콜라, 생수, 오렌지주스, 사이다, 에너지음료, 냉커피, 식혜
		// item의 값이 가지고 있는 음료이면 000이 나왔습니다. 라고 출력해보자.
		
		String item= "아메리카노";

		String[] drink = {"콜라", "생수", "오렌지주스", "사이다", "에너지음료", "냉커피", "식혜"};
		
		if (item.equals("콜라")) {
			System.out.println(item+"(이)가 나왔습니다.");
		} else if (item.equals("생수")) {
			System.out.println(item+"(이)가 나왔습니다.");
		} else if (item.equals("오렌지주스")) {
			System.out.println(item+"(이)가 나왔습니다.");
		} else if (item.equals("사이다")) {
			System.out.println(item+"(이)가 나왔습니다.");
		} else if (item.equals("에너지음료")) {
			System.out.println(item+"(이)가 나왔습니다.");
		} else if (item.equals("냉커피")) {
			System.out.println(item+"(이)가 나왔습니다.");
		} else if (item.equals("식혜")) {
			System.out.println(item+"(이)가 나왔습니다.");
		} else {
			System.out.println(item+"은 보유하지 않고 있습니다.");
		}
		
		for (int i = 0; i < drink.length; i++) {
			if (item == drink[i]) {
				System.out.println(drink[i]+"(이)가 나왔습니다.");
			} else {
				i++;
				if (i == drink.length) {
					System.out.println("주문하신 메뉴가 없습니다.");
				}
			}
		}
		
	}

}
