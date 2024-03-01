package chap12.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

class Client {

	public static void main(String[] args) throws IOException {
			
		Socket socket = null;
		// 1. 소켓생성(IP, 포트)
		try {
			socket = new Socket("192.168.70.138", 7777);
			System.out.println("접속 완료");// 2. 예외가 발생하지 않으면 접속 완료
			// 3. 할 일	
			String msg = "Hi JAVA Network";
			OutputStream os= socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			System.out.println("전송 내용 : "+msg);
			oos.writeUTF(msg);
			oos.flush();
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			msg = ois.readUTF();
			System.out.println(msg);
			
			ois.close();
			oos.close();
			
		} catch (Exception e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}finally {			
			socket.close();// 4. 다 끝났으면 자원 반납
		}
		
		
	}

}
