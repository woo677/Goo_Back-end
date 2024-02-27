package Chap06.ex04;

// 상속 받은 클래스 (1개의 자바 파일에 1개 이상의 클래스가 가능하다.)
public class Child extends ParentHouse {
	@Override
	public void userRoom() {
		System.out.println("첫째가 방을 쓴다.");
	}

}


// 자바 파일에는 해당 자바파일과 이름이 동일한 클래스 하나만 public을 가져갈 수 있다.. (즉 위의 대표되는 것만 퍼블릭 가능!)
class ChildOne extends ParentHouse {
	@Override
	public void userRoom() {
		System.out.println("둘째가 방을 쓴다.");
	}
}
class ChildTwo extends ParentHouse {
	@Override
	public void userRoom() {
		System.out.println("셋째가 방을 쓴다.");
	}
}
class ChildThree extends ParentHouse {
	@Override
	public void userRoom() {
		System.out.println("넷째가 방을 쓴다.");
	}
}
class ChildFour extends ParentHouse {
	@Override
	public void userRoom() {
		System.out.println("다섯째가 방을 쓴다.");
	}
}
