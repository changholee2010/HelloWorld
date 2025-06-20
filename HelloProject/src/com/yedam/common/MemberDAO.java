package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Member;

/*
 * Database 에 insert, update, delete, select
 */
public class MemberDAO extends DAO {
	// 등록.
	public int insert(Member member) {
		String sql = "insert into tbl_member(member_id, member_name)"//
				+ "   values(?,?)";
		// 접속.
		getConnect();
		try {
			// stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getMemberName());
			int r = psmt.executeUpdate();
			return r;// 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;// 반영X
	} // end of insert.
		// 수정.

	public int update(Member member) {
		String sql = "update tbl_member"//
				+ "   set phone = ?"//
				+ "      ,point = ?"//
				+ "   where member_id = ?";
		// 접속.
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPhone());
			psmt.setInt(2, member.getPoint());
			psmt.setString(3, member.getMemberId());
			int r = psmt.executeUpdate();
			return r;// 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;// 반영X
	} // end of update.
		// 삭제.

	public int delete(String memberId) {
		String sql = "delete from tbl_member"//
				+ "   where member_id = ?";
		// 접속.
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			int r = psmt.executeUpdate();
			return r;// 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;// 반영X
	} // end of delete.

	// 목록
	public List<Member> select() {
		String sql = "select * from tbl_member";
		getConnect();
		List<Member> list = new ArrayList<>(); // 컬렉션에 저장.
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 조회.
			while (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setPoint(rs.getInt("point"));
				// 추가.
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
