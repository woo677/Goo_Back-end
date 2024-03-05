package chap09.ex06;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {

	public static void main(String[] args) {
		
		//Queue는 규격일 뿐이고, 실제로는 링크드 리스트로 만들어쪘다
		Queue<Job> queue = new LinkedList<Job>();
		
		//데이터 추가 : offer()
		queue.offer(new Job ("send SMS", "Alice"));
		queue.offer(new Job ("send Main", "Bryan"));
		queue.offer(new Job ("send SUS", "Chriss"));
		queue.offer(new Job ("send Mail", "Denis"));
		queue.offer(new Job ("send SMS", "Erick"));

	
	//하나씩 빼니기 : poll()
	
	//isEmpty() 활용해서 queue 에 있는 모든 내용 빼 보기
		Job jop = null;
	while (!queue.isEmpty()) {
		jop =queue.poll();
		//peek() 을 쓰면 확인 하고 다시 넣는다
		System.out.println(jop.getTo()+"에게"+jop.getCommand()+" 를 해라");
	}
}
}