package chap10.ex07;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInput {

	public static void main(String[] args) throws Exception {
		
		// 읽어올 위치 지정 + 파일객체 + 주스트림
		FileInputStream fis = new FileInputStream("C:/img/temp/data.dat");		
		// 보조스트림(java 고유데이터 사용)
		DataInputStream dis = new DataInputStream(fis);
				
		// 읽어오기(쓴 순서 그대로 읽어와야 한다)
		String name = dis.readUTF();
		int salary = dis.readInt();
		boolean promotion = dis.readBoolean();
		System.out.println(name+" / "+salary+" / "+promotion);
		// 자원반납(close)
		dis.close();
		
	}

}
