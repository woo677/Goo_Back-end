package chap05.ex12;

public class Computer {
	
	private boolean power;
	private int panSpeed;
	private int temp;
	
	/*
	 * boolean outputPower() { power = true; return power; }
	 */
	
	public boolean isPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
		
		if (power) {
			panSpeed = 50;
			temp = 60;
		} else {
			panSpeed = 0;
			temp = 20;
		}
		
	}
	
	public int getPanSpeed() {
		return panSpeed;
	}
	
	public void setPanSpeed(int panSpeed) {
		this.panSpeed = panSpeed;
		//(온도= 110 - 팬스피트)
		this.temp = 110 - panSpeed;
	}
	
	public int getTemp() {
		return temp;
	}
	
}
