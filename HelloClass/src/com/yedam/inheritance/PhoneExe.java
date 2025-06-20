package com.yedam.inheritance;

import com.yedam.Student;

public class PhoneExe {
	public static void main(String[] args) {

		// 부모클래스.
		CellPhone phone1 = new CellPhone();
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		System.out.println(phone1.toString());

		// 자식클래스.
		CellPhone phone2 = new SmartPhone();
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();

		SmartPhone phone3 = null;
		if (phone2 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone2; // Casting
			phone3.channel = 2;
			phone3.watch();
			System.out.println(phone3.toString());
		}

		// instanceof 메소드를 변환가능한지 체크.
		if (phone1 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone1;
			phone3.channel = 3;
			phone3.watch();
		}

	}
}
