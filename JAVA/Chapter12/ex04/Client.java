package chap12.ex04;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		
		// 1. 소켓 생성
		Socket socket = new Socket("localhost", 7777);
		
		// 2. 스캐너로 입력 받기
		Scanner scan = new Scanner(System.in);
		System.out.print("입력>");
		String msg = scan.nextLine();
		
		// 3. 보내기
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeUTF(msg);
		oos.flush();
		
		// 4. 받기
		InputStream is = socket.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(is);
		msg = ois.readUTF();
		System.out.println(msg);
		
		// 5. 자원 반납
		oos.close();
		ois.close();
		scan.close();
		socket.close();
		
	}

}








