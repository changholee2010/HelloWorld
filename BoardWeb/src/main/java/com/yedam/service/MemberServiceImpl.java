package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> memberList(String order) {
		return mapper.selectList(order);
	}

}
