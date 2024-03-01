package chap11.ex08;

public class Main {

	public static void main(String[] args) {
		
		// WorkObj 를 객체화 한다.
		WorkObj obj = new WorkObj();
		// 스레드 2개를 생성해서 각각 나눠 준다.
		WorkThread thA = new WorkThread(obj);
		WorkThread thB = new WorkThread(obj);
		// 그리고 실행
		thA.start();
		thB.start();

	}

}
