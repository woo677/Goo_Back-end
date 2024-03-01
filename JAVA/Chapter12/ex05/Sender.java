package chap12.ex05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Sender { // Client

	public static void main(String[] args) throws Exception {

		
		Socket socket = new Socket("192.168.70.138",7777);// 서버 연결
		
		// 내 PC 에서 파일 불러오기
		File file = new File("C:/img/high.gif");//파일객체
		String fileName = file.getName();// 파일 이름
		long size = file.length();// 크기(byte)
		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		// 소켓을 이용하여 스트림 추출
		OutputStream os = socket.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeUTF(fileName);// 파일명 전송
		byte[] arr = new byte[(int) size];
		int data = bis.read(arr); // 배열에 데이터가 담기고, 얼마만큼의 크기에 담겼는지 반환
		System.out.println("한번에 읽은 크기 : "+data);
		
		oos.write(arr); // 바이트 전송
		System.out.println("전송 완료 : 크기("+(size/1024)+"KB)");
		
		/*
		int data;
		while((data=bis.read()) != -1) {			
			bos.write(data);// 내 PC 에서 읽어온 내용 내보내기
		}
		*/
		oos.flush();
		bis.close();
		oos.close();		
		socket.close();// 자원 반납

	}

}
