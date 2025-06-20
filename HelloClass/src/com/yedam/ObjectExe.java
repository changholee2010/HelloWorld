package com.yedam;

import java.util.Scanner;

public class ObjectExe {

	public static void main(String[] args) {
		String msg = "";
		int year = 0;
		Scanner scn = new Scanner(System.in);

		// 년도를 입력받는데 quit를 입력하면 종료처리.
		while (true) {
			System.out.print("년도를 입력하세요>>> ");
			msg = scn.nextLine();
			try {
				year = Integer.parseInt(msg);
			} catch (NumberFormatException e) {
				// 문자를 입력한 경우에 quit인지 확인해서 종료.
				if (msg.equals("quit")) {
					break;
				}
				System.out.println("년도를 입력하셔야 합니다~~");
				continue;
			}
			// 년도를 판단해서 윤년/평년 구분 메세지출력.
			if (Calendar.isLeapYear(year)) {
				System.out.printf("%d년은 윤년입니다.\n", year);
			} else {
				System.out.printf("%d년은 평년입니다.\n", year);
			}
		} // end of while.
		System.out.println("윤년계산 끝~~~");
		scn.close();
	} // end of main.

}
