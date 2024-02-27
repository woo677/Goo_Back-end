package Chap06.ex06;

public class Dog extends Mammal {

	
	// 같은 포유류라 하여도, 새끼를 낳는 수는 각각 다르기에 오버라이드를 한다.
	@Override
	void birth() {
		System.out.println("새끼를 5마리 낳는다.");
	}
	
	
	// Mammal이 아닌 Dog의 고유 특성
	void bark() {
		System.out.println("멍멍 짖는다.");
	}
}
