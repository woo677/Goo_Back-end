package Chaper07ex03;

public interface MouseEvent {

	
	//interface 는 추상메서드가 기본 메서드 
	public abstract void click(int button);
	
	public void dblclick(int button);
	
	public Double[] move();

	//1.8부터 가능해 지는 것
	//default 메서드 ->추상메서드가 아니라 일반메서드로 인식(몸통)시키기위해 
	public default void wheel(int i) {
		if(i==1) {
			System.out.println("윗방향으로 스크롤");
		}else {
			System.out.println("아랫방향으로 스크롤");
		}
	}
	
	
	//static 메서드
	public static void setDpi(int dpi) {
		System.out.println("감도 조절:"+dpi);
	}





}
