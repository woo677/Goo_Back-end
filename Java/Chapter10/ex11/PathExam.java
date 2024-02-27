package chap10.ex11;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExam {

	public static void main(String[] args) {
		// 경로 특화
		// java nio 는 대부분 static 멤버로 구성되어 있다.
		Path path = Paths.get("C:/img/high.gif");
		System.out.println("파일 이름 : "+path.getFileName());
		System.out.println("부모 폴더 : "+path.getParent().getFileName());
		System.out.println("루트 : "+path.getRoot());

	}

}
