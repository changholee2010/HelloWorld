package com.yedam.interfaces;

public class InterfaceExe {
	public static void main(String[] args) {
		final int num = 10; // 상수. const
//		num = 30;
		// 인터페이스의 변수에 구현클래스의 인스턴스를 할당.
//		CellPhone phone = new SmartPhone();
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.turnOff();

		rc = new Radio();
		rc.turnOn();
		rc.turnOff();
	}
}
