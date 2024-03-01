package chap12.ex02;

import java.io.IOException;
import java.net.Socket;

class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		// java chap12.ex02.Client		
		try {
			// 1. 소켓 생성(IP, port) -> 서버한테 접속 요청 한거
			socket = new Socket("localhost", 5500);		
			System.out.println("접속 성공");
		} catch (Exception e) {// 2. 접속이 거절되면 예외 발생
			System.out.println("접속 실패");
			e.printStackTrace();
		}finally {// 3. 자원 반납
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		


	}

}
