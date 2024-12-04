package com.yedam.api;

class Member {
	String id;
	int age;

	@Override
	public boolean equals(Object obj) {
//		return super.equals(obj); // Object.equals() 두 객체의 주소값을 비교.
		// id속성의 값이 동일하면 논리적으로 동등하다고 판단.
		if (obj instanceof Member) {
			Member m2 = (Member) obj;
			if (id.equals(m2.id) && age == m2.age) {
				return true;
			}
		}
		return false;
	}
}

public class ObjectExe {
	public static void main(String[] args) {
		Member m1 = new Member(); // m1은 Member 인스턴스의 주소값.
		m1.id = "user01";
		m1.age = 20;

		Member m2 = new Member();
		m2.id = "user01";
		m2.age = 20;

		System.out.println(m1 == m2); // 주소값을 비교.
		System.out.println(m1.equals(m2)); // equals 메소드 비교.
	}

}
