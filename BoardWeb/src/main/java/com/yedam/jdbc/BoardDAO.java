package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {

	// 상세조회. 파라미터(int boardNo) selectBoard 반환값: BoardVO.
	public BoardVO selectBoard(int boardNo) {
		getConn();
		String sql = "select * from tbl_board where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery(); // 조회.

			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getDate("creation_date"));

				return brd;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	// BoardVO 파라미터 => 등록.
	public boolean insertBoard(BoardVO board) {
		getConn();
		String sql = "insert into tbl_board " //
				+ "(board_no, title, content, writer) " //
				+ "values(board_seq.nextval, ?, ?, ?) ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return false;
	}

	// 목록.
	public List<BoardVO> boardList() {
		getConn();
		String sql = "select * from tbl_board order by board_no";
		List<BoardVO> result = new ArrayList<>(); // 반환값.

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 조회.

			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getDate("creation_date"));

				result.add(brd); // ArrayList에 추가.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return result;
	}
}
