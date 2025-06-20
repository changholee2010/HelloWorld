package com.yedam;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1) 메소드의 선언.
 * 2) 매개변수.
 * 3) 반환유형.
 */
public class Calculator {
	// 필드.
	// 생성자.
	// 메소드.
	String printStar(int times, String shape) { // 매개변수(times)
		String str = "";
		for (int i = 1; i <= times; i++) {
//			System.out.println(shape);
			str += shape + "\n";
		}
		return str;
	} // end of printStar.

	// 메소드 오버로딩.
	int add(int num1, int num2) {
		return num1 + num2;
	}

	double add(int str1, int str2, int str3) {
		return str1 + str2 + str3;
	}

	double add(double num1, double num2) {
		return num1 + num2;
	}

	// 정수배열을 매개값으로 받는 add. 반환유형은 double.
	double add(int[] ary) {
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		// int -> double 타입으로 자동형번환.
		return sum;
	}

	// 배열에서 point가 제일 큰 사람을 찾아서 반환.
	Member getMaxPoint(Member[] memberArray) {
		// 결과값.
		Member max = null; // 아이디, 이름, 연락처, 포인트.
		int maxPoint = 0; // 포인트를 비교하기 위한 변수.
		for (int i = 0; i < memberArray.length; i++) {
			Member temp = memberArray[i];
			if (maxPoint < temp.getPoint()) {
				maxPoint = temp.getPoint(); // 비교용도.
				max = temp; // 최대포인트를 가진 회원의 정보 max저장.
			}
		}
		return max;
	} // end of getMaxPoint.

}
