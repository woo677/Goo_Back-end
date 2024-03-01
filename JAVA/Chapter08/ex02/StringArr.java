package chap08.ex02;

import java.util.Arrays;

public class StringArr {

	public static void main(String[] args) { // 문자열 == 문자 배열
		
		String str = "abcdefg";
		
		String strResult;
		int intResult;
		char chResult;
		
		// 문자열의 길이
		intResult =  str.length();
		System.out.println(intResult);
		
		// 특정 인덱스의 값 가져오기
		chResult = str.charAt(2);
		System.out.println(chResult);
		
		// 문자열 -> 캐릭터 배열
		char[] arr = str.toCharArray();
		System.out.println(arr[2]);
		
		// 특정 문자가 어느 인덱스에 있는지 확인
		str = "abcdabcdabcd";
		
		// a 를 찾아 보자(1개 밖에 못 찾는다.)
		intResult = str.indexOf("a");
		System.out.println("a의 위치는 : "+intResult);
		
		// 이번에는 뒤에서 부터 찾는다.
		intResult = str.lastIndexOf("a");
		System.out.println("a의 위치는 : "+intResult);
		
		// 모든 c 를 다 찾고 싶다면?
		/* 1. 배열 활용
		arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 'c') {
				System.out.println("c 의 위치 : "+i);
			}
		}
		*/
		
		// 2. indexOf 오버로드 메서드 활용(코드리뷰)
		intResult = 0;		
		while(intResult>-1){
			intResult =  str.indexOf("c", intResult);		
			if(intResult>-1) {
				System.out.println("c 의 위치 : "+intResult);			
				intResult++;
			}
		}		
		
		// 문자열 잘라내기
		str = "0123456789";
		strResult = str.substring(3); // 3번 인덱스 부터 끝까지
		System.out.println(strResult);
		
		strResult = str.substring(1, 5); // 1번 인덱스 부터 보여주고, 5번 인덱스 부터는 버려
		System.out.println(strResult);
		
		// 특정 문자를 기준으로 잘라내기
		str = "a/b/c/d/e/f/g";
		String[] list = str.split("/");
		System.out.println(Arrays.toString(list));
		
		list = str.split(""); // 구분자를 않넣으면 어떻게 되는가? -> 한자 한자 다 끊어 놓는다.
		System.out.println(Arrays.toString(list));		
		
		
		
		
		
		
		
		
		
		
		
	}

}
