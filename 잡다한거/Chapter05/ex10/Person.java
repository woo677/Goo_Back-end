package chap05.ex10;

public class Person {

	final String natlons;
	static final String ssn = "16516-04564";//static final은 생성자로 초기화 할수 없어서 아예 값을 줘야 한다
	final String name;
	int age;
	
	//flnal은 프로그램 시작시 초기화 후에 끝날때 까지 변할수 없다
	//그해서 반드시 생성자를 통해 초기화 해줘야 한다
	public Person(String nation,String name) {
		this.natlons = nation;
		this.name = name;
	}
}
