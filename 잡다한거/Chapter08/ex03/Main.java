package chap08.ex03;

public class Main {

	public static void main(String[] args) {
		
		//문자열 누적합
		
		String str = "문자열을";
		str +=" 추가한다";
		str +=" 객체가 증가 한다";
		System.out.println(str);
		
		//StringBuffer(다수유저X) & StringBuilder(다수유저O)
		StringBuffer buffer = new StringBuffer("문자열을");
		buffer.append(" 추가하면");
		buffer.append(" 객체 크기가 증가 한다");
		System.out.println(buffer);
		
		str = buffer.toString(); //문자열화 시킬수 있다
		System.out.println(str);
		
		str = buffer.reverse().toString(); //문자열을 뒤집는다
		
		System.out.println(str);
	}

}
