package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

/*
 * 업무단위의 처리.
 */
public interface BoardService {
    public List<BoardVO> boardList(SearchDTO search);//목록조회.
    public BoardVO getBoard(int bno);//단건조회.
    public boolean registerBoard(BoardVO board);//등록기능.
    public boolean modifyBoard(BoardVO board);//수정기능.
    public boolean removeBoard(int bno);//삭제기능.
    // 전체카운트 계산.
    public int getTotalCount(SearchDTO search); // selectCount() :매퍼쪽.
    public List<Map<String, Object>> chartCount();
    //
    public List<Map<String, String>> eventList();
    public boolean addEvent(Map<String, String> map);
    public boolean removeEvent(Map<String, String> map);
}
