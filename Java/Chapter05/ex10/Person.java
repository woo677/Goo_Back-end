package chap05.ex10;

public class Person {
	
	final String nation;
	final static String ssn = "010721-1234567";		// static final은 생성자로 초기화 할 수 없어 아예 값을 줘야한다.
	final String name;
	int age;
	
	
	// final은 프로그램 시작 시 초기화 후에 끝날 때 까지 변할 수 없다.
	// 그래서 반드시 생성자를 통해 초기화 해줘야 한다.
	public Person(String nation, String name) {
		this.nation = nation;
		this.name = name;
	}

}
