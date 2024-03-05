package chap11.ex06;

public class MainThread {

	public static void main(String[] args) throws Exception {
		
		WorkThread thA = new WorkThread();
		thA.setName("thread A");
		WorkThread thB = new WorkThread();
		thB.setName("thread B");
		thA.start();
		thB.start();
		
		//thA 한테 양보 하라고 함
		thA.yield = true;
		
		//0.5초 후에
		Thread.sleep(500);
		
		
		//thB 한테 양보 하라고 함
		thA.yield = false;
		thB.yield = true;
		//0.5초 후에
		Thread.sleep(500);
		
		//둘 다 정지
		thA.stop = true;
		thB.stop = true;
	}

}
