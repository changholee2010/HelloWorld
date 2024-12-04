package com.yedam.inheritance;

/*
 * Child: Parent 상속클래스.
 */
public class Child extends Parent {
	String field2; // 필드.

	// 생성자: 기본생성자를 생성. Child() => super();
//	public Child() {
//		super("");
//	}

	@Override // 부모의 메소드정의(반환값, 메소드이름, 매개값)
	void method1() {
		// 부모가진 메소드를 자식이 재정의.(메소드오버라이드)
		System.out.println("자식 method1 호출.");
	}

	void method2() {
		System.out.println("method2 호출.");
	}

	// toString() 오버라이딩.
	@Override
	public String toString() {
		return "Child [field2=" + field2 + "]";
	}

}
