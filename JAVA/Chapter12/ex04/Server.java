package chap12.ex04;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		
		// 1. 서버소켓 생성
		ServerSocket server  = new ServerSocket(7777);

		
		while(true) {
			System.out.println("접속 대기...");// 2. 접속 대기
			Socket socket = server.accept();// 3. 접속 요청 수락
			// 4. 읽기
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String msg = ois.readUTF();
			System.out.println("받은 메시지> "+msg);
			
			// 5. 쓰기
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeUTF("당신이 보낸 메시지 : "+msg);
			oos.flush();	
			
			// 6. 자원 반납
			ois.close();
			oos.close();
			socket.close();
		}
		
		
		


	}

}
