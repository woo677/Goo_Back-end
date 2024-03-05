package chap11.ex05;

public class Main {
	
	private static Thread.State state;

	public static void main(String[] args) {
		
		//스레드 생성
		workthread1 work = new workthread1();
		state = work.getState();//(getState)은 work에 상테가 어떤지 알수 있다
		System.out.println("Thread state: "+state);
		
		//감시시작
		//스레드 실행
		work.start();
		
		//계속해서 워크 스레드의 상태를 가져와 출력
		while (true) { //계속 감시를 시킨다
			state = work.getState();
			System.out.println("Thread state: "+state);
			
			//워크스레드가 종료되면 반복문 탈출
			if (state == Thread.State.TERMINATED) {
				break;
			}
		}
		//cpu와 관계가 있다(동작방식) 
		//자주 찍히는 이유(컴퓨터는 전기를 자극 받을 때 툭툭 튄다 CPU(C분할방식))
		//0,1으로 계산(스탑옵션)
		//스레들(분신술)
	}

}
