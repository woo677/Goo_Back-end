package chap08.ex06;

public class Main_기본캐취 {

	public static void main(String[] args) {
		
		String[] arr= new String[2];
		
		//1.귀찮으면 다 넣어도 됨
		//예외에 따라서 각각 다른 처리를 해 줄 수 있다
		//너무많은 catch를 만들어야한다
		try {
			arr[0] = "12345";
			arr[1] = "a2345";
			arr[2] = "56789";//ArrayIndexOutOfBoundsExceptio
			
			int val1 = Integer.parseInt(arr[0]);
			int val2 = Integer.parseInt(arr[1]);//NumberFormatException
			
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스를 초과 하였습니다");
		}catch (NumberFormatException e) {
			System.out.println("데이터에 문자가 섞여 있습니다");
		}finally {
			System.out.println("종료");
		}
		
//----------------------------------------------------------------------------------------------------
		
		//1.문제가 있는 것들만 넣어도 됨
		arr[0] = "12345";
		
		int val1 = Integer.parseInt(arr[0]);
	try {
		arr[1] = "a2345";
		arr[2] = "56789";//ArrayIndexOutOfBoundsExceptio
		
		int val2 = Integer.parseInt(arr[1]);//NumberFormatException
		
		
	}catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("배열 인덱스를 초과 하였습니다");
	}catch (NumberFormatException e) {
		System.out.println("데이터에 문자가 섞여 있습니다");
	}finally {
		System.out.println("종료");
	}

	}

}
