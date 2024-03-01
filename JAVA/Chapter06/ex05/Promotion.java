package chap06.ex05;

public class Promotion {
	
	public static void main(String[] args) {
		
		Vertbrate 척추동물;
		// 닭, 오리, 개, 고양이는 모두 척추 동물 이므로 이 안에 들어 갈 수 있다.
		척추동물 = new Dog();
		척추동물 = new Cat();
		척추동물 = new Duck();
		척추동물 = new Chiken();
		
		// 고양이는 조류에 속하나?
		//Birds birds = new Cat();
		
		// 닭은 포유류에 속하나?
		//Mammal mal = new Chiken();
		
	}
}

class Vertbrate{}

class Mammal extends Vertbrate{}
class Birds extends Vertbrate{}

class Dog extends Mammal{}
class Cat extends Mammal{}

class Duck extends Birds{}
class Chiken extends Birds{}
