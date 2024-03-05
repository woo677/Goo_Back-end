package chap10.ex02;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//File(java.io.File) 객체는 파일과 디렉토리에 관련된 모든 기능을 가지고 있다
		File dir = new File("C:/img/temp");  //File명령어로 원하는 경로를 불러온 다음 new로 새로만든 dir변수에 넣는다 
				
		
		//1.폴더가 존재하지 않으면 생성 하기
//		System.err.println(dir.exists());
		if (dir.exists()== false) { // (exists)파일이 존재하는지 존재하지 않는지를 알려준다
			System.out.println("폴더 없음 생성 시작");
			dir.mkdirs();//(mkdirs)폴더를 생성 할때 쓰인다
		}
		
		//2.파일 생성 하기
		File file = new File("C:/img/temp/text.txt");
		file.createNewFile();//(createNewFile) 파일을 생성 할때 쓰인다
		
		//3.폴더 정보 알아보기
		dir = new File("c:/");
		
		
		//어떤 파일이 있는지?(이름나 알아보기) - 단점 : 파일과 폴더 이름을 다 알려 주는데 구분은 안 해 준다.(실실간 감시 하고  삭제 한다)
//		String[] fileNames = dir.list();
//		for (String name : fileNames) {
//			System.out.println(name);
//		}
		
		File[] files = dir.listFiles();//파일 새로 만들기 명령어를 
		for (File f: files) {
			String gubun = "[파일]";
			if (f.isDirectory()) {
				gubun = "[폴더]";
			}
			System.out.println(f.isDirectory()+""+f.getName()+""+f.length()+"byte");
		}
	}

}
