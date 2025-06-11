package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	// 회원목록.
	public List<MemberVO> selectList(String order);
}
