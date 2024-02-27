package Chap08.ex02;

public class StringUtils {

	public static void main(String[] args) {
		
		String str = "abcdefg";
		
		String strResult;
		int intResult;
		boolean boolResult;
		
		/*문자열 비교*/
		boolResult = "abc".equals(str);
		System.out.println("두 문자가 같은가?" +boolResult);
		
		/*특정 문자열 포함 여부*/
		boolResult = str.contains("c");
		System.out.println(str+"안에 c가 포함 되어 있는가?"+boolResult);
		
		
		/*문자열 교체*/
		strResult = str.replace("abc", "abc".toUpperCase());
		System.out.println(str+"=>"+strResult);
		
		
		/*앞뒤 공백 제거*/
		str = " 가나다라마바사 ";
		strResult = str.trim();
		System.out.println(str);
		System.out.println(strResult);
		
		/*문자열의 시작과 끝*/
		str = "[img]uploadFile.png";
		
		//[img] 로 시작 하는가? (start)
		boolResult = str.startsWith("[img]");
		System.out.println("[img] 로 시작 하는가? "+boolResult);
		
		// .png로 끝나는 가 ?(end..)
		boolResult = str.endsWith(".png");
		System.out.println(".png 로 끝나는가? "+boolResult);
		
		/*반복 repeat*/
		strResult = "*".repeat(6);
		System.out.println(strResult);
		
	}

}
