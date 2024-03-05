package chap07.ex03;

public interface MouseEvent {

	//interface는 추상메서드가 기본 메서드(abstract을 빼도 상관이 없다)
	public void click(int button);
	
	public void dvlclick(int button);
	
	public Double[] move();//마우스의 좌표를 알려준다
	
	
	//1.8부터 가능해 진는 것
	//default 메서드(일반 메서드로 인식 하게 만들어 준다)
	public default void wheel(int i) {
		if(i==1) {
			System.out.println("윗방향으로 스크롤");
		}else {
			System.out.println("아래방향으로 스크롤");
		}
	}
	
	
	//static 메서드
	public static void setDpi(int dpi) {
		System.out.println("감도 조절"+dpi);
	}
}
