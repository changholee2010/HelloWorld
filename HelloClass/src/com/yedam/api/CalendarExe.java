package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Calendar: 날짜, 시간 관련.
 * Date: 날짜, 시간, 
 */
public class CalendarExe {
	public static void main(String[] args) {
		makeCalendar(2025, 8);
	}

	// 달력.
	public static void makeCalendar(int year, int month) {
		System.out.printf("        %d년 %02d월 \n", year, month);
		System.out.println("=============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("=============================");
		System.out.println("                   1   2   3");
		System.out.println("   4   5   6   7   8   9  10");
		System.out.println("  11  12  13  14  15  16  17");
		System.out.println("  18  19  20  21  22  23  24");
		System.out.println("  25  26  27  28  29  30  31");
		System.out.println("-----------------------------");

	}

	public static void date() {
		Date today = new Date();
//		System.out.println(today.toString());

		// 생성자의 매개값으로 포맷지정.
		SimpleDateFormat sdf = //
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = sdf.format(today); // Date -> String.
		System.out.println(timeStr);
		// 2025년05월12일 13:22:38

		try {
			today = sdf.parse("2025-08-01 09:00:00"); // String -> Date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);
	}

	public static void cal() {
		// Calendar 클래스.
		Calendar now = Calendar.getInstance();

		// 시간변경.
		now.set(2025, 0, 1);
		now.set(Calendar.YEAR, 2024);

		// 요일.
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		}

		System.out.printf("년도 %d, 월: %d, 날짜: %d, 요일: %d, 말일: %d \n", //
				now.get(Calendar.YEAR) //
				, now.get(Calendar.MONTH)//
				, now.get(Calendar.DATE)//
				, now.get(Calendar.DAY_OF_WEEK)//
				, now.getActualMaximum(Calendar.DATE)//
		);
	}
}
