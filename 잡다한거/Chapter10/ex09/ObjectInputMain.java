package chap10.ex09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Map;

public class ObjectInputMain {

	public static void main(String[] args) throws Exception {
		// 1.주스트림 준비
		FileInputStream fis = new FileInputStream("C:/img/object.det");//어디 있는 파일을 읽어올떄 쓰는 코드 
		
		//2.보조스트림 준비(버퍼,오브젝트)
		BufferedInputStream bis = new BufferedInputStream(fis);//읽어 오는 속도를 높여주는 코
		ObjectInputStream ois = new ObjectInputStream(bis); // 
		
		//3.읽기
		//map
		Map<String, String> map = (Map<String,String>) ois.readObject();
		//array
		int[] arr = (int[]) ois.readObject();
		//String
		String str = ois.readUTF();
		//class
		Sample sample = (Sample) ois.readObject();
		
		System.out.println(map);
		System.out.println(Arrays.toString(arr));
		System.out.println(str);
		System.out.println(sample.team+""+sample.num+""+sample.job);
		System.out.println(sample.method());
		
		//4.자원반납(close)
		ois.close();

	}

}
