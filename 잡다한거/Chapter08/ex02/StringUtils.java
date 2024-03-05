package chap08.ex02;

public class StringUtils {

	public static void main(String[] args) {
		
		String str = "asdfe";
		
		String strResult;
		int intResult;
		boolean boolResult;
		
		
		/*문자열 비교*/
		boolResult = "asadf".equals(str);
		System.out.println("두 문자가 같은가 "+ boolResult);
		
		
		/* 특정 문자열 포함 여부*/
		boolResult = str.contains("c");//콘텐스
		System.out.println(str+ "안에 c가 포함 되어 있는가 " + boolResult);
		
		
//		문자열 교체
		strResult = str.replace("abc", "asdf".toUpperCase());//리플레이스 ,두업퍼케이스 소문자를 대문자로 만들어 준다
		System.out.println(str + "=>"+strResult);
		
		
//		앞뒤 공백 제거(로그인 할때 아이디를 복사 할때 공백이 석여 올때)
		str = "가나다라마바";
		strResult = str.trim();//트린이 /
		System.out.println(str);
		System.out.println(strResult);
		
		
//		문자열의 시작과 끝
		str = "[img]uploadFile.png"; // 뭔가를 비교할때 사용을 한다

		//[img]로 시작 하는가(start...)
		boolResult = str.startsWith("[img]");//프랙픽스서피스   //toffset 중간부터 볼수있다(배열을 기준으로 한다)
//		System.out.println(str);
		System.out.println("[img] 로 시작 하는가 "+boolResult);
		
		//.png로 끝나는 가(end...)
		boolResult = str.endsWith(".png");
//		System.out.println(str);
		System.out.println(".png 로 끝나는 가?"+boolResult);
		
		
		//반복 repeat(리핏) 이름 중간에 *이라고 나올때 쓴다
		strResult = "*".repeat(6);//숫자를 넣으면 그 숫자만큼 반복
		System.out.println(strResult);
	}

}
