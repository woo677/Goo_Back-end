package Chap06.ex06;

public class Cast {

	public static void main(String[] args) {
		
		Mammal mal;
		
		
		//다향성에 의해서 Dog과 Cat은 부모 형태인 Mammal 안으로 들어갈 수 있다
		mal =new Dog();
		mal.birth();//오버라이드 된 메서드는 내가 변경햇다 하더라도 부모것 이므로 사용 가능
		mal.eat();//원래 부모의 메서드는 사용 가능
		//mal.bark(); //내 고유 메서드는 사용 못함
		
		Dog dog = (Dog) mal;//부모 형태에서 자식 형태로 되돌아 온다 //변환을 해조야한다 //캐스팅
		//Cat cat = (Cat) mal; //되돌아 갈때 원래 형태를 잘 기억해서 돌아가자
		dog.bark();
	}

}
