package chap09.ex03;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		//set 은 중복을 허용하지 않고, 순서도 없다.
		set.add("JAVA");
		set.add("JSP");
		set.add("MARIA");
		set.add("SPRING");
		set.add("JAVA"); //중복
		System.out.println(set+":"+set.size());
		
		HashSet<Member>member = new HashSet<Member>();
		member.add(new Member());
		member.add(new Member()); /*복사본이라서 멤버가 두개 중복이라고 생각할 수 있지만 아님!  데이터는 같아도 일련번호가 다름 하나하나가 객체임! 일련번호가 다름 
		2개임 ! 다른객체임 ! 객체번호도 다름!  string.equals가 두 객채가 같은지 비교해줌*/
		System.out.println(member.size());

		//요소 삭제 
		set.remove("MARIA");
		
		//요소를 하나씩 뽑아 내는 방법 1: 정석적인 방법 : 원래 가져올때 보통의 방식
		Iterator<String> iter =set.iterator(); //덩어리를 쪼갬 
		
		while(iter.hasNext()) { //가져올 값이 있는지(true/false)
			System.out.println(iter.next()); //하나씩 가져옴
		}
		
		System.out.println();
		//요소를 하나씩 뽑아 내는 방법 2: 향상된 for문
		//set 을 넣으면 알아서 쪼개 준다.
		for (String val : set) {
			System.out.println(val);
		}
		// isEmpty()
		// clear()
	
	
	}

}
class Member{
	
	
}
