package chap10.ex07;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataOutput {
	//자바의 고유 데이터를 저장하는 위해서는 dat 확장자를 사용해야한다 (꼭 아니면 파일이 깨진다) 
	public static void main(String[] args) throws Exception {
//		1.내보낼 파일 위치지정 + 파일객체 + 주스스트림 준비
		FileOutputStream fos = new FileOutputStream("C:/img/temp/data.dat");
		
//		2.보조 스트림 준비(속도 UP +자바 고유 데이터 타입 저장)
		BufferedOutputStream bos = new BufferedOutputStream(fos);// fos가 bos에 탑승
		DataOutputStream dos = new DataOutputStream(bos);//fos가 dos에 탑승
		
//		3.내보내기
		dos.writeUTF("정민우");
		dos.writeInt(900000000);
		dos.writeBoolean(false);
		
//		4.자원 반납(flush,close)
		dos.flush();
		dos.close();

	}

}
