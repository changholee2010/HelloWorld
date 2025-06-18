package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String id, String pw);
	// 회원목록.
	public List<MemberVO> memberList(String order);
	// 회원등록.
	public boolean addMember(MemberVO member);
	// 회원조회.
	public boolean getMemberInfo(String id);
}
