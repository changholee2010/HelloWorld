package com.yedam.ref.app;

public class TodoExe {
	public static void main(String[] args) {
		int[][] numAry = new int[3][5];
		// 임의의 숫자 생성.
		for (int outer = 0; outer < numAry.length; outer++) {
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100);
			}
		}

	}
}
