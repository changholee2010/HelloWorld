package com.yedam.methods;

public class Student {

	private String stdNo; // 필드.
	private String stdName;
	private int engScore;
	private int mathScore;

	// 생성자. => 인스턴스를 생성하면서 필드의 값을 초기화해주는 기능.
//	public Student(String stdNo) {
//		this.stdNo = stdNo;
//	}

	public Student(String stdNo, String stdName, int engScore, int mathScore) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	// getter, setter. 메소드.
	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	// showInfo()
	public String showInfo() {
		return "학번: " + stdNo + ", 이름: " + stdName + ", 영어: " + engScore;
	}

}
