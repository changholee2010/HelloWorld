package com.yedam.ref;

/*
 * 배열 + 기본타입: 정수, 실수
 * 배열 + 참조타입(클래스): 학생이름, 점수
 */

public class ArrayExe3 {

	static Student[] stdAry;

	public static void main(String[] args) {
		init();
		int sum = 0;
		double max = 0;
//		String maxName = "";
		Student maxStd = new Student(); // 인스턴스 생성.
		// 배열의 값을 출력.
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름:%s 점수:%d \n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score;
			if (max < stdAry[i].height) { // 가장큰키, 키큰학생.
				max = stdAry[i].height;

				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
		}
		double avg = 1.0 * sum / stdAry.length;
		String strFmt = "키큰학생:%s, 점수: %d, 키:%.1f, 평균: %.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height, avg);
	}

	public static void init() {
		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE; // "남자", "Men",

		Student s2 = new Student(); // 인스턴스 생성.
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;

		Student s3 = new Student(); // 인스턴스 생성.
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.3;
		s3.gender = Gender.MALE;

		stdAry = new Student[] { s1, s2, s3 }; // 배열에 값을 할당.
	}

	public static void test() {

		// 홍길동, 80
		int num1 = 90;

		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;

		// 김민규, 85 => s2에 저장.
		Student s2 = new Student(); // 인스턴스 생성.
		s2.studentName = "김민규";
		s2.score = 85;

		// 홍길동의 점수를 90 변경.
		s1.score = 90;

		// 학생정보를 배열에 저장.
		Student[] students = { s1, s2 };
		students[0].studentName = "홍길도";

		System.out.printf("이름: %s, 점수: %d\n", s1.studentName, s1.score);

	}
}
