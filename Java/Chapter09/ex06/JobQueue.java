package chap09.ex06;

import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {

	public static void main(String[] args) {
		
		//Queue 는 규격일 뿐이고, 실제로는 링크드 리스트로 만들어졌다. 
		Queue<Job>queue = new LinkedList<Job>(); 
		
		//데이터 추가 : offer()
		queue.offer(new Job("send SMS", "Alice"));
		queue.offer(new Job("send SMS", "Bryan"));
		queue.offer(new Job("send SMS", "Chriss"));
		queue.offer(new Job("send SMS", "Denis"));
		queue.offer(new Job("send SMS", "Erick"));
		
		//하나씩 빼내기 : poll()
		//isEmpty() 활용 해서 queue 에 있는 모든 내용 빼 보기 
		
		Job job = null;
		while (!queue.isEmpty()) {
			job = queue.poll();
			//peek() 을 쓰면 확인 하고 다시 넣는다. 
			System.out.println(job.getTo()+"에게"+job.getCommand()+ " 를 해라");
			}
		
		
	}

}
