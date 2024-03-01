package chap08.ex04;

public class Main {

	//RuntimeException : 실행 예외 - 실행해 봐야 그때 알게 되는 예외
	public static void main(String[] args) {
		
		/* NullpointExceptoin : null 인 상태의 값에 무언가를 하려 할 경우 *************
		String data = null;
		data.toString();
		*/
		
		/* ArrayIndexOutofException : 배열의 크기를 벗어나서 무언가를 하려할 경우
		String[] arr = new String[2];
		arr[0] = "data1";
		arr[1] = "data2";
		arr[2] = "data3"; // 없는 index 에 무언가를 하려고 했다!
		*/
		
		/* ClassCastException : 부모형태로 들어간 객체가 다시 되돌아 올때 잘못 되돌아온 경우
		Object val = 1234; // Object 는 java 의 모든것이 다 들어간다.
		int intVal = (int) val; // 본래 형태로 되돌아 가는건 문제 없음
		String strVal = (String) val; // 문자열로 되돌아 가려고 한다면?
		*/
		
		// NumberFormatExcption : 숫자형태가 아닌 문자열을 숫자로 변경 하려고 할 경우
		String data = "1234";
		int intVal;
		
		intVal = Integer.parseInt(data);
		System.out.println(intVal); // "1234" -> 1234
		
		intVal = Integer.parseInt("1ab3"); // ?
		System.out.println(intVal);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
