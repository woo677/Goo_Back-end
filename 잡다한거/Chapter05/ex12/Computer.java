package chap05.ex12;

public class Computer {
	
	private boolean power;
	private int panSpeed;
	private int temp;
	
	public boolean isPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
		
		if (power) { //파워를 커면 팬이 돌고 온도가 올라간다
			panSpeed =50;
			temp = 60;
		}else { // 끄면 팬이 멈추고 온도가 내려간
			panSpeed = 0;
			temp =20;
		}
	}
	
	public int getPanSpeed() {
		return panSpeed;
	}
	
	public void setPanSpeed(int panSpeed) {
		this.panSpeed = panSpeed;
		//우리끼리 정한 공식 (110 - 펜스피드 = 온도)
		this.temp = 110 - panSpeed;
	}
	
	public int getTemp() {
		return temp;
	}
	
	
}
