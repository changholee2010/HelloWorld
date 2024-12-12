package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {

	// 회원정보 로그인진행.
	public String login(String id, String pw) {
		getConn();
		String sql = "select * from tbl_member" + "   where member_id = ?" + "   and   password = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			// 결과조회.
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null; // 조회결과 없음.
	}

	// 실제건수.
	public int selectCount(SearchDTO search) {
		getConn();
		String sql = "select count(1) from tbl_board";
		// Title 검색조건 => title 컬럼에서 값을 조회.
		if (search.getSearchCondition() != null && search.getKeyword() != null) {
			if (search.getSearchCondition().equals("T")) {
				sql += "                 where title like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("W")) {
				sql += "                 where writer like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("TW")) {
				sql += "                 where title like '%'||?||'%' or writer like '%'||?||'%'";
			}
		}
		try {
			psmt = conn.prepareStatement(sql);
			int cnt = 1;
			if (search.getSearchCondition() != null && search.getKeyword() != null) {
				if (search.getSearchCondition().equals("T")) {
					psmt.setString(cnt++, search.getKeyword()); // 첫번째 파라미터.
				} else if (search.getSearchCondition().equals("W")) {
					psmt.setString(cnt++, search.getKeyword()); // 첫번째 파라미터.
				} else if (search.getSearchCondition().equals("TW")) {// 첫번째 파라미터, 두번째 파라미터.
					psmt.setString(cnt++, search.getKeyword());
					psmt.setString(cnt++, search.getKeyword());
				}
			}
			rs = psmt.executeQuery(); // 조회.
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}

	// 수정(내용,제목)
	public boolean updateBoard(BoardVO board) {
		getConn();
		String sql = "update tbl_board " //
				+ "   set    title = ?" //
				+ "         ,content = ?" //
				+ "   where board_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
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

	// 목록. parameter(매개변수)
	public List<BoardVO> boardList(SearchDTO search) {
		getConn();
		String sql = "select b.* " //
				+ "   from   (select rownum rn, a.* " //
				+ "           from  (select * " //
				+ "                  from   tbl_board "; //
		// Title 검색조건 => title 컬럼에서 값을 조회.
		if (search.getSearchCondition() != null && search.getKeyword() != null) {
			if (search.getSearchCondition().equals("T")) {
				sql += "                 where title like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("W")) {
				sql += "                 where writer like '%'||?||'%' ";
			} else if (search.getSearchCondition().equals("TW")) {
				sql += "                 where title like '%'||?||'%' or writer like '%'||?||'%'";
			}
		}
		sql += "                     order by board_no desc) a) b " //
				+ "   where b.rn > (? - 1) * 5 " //
				+ "   and   b.rn <= ? * 5";

		List<BoardVO> result = new ArrayList<>(); // 반환값.
		int cnt = 1;
		try {
			psmt = conn.prepareStatement(sql);
			if (search.getSearchCondition() != null && search.getKeyword() != null) {
				if (search.getSearchCondition().equals("T")) {
					psmt.setString(cnt++, search.getKeyword()); // 첫번째 파라미터.
				} else if (search.getSearchCondition().equals("W")) {
					psmt.setString(cnt++, search.getKeyword()); // 첫번째 파라미터.
				} else if (search.getSearchCondition().equals("TW")) {// 첫번째 파라미터, 두번째 파라미터.
					psmt.setString(cnt++, search.getKeyword());
					psmt.setString(cnt++, search.getKeyword());
				}
			}
			psmt.setInt(cnt++, search.getPage());
			psmt.setInt(cnt++, search.getPage());
			System.out.println(sql);

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
