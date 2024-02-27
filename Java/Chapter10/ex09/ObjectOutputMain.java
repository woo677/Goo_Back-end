package chap10.ex09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectOutputMain {

	public static void main(String[] args) {
				
		try {
			// 1. 주스트림 준비
			FileOutputStream fos = new FileOutputStream("C:/img/object.dat");
			// 2. 보조스 트림(속도 + 오브젝트 내보내기)
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			// 3. 쓰기
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "김지훈");
			map.put("phone", "0101234-1234");
			// map 형태 넣기
			oos.writeObject(map);			
			// array 형태 넣기
			oos.writeObject(new int[] {10,20,30,40,50});			
			// 기본 형태 넣기
			oos.writeUTF("기본 형태도 사용 가능");			
			// 클래스 객체 넣기
			oos.writeObject(new Sample());
			// 4. 자원반납(flush, close)
			oos.flush();
			oos.close();
			System.out.println("저장 완료");
		} catch (Exception e) {
			System.out.println("파일 저장중 문제 발생");
			e.printStackTrace();			
		}	

	}

	
	
	
	
	
	
	
	
	
	
}
