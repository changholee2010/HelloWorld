package com.yedam.condition;

import java.util.Scanner;

public class IfExe {

	public static void main(String[] args) {
		// 1 ~ 1000 사이의 임의의 값을 생성. randomValue = 567
		// 500입력하면 "입력값보다 큽니다", "입력값보다 작습니다"
		// "정답입니다" 프로그램 종료.
		// 시도한 회수.
		Scanner scn = new Scanner(System.in);
		int randomValue = (int) (Math.random() * 1000) + 1;
		int trial = 0; // 시도한 횟수
		while (true) {
			trial++; // 시도한 횟수 카운트.
			System.out.print("1 ~ 1000 사이의 값을 입력>> ");
			int num = Integer.parseInt(scn.nextLine());
			// 입력값과 임의의 생성값을 비교한다.
			if (randomValue == num) {
				System.out.println("정답입니다.");
				break; // 반복문 종료.
			}
			// 크거나 작거나 하면 계속 반복.
			if (randomValue > num) {
				System.out.println("입력값보다 큽니다.");
			} else {
				System.out.println("입력값보다 작습니다.");
			}
		} // end of while.
		System.out.printf("임의의 값은 %d입니다. 시도한 횟수: %d\n", randomValue, trial);
	}

	public static void test() {
		int score = 85;

		// if.
//		if (score >= 90) {
//			System.out.println("A학점");
//		} else if (score >= 80) {
//			System.out.println("B학점");
//		} else if (score >= 70) {
//			System.out.println("C학점");
//		} else {
//			System.out.println("불합격");
//		}
		score = score / 10; // 9
		switch (score) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
		} // end of switch.

	}
}
