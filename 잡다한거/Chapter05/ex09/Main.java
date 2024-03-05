package chap05.ex09;

public class Main {

	public static void main(String[] args) {
		
		//객체화
		Sub sub = new Sub();
		
		//field 와 multi 는 static이 없으므로 객체화 해서 사용 가
		int result = sub.field;
		System.out.println("result : "+result);

		result = sub.minus(3, 4);
		System.out.println("result : "+result);
		
		//static 이 븥어 있으면 복사가 안되므로 직접 가져 와야 한다
		result = sub.sField;
		System.out.println("result : "+result);

		result = sub.plus(10,5);
		System.out.println("result : "+result);
		
		//아래같이 쓰면 원래 안되지만... 이렇게 쓰는 사람이 너무 많아서 열어주는 것
		//하지만 이렇게 쓰면 안된다고 경고 하는 거다.
		result = sub.sField;
		System.out.println(result);
		result = sub.minus(100, 5);
		System.out.println(result);
		
		Sub sub1=new Sub();
		Sub sub2=new Sub();
		Sub sub3=new Sub();
		
		sub1.field=100;//복사본에 장난 쳐도 다른사람은 영항 받지 않음
		System.out.println(sub1.field);
		System.out.println(sub2.field);
		System.out.println(sub3.field);
		
		Sub.sField=10000; //원본에 변경을 하면 모두 영향 받을 수 있다
		System.out.println(sub1.sField);
		System.out.println(sub2.sField);
		System.out.println(sub3.sField);
		
	}

}
