package chap12.ex05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver { // Server

	public static void main(String[] args) throws IOException {
		
		// 서버소켓 생성
		ServerSocket server = new ServerSocket(7777);
		
		while(true) {// 접속 대기
			System.out.println("접속 요청 대기");
			Socket socket = server.accept();
			// 클라이언트에서 보내온 스트림 수신
			InputStream is = socket.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			String fileName = ois.readUTF();
			
			// 내 PC 의 특정 경로로 저장
			FileOutputStream fos = new FileOutputStream("C:/Users/goodee/Downloads/"+fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			System.out.println("파일 저장 시작");
			int data;
			while((data=ois.read()) != -1) {
				bos.write(data);
			}
			System.out.println("파일 저장 완료");			
			// 자원 반납	
			bos.flush();
			ois.close();
			bos.close();
			socket.close();
		}
	

	}

}
