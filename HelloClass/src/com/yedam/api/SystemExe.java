package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {

		long now = System.currentTimeMillis(); // 현재시간을 1/1000초.
		System.out.println(now);
		// 1747964906 => "초" => 몇일, 몇시간, 몇분, 몇초 계산.
		// 60 * 60 * 24 => 1일.
		// 60 * 60 => 1시간.
		// 60 => 1분
		// 나머지가 초.
		// 계산.
		long time = 1747964917; // 초 단위의 현재 시간.
		long years = time / (60 * 60 * 24 * 365); // 년 계산

		long days = time % (60 * 60 * 24 * 365); // 일 계산.
		days = days / (60 * 60 * 24);

		long hours = time % (60 * 60 * 24); // 시간 계산.
		hours = hours / (60 * 60);

		long minutes = time % (60 * 60); // 분 계산.
		minutes = minutes / 60;

		long secs = time % 60; // 초 계산.

		System.out.printf("%d초는 %d년 %d일 %d시간 %d분 %d초\n"//
				, time, years, days, hours, minutes, secs);

	}

	public static void exe() {
		//
		long start = System.nanoTime();// System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.nanoTime();// System.currentTimeMillis();
		System.out.printf("합계 %d, 걸린시간 %d\n", sum, (end - start));

	}
}
