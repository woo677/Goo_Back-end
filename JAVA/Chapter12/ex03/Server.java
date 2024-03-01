package chap12.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = null;
		
		// 1. 서버 소켓(포트)
		try {
			server = new ServerSocket(7777);
			// 2. 접속 대기
			while(true) {
				System.out.println("접속 대기 중...");
				// 3. 접속요청이 오면 수락
				Socket socket = server.accept();
				// 4. 할일...	
				// 주스트림 준비
				InputStream is = socket.getInputStream();
				// 보조스트림준비
				ObjectInputStream ois = new ObjectInputStream(is);				
				// 읽고
				String msg = ois.readUTF();
				System.out.println("Client> "+msg);
				// 쓰고				
				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeUTF("니가 보낸 메시지 : "+msg);
				
				// 다 썼으면 자원 반납
				oos.flush();
				ois.close();
				oos.close();
				socket.close();
			}		
		} catch (IOException e) {		// 예외 발생시 자원 반납	
			e.printStackTrace();
			server.close();
		}
		
	}

}
