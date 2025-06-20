package com.yedam.member;

public class Member {
	// 필드.
	private String memberId;
	private String memberName;
	private String phone;
	private int point;
	// 생성자.
	public Member() {}
	public Member(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	// 전체필드를 매개값으로 갖는 생성자.
	public Member(String memberId, String memberName, String phone, int point) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}
	// 메소드(getter, setter)
	String getMemberId() {
		return memberId;
	}
	void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	String getMemberName() {
		return memberName;
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	String getPhone() {
		return phone;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	void setPoint(int point) {
		this.point = point;
	}
	// 이름,연락처,포인트 출력메소드.
	public void showInfo() {
		System.out.printf("이름은 %s, 연락처는 %s, 포인트는 %d\n", memberName, phone, point);
	}
}
