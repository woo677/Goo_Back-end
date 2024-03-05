package chap08.ex02;

import java.util.Arrays;

public class StringArr {

	public static void main(String[] args) {//문자열 == 문자 배열
		
		String str = "asdfg";
		
		String strResult;
		int intResult;
		char chResult;
		
		//문자열의 길이(알아내는 법ㄴ)
		intResult = str.length();
		System.out.println(intResult);

		//특정 인덱스의 값 가져오기
		chResult = str.charAt(2);//문자열 중간 내용을 쏙 뺄수 있다
		System.out.println(chResult);
		
		//문자열 -> 캐릭터 배열
		char[] arr = str.toCharArray();
		System.out.println(arr[2]);
		
		//특정 문자가 어느 인덱스에 있는지 확이
		str = "abcdabcdabcdabcd";
		
		//a 를 찾아 보자 (메서드 오버로드) //앞에서부터 찾는다(단점 : 1개 박에 못 찾는다)
		intResult = str.indexOf("a"); //인덱스 오브()
		System.out.println("a의 위치는 " + intResult);
		
		//이번에는 뒤에서 부터 찾는다 //인덱스 오브는 위치를 잡아줄수 있는데 여러개를 찿을수가 없다
		intResult = str.lastIndexOf("a");
		System.out.println("a의 위치는 " + intResult);

		
		System.out.println();
		//모든 c를 다 찾고 싶다면?
		
		
		//1.배열 활용
		arr = str.toCharArray(); //향상된 for문은 배열의 위치를 찾을수 없다
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]=='c') {
				System.out.println("c 의 위치 : "+i+"\n");
			}
		}
		
		
		//2.indexOF 오버로드 메서드 활용
		intResult =0;
		
		while (intResult >-1) {
			intResult = str.indexOf("c", intResult); //indexOf는 특정문자(지정한문지)를 문자열 앞에서 부터 차례데로 읽어 문자의 인덱스 값을 반환하고 찾지 못할경우 -1
			System.out.println("c의 위치 : "+intResult+" (1번 방법)");
//			if (intResult>-1) {
//				intResult++;
//				}
		}
		
		intResult =0;
	
		while (intResult >-1) {
			intResult = str.indexOf("c", intResult);
			System.out.println("c의 위치 : "+intResult+" (2번 방법)");
			if (intResult==-1) {
				break;
			}
			intResult++;
		}
		
		//쫌 무식하다
		/*
		 * intResult = str.indexOf("c",intResult); //-1이 나오면 끝이라는 거다
		 * System.out.println(intResult); intResult++;
		 * 
		 * intResult = str.indexOf("c",intResult); System.out.println(intResult);
		 * intResult++;
		 * 
		 * intResult = str.indexOf("c",intResult); System.out.println(intResult);
		 * intResult++;
		 * 
		 * intResult = str.indexOf("c",intResult); System.out.println(intResult);
		 * intResult++;
		 * 
		 * intResult = str.indexOf("c",intResult); System.out.println(intResult);
		 * intResult++;
		 * 
		 * intResult = str.indexOf("c",intResult); System.out.println(intResult);
		 */
			
			
		//문자열 잘라내기
		str = "0123456789";
		strResult = str.substring(3); //(서브스프링)n부터 끝까지 모여준다
		System.out.println(strResult);
			
		strResult = str.substring(1,5);//n번 인덱스 부터 보여주고, n번 인덱스 부터는 버려
		System.out.println(strResult);
			
		//특정 문자를 기준으로 잘라내기(쪼게준다)
		str = "a/b/c/d/e/f/g";
		String[] list = str.split("/");//(스플릿)(쪼게준다)
		System.out.println(Arrays.toString(list)); //(Arrays.toString) 배열은 class 이기 때문이다 배열을 출력할때 쓴다
		
		list = str.split(""); //구분자를 않넣으면 어떻게 되는가? -> 한자 한자 가 끓어 놓는다
		System.out.println(Arrays.toString(list));
		
		

}
}

