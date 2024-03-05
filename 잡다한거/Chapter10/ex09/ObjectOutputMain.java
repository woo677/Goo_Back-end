package chap10.ex09;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectOutputMain {

	public static void main(String[] args) throws Exception {

		try {
//			1.내보낼 위치 선정 +파일객체+주스트림
			FileOutputStream fos = new FileOutputStream("C:/img/object.dat");
			
//			2.보조스트림 (속도+오브젝트 내보내기)
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
//			3.쓰기
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "정민우");
			map.put("phone","122001-121205");
			
			//map 형태 넣기
			oos.writeObject(map);
			
			//array 형태 넣기
			oos.writeObject(new int[] {10,20,30,40,50});
			
			//기본 형태 넣기
			oos.writeUTF("기본 형태도 사용 가능");
			
			//클리스 객체 넣기
			oos.writeObject(new Sample());
			
//			4.반납하기(flush,close)
			oos.flush();
			oos.close();
			System.out.println("저장완료");
			
		} catch (Exception e) {
			System.out.println("저장중에 문제가 발생 했습니다");
			e.printStackTrace();
		}
		
		
		
	}

}
