
public class Casting {

	public static void main(String[] args) {
		
		//명시적 형변환
		char charValue;
		int intValue;
		long longValue;
		float floatValue;
		double doubleValue;
		
		intValue = 74;
		charValue = (char) intValue;//강제 형변환
		System.out.println(charValue);
		
		longValue = 500;
		doubleValue = 3.14;
		
		//long ->int
		intValue =(int)longValue;
		System.out.println(intValue);
//		double -> float
		floatValue = (float)doubleValue;
		System.out.println(floatValue);
	}

}
