package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {
		// 배열[여러건저장] => 컬렉션(1.List 2.Set 3.Map)
		int[] ary = new int[5];
		// 확장된 for.
		for (int num : ary) {
			System.out.println(num);
		}

		// Set컬렉션은 저장순서X, 중복된 값X
		Set<Integer> set = new HashSet<Integer>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(10);

		// 선언하는 클래스. Member
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 10));
		members.add(new Member("김민석", 12));
		members.add(new Member("홍길동", 10));

		for (Member num : members) {
			System.out.println(num.toString());
		}
	}

	public static void exe1() {
		int num1 = 10, num2 = 10;
		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1.equals(str2));

		Member mem1 = new Member(); // 인스턴스
		mem1.memberName = "홍길동";
		mem1.age = 10;

		Member mem2 = new Member(); // 주소 비교.
		mem2.memberName = "홍길동";
		mem2.age = 10;

		System.out.println(mem1.equals(mem2));
	}
}
