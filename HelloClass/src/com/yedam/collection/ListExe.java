package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스를 사용해서 객체를 관리.
 * 순서를 가지고 중복된 값 가능.
 */

public class ListExe {
	public static void main(String[] args) {
		// 10 ~ 100 점 점수를 임의의 값으로 생성. 정수10개 생성.
		List<Student> numbers = new ArrayList<>();
		for (int i = 1; i <= 10; i++) { // 10번 생성.
			int score = (int) (Math.random() * 91) + 10;
			numbers.add(new Student(1000 + i, score));
		}
		// 10개의 점수의 합, 평균 출력.
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i).getScore(); // Student(no,score)
		}
		avg = 1.0 * sum / numbers.size();
		System.out.printf("점수의 합: %d, 평균: %.1f\n", sum, avg);

	}

	// 저장2.
	public static void exe2() {
		List<Member> members = new ArrayList<>();
		Member member = new Member("김홍동", 20);

		members.add(new Member("홍길동", 10));
		members.add(member);
		members.add(new Member("김홍도", 30));

		// 삭제.
//		members.remove(member);

		String search = "김홍동";
		// 삭제.
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}
		// 목록 출력.
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString());
		}

	}

	// 저장1.
	public static void exe1() {
//		int[] ary = {10, 20, 30.4};
		// 인터페이스 - 구현클래스
		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add(new String("Hello"));

		list.add(1, "20"); // 위치지정.

		// 삭제.
		list.remove(0);

		// 변경.
		list.set(1, "World");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

//		for (String item : list) {
//			System.out.println(item);
//		}

	}
}
