package chap05.ex10;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person("korea", "홍길동");
		p.age = 30;
		//final 키워드가 붙은 필드는 초기값을 읽을 수만 있다
//		p.natlons = "AMERICA"
//		p.name = "KIM"//오류
		System.out.println(p.natlons);
		System.out.println(p.name);
		System.out.println(Person.ssn);
		System.out.println(p.age);
	}

}
