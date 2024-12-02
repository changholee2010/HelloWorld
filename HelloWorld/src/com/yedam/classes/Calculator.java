package com.yedam.classes;

import com.yedam.student.Student;

public class Calculator {

	// 기본생성자. public Calculator() {}
	// 반환값 + 메소드이름 + 매개변수(...)
	int sum(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}

	// 메소드 오버로딩.
	double sum(double n1, double n2) {
		return n1 + n2;
	}

	// 메소드 내에서 return 메소드의 종료.
	double max(double n1, double n2) {
		if (n1 >= n2) {
			return n1;
		}
		return n2;
	}

	double max(int[] ary) {
		int result = 0;
		for (int i = 0; i < ary.length; i++) {
			if (result < ary[i]) {
				result = ary[i];
			}
		}
		return result;
	}

	void printStar(int times) {
		for (int i = 1; i <= times; i++) {
			System.out.print("☆");
		}
		System.out.println();
	}

	// 반환값의 유형은 int, 매개변수는 정수배열.
	int sumAry(int[] ary) {
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum; // 반환값.
	}

	double averageAry(int[] ary) {
		return sumAry(ary) * 1.0 / ary.length; // 10.0 / 4 => 2.5
	}

	// 매개값으로 Student[]을 활용해서 영어점수가 가장 높은 값을 반환.
	Student getMaxScore(Student[] stdAry) {
		int max = 0;
		Student result = null;
		for (int i = 0; i < stdAry.length; i++) {
			if (max < stdAry[i].engScore) {
				max = stdAry[i].engScore;
				result = stdAry[i];
			}
		}
		return result;
	}
}
