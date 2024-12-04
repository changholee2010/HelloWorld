package com.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.field1 = "부모필드";
		p1.method1();
//		p1.method2(); // 자식클래스의 멤버는 사용불가.
		System.out.println(p1.toString());

		Child c1 = new Child(); // Parent 클래스의 필드,생성자,메소드 상속.
		c1.field1 = "자식필드";
		c1.method1();
		c1.field2 = "자식필드2";
		c1.method2();
		System.out.println(c1.toString());
	}
}
