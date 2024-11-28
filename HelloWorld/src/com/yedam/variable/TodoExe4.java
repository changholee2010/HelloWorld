package com.yedam.variable;

import java.util.Scanner;

public class TodoExe4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("몇단까지 출력하겠습니까?>> ");
		int dan = 6;// scn.nextInt(); // 사용자 입력값을 int 반환.

		for (int j = 0; j <= 9; j++) {
			for (int i = 2; i <= dan; i++) {
				if (j == 0) {
					System.out.printf("[%5d]     ", i);
				} else {
					System.out.printf("%d * %d =%3d  ", i, j, j * i);
				}
			}
			System.out.println(); // 줄바꿈....
		}

		// 별찍기.
		for (int j = 5; j >= 1; j--) {
			for (int i = 1; i <= j; i++) {
				System.out.printf("*");
			}
			System.out.println();
		}

		System.out.println("end of prog.");
	}
}
