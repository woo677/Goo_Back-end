package chap11.ex07;

public class MainThread {

	public static void main(String[] args) throws Exception {

		//워크 스레드에게 계산 시킴
		System.out.println("1~100까지의 합은?");
		OperThread oper = new OperThread();
		oper.start();
		
		//원인 : 중간에 답을 끄집어내서 (기다리지 않아서)
		//해결법 : 잔깐 기달릴 시간을 주면 된다
		//문제점 : 쓸대없는 시간까지 준다
		//왜 0이 나오는지 
		//워크스레드가 계산하고 있는데, 메인스레드가 답을 요구함
		//해결법 1 : 넉넉하게 계산할 시간을 준다(시간낭비가 발생)
		//Thread .sleep(1);
		//해결법 2 : opre 가 일을 완료할때 까지 기다린다(block(블로킹))
		oper.join(); //조인(동기 방식)
		
		System.out.println("답 : "+oper.getSum());


	}

}
