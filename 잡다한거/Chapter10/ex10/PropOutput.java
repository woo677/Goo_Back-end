package chap10.ex10;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropOutput {

	public static void main(String[] args) throws Exception {
		
		//1.properties 객체에 데이터 저장
		Properties prop = new Properties();
		prop.put("id","asdf");
		prop.put("pass","1234");
		prop.put("name","kdidkf");
		prop.put("email","diojf@email.ocm");
		
		//2.주스트임 준비 + 보조스트림(선택)
		FileOutputStream fos = new FileOutputStream("src/chap10/ex10/profile.properties");
		//3.저장
		prop.store(fos, "simple comment");//내보낼 스트림,주석(한글은 다 깨진다)
		//4.자원 반납
		fos.close();

	}

}
