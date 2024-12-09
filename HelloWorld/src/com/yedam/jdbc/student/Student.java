package com.yedam.jdbc.student;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * tbl_student의 칼럼을 필드로 선언.
 * std_no => stdNo;
 */
public class Student {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private int engScore;
	private int mathScore;
	private Date creationDate;

	public Student() {
	}

	public Student(String stdNo, String stdName, String stdPhone) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdPhone = stdPhone;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

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

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
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

	// 목록으로 출력.
	public String 대충보기() {
		// Date -> 출력포맷.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String cdate = sdf.format(creationDate);

		return " " + stdNo + "  " + stdName + "  " //
				+ stdPhone + "  " + engScore + "  " + cdate;
	}

	// 상세화면 출력.
	public String showDetail() {
//		----------------------------
//		학생번호: 24-001   이름: 홍길동
//		연락처: 010-1111-2222
//		영어점수: 80       수학점수: 70
//		----------------------------
		String result = "----------------------------\n";
		result += "학생번호: " + stdNo + "   이름: " + stdName + "\n";
		result += "연락처: " + stdPhone + "\n";
		result += "영어점수: " + engScore + "       수학점수: " + mathScore + "\n";
		result += "----------------------------\n";
		return result;
	}
}
