package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public int insertReply(ReplyVO rvo);
	public int deleteReply(int rvo);
	public ReplyVO selectReply(int rvo);
	public List<ReplyVO> selectList(@Param("bno") int bno, @Param("page") int page);
	public int selectTotal(int bno);
}
