package com.yedam.api;

public class Student {
	// 필드.
	private int sno;
	private String sname;
	private int score;

	// 생성자.
	public Student(int sno, String sname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.score = score;
	}

	// hashCode() & equals() => 학번이 같으면 논리적으로 동등한 객체.
	@Override
	public int hashCode() {
		return sno; // 학생번호 hashCode값.
	}

	@Override
	public boolean equals(Object obj) { // casting 후 sno 비교.
		if (obj instanceof Student) {
			Student s1 = (Student) obj;
			if (sno == s1.sno) {
				return true;
			}
		}
		return false;
	}

	public int getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "학번: " + sno + ", 이름: " + sname + ", 점수: " + score;
	}

}
