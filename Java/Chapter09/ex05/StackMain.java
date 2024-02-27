package chap09.ex05;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		//LIFO : 나중에 들어간 놈이 먼저 빠진다. 
		Stack<Towel> box = new Stack<Towel>();

		//수건을 넣어 보자 push()
		box.push(new Towel("red"));
		box.push(new Towel("orange"));
		box.push(new Towel("yellow"));
		box.push(new Towel("green"));
		box.push(new Towel("blue"));
		box.push(new Towel("navy"));
		box.push(new Towel("purple"));
		
		/*//꺼내기 pop()
		Towel towel = box.pop();
		System.out.println(towel.getColor());
		
		
		// 메서드 체이닝 - 앞 메서드에서 진행하여 반환된 값을 가지고 무언가 연결해서 진행 할 때 
		System.out.println(box.pop().getColor());
		System.out.println(box.pop().getColor());
		System.out.println(box.pop().getColor());
		System.out.println(box.pop().getColor());
		System.out.println(box.pop().getColor());
		System.out.println(box.pop().getColor());
		*/
		//다른 녀석들은 값을 불러온다고 해서 사라지지 않았다.
		//stack 은 pop()을 하면  사라진다.
		while(!box.isEmpty()) {
			//peek()은 확인만 하고 다시 집어 넣는다. 갯수가 변하지 않음  pop과 peak의 차이점 잘 파악 정처기 나올수있음 
			System.out.println(box.pop().getColor()+" 수건 꺼냄"+box.size()+"장 남음");
			
		
		
		
	}

}
}