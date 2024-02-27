// 67.

package Chap06.ex06;

public class Cast {

	public static void main(String[] args) {
		
		Mammal mal;
		
		// 다형성에 의해서 Dog과 Cat은 부모 형태인 Mammal 안으로 들어갈 수 있다.
		mal = new Dog();	
		mal.birth();		// 오버라이드 된 메서드는 내가 변경했다 하더라도 부모것이므로 사용 가능
		mal.eat();		// 원래 부모의 메서드도 사용 가능
		//mal.bark();		// 하지만, 부모 객체라면 자식 객체 고유의 메서드는 사용 불가능!
		
		Dog dog = (Dog)mal;		// 자식의 고유 메서드를 사용하려면 부모에서 자식으로 다운캐스팅.
		// Cat cat = (Cat) mal; 	// 되돌아 갈때 원래 형태를 잘 기억해서 돌아가자 12번째 줄에서 강아지 넣었잖아!
		dog.bark();
		
		mal = new Cat();
		mal.birth();
		mal.eat();
		Cat cat = (Cat) mal;
		cat.mew();
		
		

	}

}
