package com.yedam.collection;

public class Student {
	private int studentNo; // 1001, 1002, 1003...1010;
	private int score;
	// constructor.
	public Student(int studentNo, int score) {
		this.studentNo = studentNo;
		this.score = score;
	}
	// getter.
	public int getScore() {
		return score;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
