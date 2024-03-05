package chap10.ex10;

import java.io.FileInputStream;
import java.util.Properties;

public class PropInput {

	public static void main(String[] args) throws Exception {
		
		//1.스트림 준비
		FileInputStream fis = new FileInputStream("src/chap10/ex10/profile.properties");
		
		//2.Properties 불러오기
		Properties prop = new Properties();
		prop.load(fis);//스트림으로 읽어온 값이 Properties 에 저장
		
		//3.읽기
		for (Object key : prop.keySet()) {
			System.out.println(key+""+prop.get(key));
		}
		//4.자원 반납
		fis.close();
	}

}
