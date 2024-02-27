package chap10.ex09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Map;

public class ObjectInputMain {

	public static void main(String[] args) throws Exception {
		
		// 1. 주스트림 준비
		FileInputStream fis = new FileInputStream("C:/img/object.dat");
				
		// 2. 보조스트림 준비(버퍼,오브젝트)
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		// 3. 읽기
		Map<String, String> map = (Map<String, String>) ois.readObject();// map
		int[] arr = (int[]) ois.readObject();// array
		String str = ois.readUTF();// String
		Sample sample = (Sample) ois.readObject();// class

		System.out.println(map);
		System.out.println(Arrays.toString(arr));
		System.out.println(str);
		System.out.println(sample.team+" "+sample.num+" "+sample.job);
		System.out.println(sample.method());			
		
		// 4. 자원반납(close)
		ois.close();
	}

}






