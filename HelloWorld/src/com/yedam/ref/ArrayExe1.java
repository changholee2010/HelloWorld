package com.yedam.ref;

public class ArrayExe1 {

	public static void main(String[] args) {
		// Math.random 활용해서 10 ~ 100 사이의 점수를 생성.
		// 학생 10명의 점수를 생성해서 학생점수의 평균을 구하고 최고점수 구하기.
		// scoreAry 변수명.
		int[] scoreAry = new int[10]; // 크기가 10인 배열 생성.
		// 학생10명의 임의점수 생성.
		for (int i = 0; i < scoreAry.length; i++) {
			scoreAry[i] = (int) (Math.random() * 91) + 10;
		}
		// 평균과 최대구하기.
		int sum = 0, max = 0;
		double avg = 0;
		for (int i = 0; i < scoreAry.length; i++) {
			sum += scoreAry[i]; // 합계.
			if (max < scoreAry[i]) { // 최대값.
				max = scoreAry[i];
			}
		}
		avg = 1.0 * sum / scoreAry.length;

		// 결과.
		System.out.printf("평균은 %.1f, 최고점수는 %d", avg, max);

	} // end of main.

	public static void test2() {
		// int배열 => intAry : 10, 17, 22, 31, 55, 24
		int[] intAry = { 10, 17, 22, 31, 55, 24 };
		int temp = 0;
		// 정렬.
		for (int j = 0; j < intAry.length - 1; j++) {
			for (int i = 0; i < intAry.length - 1; i++) {
				// 큰값기준으로 위치변경.
				if (intAry[i] > intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}
		// 출력.
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf(" i: %d, 값: %d\n", i, intAry[i]);
		}

		if (temp != 0) {
			return;
		}

		// 최고값.
		int max = 0;
		for (int i = 0; i < intAry.length; i++) {
			// max와 배열요소를 비교. 큰값을 max에 저장.
			if (max < intAry[i]) {
				max = intAry[i];
			}
		}
		System.out.printf("최대값은 %d\n", max);

		if (max != 0) {
			return;
		}
		// 합.
		int sum = 0;
		int cnt = 0; // 횟수.
//		for (int i = 0; i < intAry.length; i += 2) {
		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] % 2 == 0) {
				sum += intAry[i];
				cnt++;
				System.out.printf("sum: %d, i: %d, 값: %d\n", sum, i, intAry[i]);
			}
		}
		double avg = 1.0 * sum / cnt;
		System.out.printf("평균: %.1f\n", avg);

	} // end of test2.

	public static void test() {
		// 3,4,5,6중에 선택.
		for (int outer = 1; outer <= 4; outer++) {
			for (int inner = 1; inner <= 4; inner++) {
				if (outer + inner >= 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(); // 줄바꿈.
		}
		System.out.println("end of prog.");
	} // end of test.

} // end of class.
