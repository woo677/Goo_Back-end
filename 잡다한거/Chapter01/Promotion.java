
public class Promotion {

	public static void main(String[] args) {
		//작은거에서 큰걸로 갈땐 묵시적 형변황()
		//작은잔에서 큰잔으로 옮길때 당연히 안 흘릴테니 확인이 필요 없다
		
		byte byteValue;
		char charValue = 'a';
		int intValue= 0;
		long longValue;
		float floatValue;
		double doubleValue;
		
		
		//묵시적 형변황
		//byet <int
		byteValue=10;
		intValue =byteValue;//int가 더 크기 때문에 문제가 없다 
		
		//char < int
		intValue= charValue;//97 -> 글자를 저장하때 아스키코드로 저장한다(각 문자의 번호가 공통 규격으로 정해져 있다.)
		System.out.println(intValue);
		
		//int<long
		longValue = intValue;
		//float< double
		floatValue = 0.1f;
		doubleValue = floatValue;
	}

}
