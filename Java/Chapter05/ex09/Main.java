// 57.

package chap05.ex09;

public class Main {

	public static void main(String[] args) {
		Sub sub = new Sub();
		
		// field와 multi: static이 없으므로 객체화해서 사용 가능. 복사본 sub에서 사용 가능.
		int result = sub.field;
		System.out.println("result: "+result);
		
		result= sub.multi(3, 4);
		System.out.println("result: "+result);
		
		// static이 붙어 있으면 복사가 안되므로 직접 가져와야 한다.
		// 호출 시 클래스 명을 직접 입력해야 한다. 복사본에서 찾는 것이 아니라.
		result = Sub.sFiled;
		System.out.println("result: "+result);		
		
		result= Sub.plus(10, 5);
		System.out.println("result: "+result);
		
		
		// 아래같이 쓰면 원래 안되지만... 이렇게 쓰는 사람이 너무 많아서 열어주는 것
		// 하지만 이렇게 쓰면 안된다고 경고하는 거다.
		// 즉, sub(복제본)이 Sub(원본)을 거쳐서 사용하는 거다. 
		
		result= sub.sFiled;
		System.out.println(result);
		result= sub.minus(100, 5);
		System.out.println(result);
		
		Sub sub1= new Sub();
		Sub sub2= new Sub();
		Sub sub3= new Sub();
		
		System.out.println();
		
		sub1.field = 100;
		System.out.println(sub1.field);
		System.out.println(sub2.field);
		System.out.println(sub3.field);

		
		Sub.sFiled = 10000;		 // 원본에 변경을 하면 모두 영향 받는다.
		System.out.println(sub1.sFiled);
		System.out.println(sub2.sFiled);
		System.out.println(sub3.sFiled);
		
		
		
	}

}
