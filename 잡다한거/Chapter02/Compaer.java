
public class Compaer {

	public static void main(String[] args) {
		
		// = 대입 연산자로 사용중
		int v1=1;
		double v2=1.0;
		int v3=4;
		//문자열은 여러 방법으로 선언 할 수 있다.
		String v4 ="JAVA";
		String v5 =new String("JAVA");
		
		//비교 연산
		System.out.println(v1==v2);
		System.out.println(v1!=v2);
		System.out.println(v1<v3);
		System.out.println(v4==v5);
		System.out.println(v4.equals(v5));//문자열 비교는 반드시 equals로 해 주자!!
		
		
		String id = "admin";
		String pw = "pass";
		//입력받은 id와 pw가 각각 admin 과 pass 면 로그인 완료 시켜주자
		
		if (id.equals("admin")&& pw.equals("pass")) {
			System.out.println("login 되었습니다");
		}

	}

}
