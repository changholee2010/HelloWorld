package com.yedam.inheritance;

/*
 * CellPhone 을 상속.
 */
public class SmartPhone extends CellPhone {
	int channel;
	// 생성자.
	public SmartPhone() {}
	public SmartPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
	}
	// 메소드.
	void watch() {
		System.out.println(channel + "을 시청합니다.");
	}
	// 부모클래스의 기능을 자식클래스 재정의(overriding)
	@Override
	public void powerOn() {
		System.out.println("😍전원을 켭니다👌");
	}
	@Override
	public void powerOff() {
		System.out.println("😍전원을 끕니다👌");
	}
	@Override
	public String toString() {
		return super.toString() + " channel=" + channel + "]";
	}
	
}
