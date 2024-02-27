package chap07.ex01;

public class Person extends Mammal {

	public Person(String name) {
		super(name);//super 는 부모생성자의 줄임말
	}
	//name은 Person에 없는 변수이지만
	//Mammal이 부모이므로 내것처럼 쓸 수 있다 
	public void useTool() {
		System.out.println(name+"가 도구를 사용 한다");
	}
	
	public void social() {
		System.out.println(name+"가 사회 생활을 한다");
	}
	
	public void talk() {
		System.out.println(name+"가 대화를 한다");
	}

}
