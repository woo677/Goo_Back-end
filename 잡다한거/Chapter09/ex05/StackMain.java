package chap09.ex05;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		//LIFO : 나중에 들어간 놈이 먼저 빠진다
		Stack<Towel> box = new Stack<Towel>();
		
		//수건을 넣어 보자 push()
		box.push(new Towel("red"));
		box.push(new Towel("orange"));
		box.push(new Towel("yellow"));
		box.push(new Towel("green"));
		box.push(new Towel("blue"));
		box.push(new Towel("nayy"));
		box.push(new Towel("purple"));
		
		//꺼내기 pop() 단순 방법
		/*Towel towel = box.pop();
		System.out.println(towel.getColor());
		
		towel = box.pop();
		System.out.println(towel.getColor());
		
		towel = box.pop();
		System.out.println(towel.getColor());
		
		towel = box.pop();
		System.out.println(towel.getColor());
		
		towel = box.pop();
		System.out.println(towel.getColor());
		
		
		//메서드 체이닝 : 앞 메서에서 진행하여 반환된 값을 가지고 연결해서 진행 할 때(변수에 값을 담고 그 변수를 출력 해야되는데 그러지 않고 값을 바로 출력해도 된다)
		System.out.println(box.pop().getColor());
		System.out.println(box.pop().getColor());*/
		
		
		//다른 녀석들은 값을 불러온다고 해서 사라지지 않았다
		//stack 은 pop() 을 하면 사라진다 (pop는(팝) 꺼내서 던져라)
	while (!box.isEmpty()) {//.isEmpyt : 내용 물이 있니?
		//peek()(픽)은 확인만 하고 다시 집어 넣는다(갯수가 변하지 않는다)
		System.out.println(box.pop().getColor()+"수건 꺼냄"+ box.size()+"장 남음");
	}
	}

}
