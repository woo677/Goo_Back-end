package chap10.ex11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExam {

	public static void main(String[] args) throws Exception {
		//java.io.file <-java io
		//java.nio.Files <- java nio(자바 파일만 쓴다)
		
		Path path= Paths.get("C:/img/high.gif");//(반드시 있어야함)File 를 쓰기 위해서는 Paths를 통해 결으로를 설정해야 한다
		System.out.println("디렉토리 여부 : "+Files.isDirectory(path));
		System.out.println("파일 여부 : " + Files.isRegularFile(path));
		System.out.println("마지막 수정 시간 : "+Files.getLastModifiedTime(path));
		System.out.println("파일 크기 : "+Files.size(path));
		System.out.println("소유자 : "+Files.getOwner(path));
		System.out.println("숨김 파일 여부 : "+Files.isHidden(path));
		System.out.println("읽기 가능 여부 : "+Files.isReadable(path));
		System.out.println("쓰기 가능 여부 : "+Files.isWritable(path));
		
		//폴더 생성
		Path dir = Paths.get("C:/img/nio");
		if (Files.notExists(dir)) {
			Files.createDirectory(dir);
		}

		//파일 생성
		Path file = Paths.get("C:/img/nio/textFile.txt");
		Files.createFile(file);
	}

}
