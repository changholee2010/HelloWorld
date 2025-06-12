package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public boolean addReply(ReplyVO rvo) {
		// 댓글입력처리.
		int r = mapper.insertReply(rvo);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<ReplyVO> replyList(int bno) {
		// 댓글목록(원본글번호가 필요)
		return mapper.selectList(bno);
	}

	@Override
	public ReplyVO getReply(int rno) {
		// 단건조회
		return mapper.selectReply(rno);
	}

	@Override
	public boolean removeReply(int rno) {
		// 댓글삭제
		int r = mapper.deleteReply(rno);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

}
