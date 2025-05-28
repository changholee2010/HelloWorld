package com.yedam.service;

import java.util.List;

import com.yedam.common.MemberStream;
import com.yedam.vo.Member;

public class MemberServiceStream implements MemberService {
	MemberStream ms = new MemberStream();

	@Override
	public boolean addMember(Member member) {
		return ms.insert(member);
	}

	@Override
	public boolean modifyMember(Member member) {
		return ms.update(member);
	}

	@Override
	public boolean removeMember(String memberId) {
		return ms.delete(memberId);
	}

	@Override
	public List<Member> memberList() {
		return ms.list();
	}

	@Override
	public void save() {
		ms.save();
	}

}
