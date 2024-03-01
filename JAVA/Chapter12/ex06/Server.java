package chap12.ex06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		// 1. 서버 생성
		ServerSocket server = new ServerSocket(5555);
		System.out.println("접속 대기");
		// 2. 접속 수락
		Socket socket = server.accept();
		System.out.println("접속 수락");
		
		// 3. 보내기
		SenderThread sender = new SenderThread(socket);
		sender.start();
		
		// 4. 받기
		ReceiveThread receiver = new ReceiveThread(socket);
		receiver.start();

	}

}
