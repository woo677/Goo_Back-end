package chap05.ex03;

public class Main {

	public static void main(String[] args) {
		
		//std1 과 std2는 각각 다른 복사본 이다  복사본 2개(ex : 설문조사)
		Student std1 =new Student();//new는 복사하고 붙여넣기
		Student std2 = new Student();
		
		//일련번호를 보면 서로 다르다.(내용은 같은 지라도...)
		System.out.println(std1);
		System.out.println(std2);
		
		//그래서 String 끼리 ==대조한다면 일련번호를 대조 해기 때문에 다르다고 판단할 수도 있다
		//그래서 equals()를 통해 일령번호가 아닌 내용으로 대조 하도록 해야 한다
	}

}
