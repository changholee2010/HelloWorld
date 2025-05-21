package com.yedam;

public class Calendar {
	public static void showMonth(int month) {
		int[] dayAry = new int[365];
		int[] lastDateAry = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int idx = 0;
		int mon = month - 1;
		int spaces = 3;
		// 값을 저장.
		for (int i = 0; i < lastDateAry.length; i++) {
			int lastDate = lastDateAry[i];
			for (int j = 1; j <= lastDate; j++) {
				dayAry[idx++] = j;
			}
		}
		System.out.printf("%14d월\n", mon);
		System.out.println("=============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("=============================");

	}

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
