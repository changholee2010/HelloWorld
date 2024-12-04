package com.yedam.api;

import java.util.Date;

public class StringTest {

	public static void main(String[] args) {
		test3();
	}

	static void test1() {
		// 현재 시간을 yyyy/MM/dd hh:mm:ss 로 출력.
		Date now = new Date();
		answer1(now);
	}

	static void answer1(Date today) {
		System.out.println(today.getYear() + 1900// 년도.
				+ "/" + (today.getMonth() + 1) // 월.
				+ "/" + "0" + today.getDate() // 일.
				+ " " + today.getHours() // 시.
				+ ":" + today.getMinutes() // 분.
				+ ":" + today.getSeconds() // 초.
		);

//		String result = "%d/%d/%s %s:%s:%s";
//		int yyyy = today.getYear() + 1900;
//		int MM = today.getMonth() + 1;
//		String dd = "0" + today.getDate();
//		String hh = "0" + today.getHours();
//		String mm = "0" + today.getMinutes();
//		String ss = "0" + today.getSeconds();
//
//		System.out.println(yyyy // 년
//				+ "/" + MM // 월
//				+ "/" + dd.substring(dd.length() - 2)// 일
//				+ " " + hh.substring(hh.length() - 2)// 시
//				+ ":" + mm.substring(mm.length() - 2)// 분
//				+ ":" + ss.substring(ss.length() - 2)// 초
//		);
	}

	static void test2() {
		// 주민번호를 받아서 성별을 구별하는 프로그램.
		String[] numbers = { "9501231234567", "950405 2345678", "980102-5345678" };
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] + "는 " + answer2(numbers[i]) + "입니다.");
		}
	}

	static String answer2(String ssn) {
		int pos = ssn.length() - 7; // 6, 7

		switch (ssn.charAt(pos)) {
		case '1':
			return "남자";
		case '2':
			return "여자";
		}
		return "오류";
	}

	static void test3() {
		// 파일의 이름과 확장자를 구하는 코드.
		String[] files = { "c:/temp/rose.jpg", "d:/download/new.txt", "temp/good.jpeg" };
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i] + " 의 파일명은 " + answer3(files[i]) + " 입니다.");
		}
	}

	static String answer3(String name) {
		int endPos = name.indexOf(".");
		int startPos = name.lastIndexOf("/");
		String ext = name.substring(startPos + 1, endPos);
		return ext;
	}
}
