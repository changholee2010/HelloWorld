package com.yedam.service;

import java.util.List;

import com.yedam.common.MemberDAO;
import com.yedam.vo.Member;
/*
 * 업무단위처리(데이터베이스의 여러테이블에 반영)
 */
public class MemberServiceDAO implements MemberService {
	MemberDAO dao = new MemberDAO(); // 필드.

	@Override
	public boolean addMember(Member member) {
		return dao.insert(member) == 1;
	}

	@Override
	public boolean modifyMember(Member member) {
		return dao.update(member) == 1;
	}

	@Override
	public boolean removeMember(String memberId) {
		return dao.delete(memberId) == 1;
	}

	@Override
	public List<Member> memberList() {
		return dao.select();
	}

}
