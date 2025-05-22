package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
		// 추상클래스는 인스턴스 생성 불가능.
//		Animal animal = new Animal();

		Animal a1 = new Bird();
		a1.breathe();
		a1.sound();

		a1 = new Fish();
		a1.breathe();
		a1.sound();

	}
}
