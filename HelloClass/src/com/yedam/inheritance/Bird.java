package com.yedam.inheritance;

/*
 * 부모클래스: Animal(추상)
 */
public class Bird extends Animal {

	@Override
	public void sound() {
		// 부모클래스의 sound() 재정의 해야함.
		System.out.println("짹짹");
	}

}
