package chap07.ex01;

//추상 클래스 에는 abstract 키워드 추가  
public abstract class Mammal {

	public String name;
	//this.자신의 객체에 접근할 때 사용
	public Mammal(String name) {
		this.name = name;
	}
	public void birth() {
		System.out.println(name+"가 아이를 낳다");
	}
	
	public void eat() {
		System.out.println(name+"가 젖을 먹이다");
	}
}
