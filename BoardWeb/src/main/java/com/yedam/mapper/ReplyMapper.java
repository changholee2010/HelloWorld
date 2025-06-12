package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public int insertReply(ReplyVO rvo);
	public int deleteReply(int rvo);
	public ReplyVO selectReply(int rvo);
	public List<ReplyVO> selectList(int bno);
}
