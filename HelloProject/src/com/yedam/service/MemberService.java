package com.yedam.service;

import java.util.List;

import com.yedam.vo.Member;

/*
 * 업무로직(등록,변경,삭제,출력)
 */
public interface MemberService {
	public boolean addMember(Member member);//등록.
	public boolean modifyMember(Member member);//변경.
	public boolean removeMember(String memberId);//삭제.
	public List<Member> memberList();//출력.
	public void save();
}
