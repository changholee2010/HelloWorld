package com.yedam;

import java.util.Scanner;

public class JSExe {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;

		String str1 = new String("Hello");
		String str2 = new String("Hello");

		// "30" vs. 30
		String str3 = "30";
		int num3 = 30;

		int num4 = Integer.parseInt(str3); // 문자열숫자

		// 문자열을 비교할 경우에는 equals 사용.
//		System.out.println(str1.equals(str2));
		test5();

	} // end of main.

	public static void test5() {
		// printf("형식문자열", 값1, 값2...)
		System.out.printf("%s %.2f\t", "문자", 30.3);
		System.out.println("");
		// "홍길동", 100, 23.9

		// 안녕하세요. 이창호입니다.
		// 나이는 20세입니다.
		// 몸무게는 67.8입니다.
		String formatStr = "안녕하세요. %s입니다.\n";
		formatStr += "나이는 %d세입니다.\n";
		formatStr += "몸무게는 %.1f입니다.\n";
		System.out.printf(formatStr, "이창호", 20, 67.8);
	}

	public static void test4() {
		Scanner scn = new Scanner(System.in);
		// 입력값을 누적할 변수.
		String str = "친구목록은 ";
		boolean isFirst = true;
		while (true) {
			System.out.println("친구이름 입력. 종료하려면 quit>>");
			String msg = scn.nextLine();
			// equals로 비교.
			if (msg.equals("quit")) {
				str += " 입니다";
				break;
			}
//			System.out.println("입력한 값은 " + msg);
			if (isFirst) {
				str += msg;
				isFirst = false;
			} else {
				str += ", " + msg;
			}
		}
		// 홍길동, 김민규, 최석영
		// 친구목록은 홍길동, 김민규, 최석영 입니다.
		System.out.println(str);
		System.out.println("end of prog.");
	} // end of test4.

	public static void test3() {
		// 사용자의 입력값을 읽어들이기.
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine(); // 입력값을 문자열형태로 반환.
			int score = Integer.parseInt(value); // 102030
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계:" + sum + ",평균: " + avg);

	} // end of test3.

	public static void test2() {

		// 변경된 부분.
		// 아무내용이나...
		// 임의의 수를 생성. 30 ~ 100사이의 임의의 값 생성.
		// 30 <= x < 101
		// 평균: 173.0*1.0/5.0 => 34.654
		// 1 <= x < 11
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			int result = (int) (Math.random() * 71) + 30;
			System.out.println(result);
			sum += result;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계:" + sum + ",평균: " + avg);

//		System.out.println(46.47);
	} // end of test2.

	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 누적.
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과: " + sum);
	} // end of test.

} // end of class.
