package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 업무단위의 처리.
 */
public interface BoardService {
    public List<BoardVO> boardList();//목록조회.
    public BoardVO getBoard(int bno);//단건조회.
    public boolean registerBoard(BoardVO board);//등록기능.
    
}
