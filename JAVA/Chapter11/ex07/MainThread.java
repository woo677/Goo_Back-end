package chap11.ex07;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("1~100 까지의 합은?");

		// 워크 스레드에게 계산 시킴
		OperThread oper = new OperThread();
		oper.start();
		// 왜 0 이 나오는지?
		// 워크스레드가 계산하고 있는데, 메인스레드가 답을 요구함
		
		//Thread.sleep(1); // 해결방법 1 : 넉넉하게 계산할 시간을 준다(시간낭비가 발생)
		oper.join(); // 해결방법 2 : oper 가 일을 완료할때 까지 기다린다.(block)
		
		System.out.println("답 : "+oper.getSum());

	}

}
