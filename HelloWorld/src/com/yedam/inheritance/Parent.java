package com.yedam.inheritance;

/*
 * Parent: 부모클래스.
 */

public class Parent extends Object {
	String field1; // 필드.

	// 생성자.
	// 개발자가 생성자에 대한 정의가 없으면 컴파일러가 기본생성자 생성.
	// 개발자가 생성자를 정의하면 기본생성자는 없음.
	public Parent() {

	}

	public Parent(String field1) {
		super(); // super는 부모를 가리킴.
		this.field1 = field1;
	}

	void method1() {
		System.out.println("method1 호출.");
	}

	@Override
	public String toString() {
		return "field1의 값은 " + field1;
	}
}
