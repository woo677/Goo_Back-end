package chap12.ex06;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		try {
			// 1. 접속 요청
			Socket socket = new Socket("localhost", 5555);
			System.out.println("접속 성공");
			// 2. 보내기
			SenderThread sender = new SenderThread(socket);
			sender.start();			
			// 3. 받기
			ReceiveThread receiver = new ReceiveThread(socket);
			receiver.start();
		
		} catch (Exception e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}

	}

}
