// 65.

package Chap06.ex04;

public class Main {

	public static void main(String[] args) {
		
		// 다형성을 사용하기 전
		// 사용할 객체가 여러개라면, 여러개의 객체를 담을 변수를 선언해 줘야 한다.
		// 만약 사용할 객체의 갯수가 100개라면, 몇개의 변수를 선언해야 하는가...
		
		Child ch = new Child();
		ch.userRoom();
		
		ChildOne ch1 = new ChildOne();
		ch1.userRoom();
		
		ChildTwo ch2 = new ChildTwo();
		ch2.userRoom();
		
		ChildThree ch3= new ChildThree();
		ch3.userRoom();
		
		ChildFour ch4 = new ChildFour();
		ch4.userRoom();
		
		System.out.println();
		
		// 다형성을 사용한 후
		// 하나의 변수(부모타입)에 여러 객체(자식타입)을 수용할 수 있다.
		ParentHouse house;
		house = new Child();
		house.userRoom();
		
		house = new ChildOne();
		house.userRoom();
		
		house = new ChildTwo();
		house.userRoom();
		
		house = new ChildThree();
		house.userRoom();
		
		house = new ChildFour();
		house.userRoom();
	}

}
