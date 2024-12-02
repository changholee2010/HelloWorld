package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student("S001"); // 실체생성(인스턴스 생성)
		s1.stdName = "홍길동";
		s1.engScore = 60;
		s1.mathScore = 70;
		System.out.println(s1.stdNo + ", " + s1.stdName //
				+ "의 합계점수는 " + s1.sumScore()//
				+ " 평균은 " + s1.average());

		Student s2 = new Student("S002", "김길동");
		s2.engScore = 70;
		s2.mathScore = 75;
		System.out.println(s2.stdNo + ", " + s2.stdName //
				+ "의 합계점수는 " + s2.sumScore()//
				+ " 평균은 " + s2.average());

		Student s3 = new Student("S003", "최길동", 80, 90);
		System.out.println(s3.stdNo + ", " + s3.stdName + ", eng: " + s3.engScore + ", math: " + s3.mathScore);

		System.out.println(s1 == s2);

		int num = 100;

//		Teacher t1 = new Teacher();
	}
}
