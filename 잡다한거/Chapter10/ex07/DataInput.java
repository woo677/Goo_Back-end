package chap10.ex07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.Socket;

public class DataInput {

	public static void main(String[] args) throws Exception {
		// 읽은 파일 위치 + 파일객체 + 주 스트림 준비
		FileInputStream fis = new FileInputStream("C:/img/temp/data.dat");
		
		//보조스트림(속도 + 자바 고유데이터 사용)
		DataInputStream dis = new DataInputStream(fis);
		
		//읽기오기(쓴 순서 그대로 읽어와야 한다(내보니기))
		String mane =  dis.readUTF();
		int salary = dis.readInt();
		boolean promotion = dis.readBoolean();
		System.out.println(mane+"/"+salary+"/"+promotion);
		
		
		//자원 반납(close)
		dis.close();
	}

}

