package com.yedam.ref.app;

public class TodoExe {
	public static void main(String[] args) {
		int[][] numAry = new int[3][5];
		int sum = 0; // 합계.
		double avg = 0; // 평균.

		// 임의의 숫자 생성.
		for (int outer = 0; outer < numAry.length; outer++) {
			sum = 0; // 초기화.
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100);
				sum += numAry[outer][inner];
			}
			// numAry[i] 마다 합계와 평균을 구하기.
			avg = 1.0 * sum / numAry[outer].length;
			System.out.printf("numAry[%d]의 평균은 %.2f\n", outer, avg);
		}
		System.out.println("** end of prog **");
	}
}
