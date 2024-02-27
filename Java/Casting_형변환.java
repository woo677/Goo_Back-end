// 4. Castion 형변환

public class Casting_형변환 {

	public static void main(String[] args) {
		
		char charValue;
		int intValue;
		long longValue;
		float floatValue;
		double doubleValue;
		
		intValue = 74;
		charValue = (char)intValue;	// 다운캐스팅
		System.out.println(charValue);
		
		longValue = 500;
		doubleValue = 3.14;
		
		// long -> int 변환
		intValue = (int)longValue;
		// double -> float 변환
		floatValue = (float)doubleValue;
		
		System.out.println(intValue);
		System.out.println(floatValue);
		
	}

}
