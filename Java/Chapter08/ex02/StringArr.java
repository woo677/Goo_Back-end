package Chap08.ex02;

import java.util.Arrays;

public class StringArr {

	public static void main(String[] args) { //문자열 == 문자 배열 
		

		String str = "abcdefg";
		
		String strResult;
		int intResult;
		char chResult;
	
		// 문자열의 길이 
		intResult = str.length();
		System.out.println(intResult);
		
		// 특정 인덱스의 값 가져오기
		chResult = str.charAt(2);
		System.out.println(chResult);
		
		//문자열 -> 캐릭터 배열
		char[] arr = str.toCharArray();
		System.out.println(arr[2]);

		//특정 문자가 어느 인덱스에 있는지 확인 
		str = "abcdabcdabcd";
	
		//a를 찾아 보자 (1개 밖에 못 찾는다.)
		intResult = str.indexOf("a");
		System.out.println("a의 위치는 :"+intResult);
		
		// 이번에는 뒤에서 부터 찾는다. 
		str.lastIndexOf("a");
		System.out.println("a의 위치는 : "+intResult);
		
		//모든 c를 다 찾고 싶다면?
		//1. 배열 활용
		arr = str.toCharArray();
		for (int i = 0; i<arr.length; i++) {
			if(arr[i] == 'c')
				System.out.println("c의 위치:"+i);
		
		
 //2.1 내일 오면 다시 확인 ㅁㅁ
		//2. indexOf 메서드 오버로드 활용(코드리뷰)
		intResult = 0;	
																							
		while(intResult>-1){	//c=숫자를 찾음 //intResult =순서를 말함							// 위의 내용 생략
			intResult = str.indexOf("c",intResult);           // 이 과정을 반복해서 더이상찾는값이 없을때 
																		//-1이 나타났을때 조건을 만족하지못하므로 와일문이 종료되게 됩니다. 
																					//while문은 조건문의 값이 false가 되면 코드 블럭을 실행하지 않고 종료한다. 
			if(intResult==-1) {	
				break;
			}else {
				System.out.println("c의 위치: "+intResult);
				intResult++;
			}
		}
			//문자열 잘라내기
			str = "0123456789"
					
					;
			strResult = str.substring(3);     // 3번 인덱스부터 끝까지  다 보여주란 뜻
			System.out.println(strResult);
		
			strResult = str.substring(1,5);  //1번 인덱스부터 보여주고, 5번 인덱스부터는 버려    					
			System.out.println(strResult);
			
			
			//특정 문자를 기준으로 잘라내기 
			str = "a/b/c/d/e/f/g";
			String[]list = str.split("/");
			System.out.println(Arrays.toString(list));
			
			
			list = str.split(""); //구분자를 안넣으면 어떻게 되는가? ->한자 한자 다 끊어 놓는다.
			System.out.println(Arrays.toString(list));
		 
		}
}

		

}
			
		
		
	



