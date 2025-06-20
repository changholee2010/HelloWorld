package com.yedam;

public class Calendar {

	static boolean isLeapYear(int year) {
		// 윤년이면 true, 평년이면 false.
		boolean leapYear = true;
		if (year % 4 != 0) {
			leapYear = false;
		}
		if (leapYear && year % 100 == 0) {
			leapYear = false;
		}
		if (!leapYear && year % 400 == 0) {
			leapYear = true;
		}
		return leapYear;
	} // end of isLeapYear.

	// 1년 365일에 해당하는 월별 날짜를 배열에 저장하고
	// 출력하고자 하는 월의 내용만 화면에 출력한다.
	public static void showMonth(int month) {

		// 초기변수 선언.
		int[] dayAry = new int[365]; // 1년 365일.
		int[] lastDateAry = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 월별 마지막 일자.
		int idx = 0; // 날짜를 지정할때 사용할 인덱스를 증가.
		int spaces = 3; // 1월달의 공백갯수. 월마다 계산하기.

		// 열두달의 각 날짜를 배열에 저장.
		for (int i = 0; i < lastDateAry.length; i++) {
			int lastDate = lastDateAry[i]; // 월별 말일을 가지고 온다.
			for (int j = 1; j <= lastDate; j++) { // 1일부터 말일을 저장.
				dayAry[idx++] = j;
			}
		}
		System.out.printf("%14d월\n", month);
		System.out.println("=============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("=============================");
		// 날짜 출력.
		int mong = 0;
		for (int i = 0; i < dayAry.length; i++) {
			// 1일이면 월을 증가.
			if (dayAry[i] == 1) {
				mong++;
			}
			// 출력하고 싶은 월만 출력.
			if (mong == month) {
				// 월별로 1일마다 공란을 계산해야 하므로...
				if (dayAry[i] == 1) {
					// 빈공간 생성.
					spaces = spaces % 7;
					for (int s = 0; s < spaces; s++) {
						System.out.printf("%4s", "_");
					}

				}
				System.out.printf("%4d", dayAry[i]); // 월에 해당하는 날짜를 출력.
				if (spaces % 7 == 6) {// 일주일에 한번씩 줄바꿈.
					System.out.println();
				}
			}
			spaces++; // 공란을 계속 증가. 7로 나눈 나머지를 사용하기 때문에 증가해둠.
		}

	} // end of showMonth(int).

	public static void showMonth() {
		int[] dayAry = new int[365];
		int[] lastDateAry = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int idx = 0;
		int mon = 1;
		int spaces = 3;
		// 값을 저장.
		for (int i = 0; i < lastDateAry.length; i++) {
			int lastDate = lastDateAry[i];
			for (int j = 1; j <= lastDate; j++) {
				dayAry[idx++] = j;
			}
		}
		// 출력.
		System.out.printf("%14d월\n", mon);
		System.out.println("=============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("=============================");
		for (int s = 0; s < spaces; s++) {
			System.out.printf("%4s", " ");
		}

		// 여기서부터 시작.
		for (int i = 0; i < dayAry.length; i++) {
			// 매달 1일이 되면 요일을 먼저 출력하고..
			System.out.printf("%4d", dayAry[i]);
			if (mon < 12 && dayAry[i] > dayAry[i + 1]) {
				mon++;
				System.out.printf("\n\n%14d월", mon);
				System.out.println("\n=============================");
				System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
				System.out.println("=============================");
				spaces = spaces++ % 7;
				for (int s = 0; s <= spaces; s++) {
					System.out.printf("%4s", " ");
				}
			}

			if (spaces++ % 7 == 6) {
				System.out.println();
			}
		}

//		System.out.println("        2025년 05월 ");
//		System.out.println("=============================");
//		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
//		System.out.println("=============================");
//		System.out.println("                   1   2   3");
//		System.out.println("   4   5   6   7   8   9  10");
//		System.out.println("  11  12  13  14  15  16  17");
//		System.out.println("  18  19  20  21  22  23  24");
//		System.out.println("  25  26  27  28  29  30  31");
//		System.out.println("-----------------------------");
	}
}
