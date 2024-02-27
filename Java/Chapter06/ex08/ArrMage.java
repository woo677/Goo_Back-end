// 70.

package Chap06.ex08;

import java.util.Iterator;

public class ArrMage {
	

	public static void main(String[] args) {
		
		// Ice, Light, Fire 주문을 연속으로 날릴 수 있도록 배열과 for문을 활용하여 구현해 보자.
		Spell[] arr = {new Ice(), new Fire(), new Light()};
		
		for (Spell spell : arr) {
			System.out.println(spell.casting());
		}
		// 배열에 세개의 객체를 어떻게 쑤셔넣느냐?
		// 객체를 반복문으로 생성할 수 있는가? -> X
		// 그렇다면 현 객체의 값이 전 객체의 값이 달라진다면! 
		/*
		String[] arrMage = new String[3];
		String[] Mage = {"Fire", "Ice", "Light"};
		String current = "";
		
		
		spell = new Fire();
		arrMage[0] = spell.casting();
		
		spell = new Ice();
		arrMage[1] = spell.casting();
		
		spell = new Light();
		arrMage[2] = spell.casting();
		
		for (int i = 0; i < arrMage.length; i++) {
			System.out.println(arrMage[i]);
		}*/
		

	}

}
