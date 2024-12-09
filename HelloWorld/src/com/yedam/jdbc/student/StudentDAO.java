package com.yedam.jdbc.student;

import java.sql.SQLException;
import java.util.ArrayList;

/*
 * DAO: Data Access Object.
 * 입력, 수정, 삭제, 조회(목록, 단건)
 */
public class StudentDAO extends DAO {

	// login() => 반환:boolean, 매개값: id, password
	public String login(String id, String pw) {
		getConn();
		String sql = "select * from tbl_member " //
				+ "   where member_id = ?" //
				+ "   and   password = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id); // 파라미터(?) 값 지정.
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			while (rs.next()) {
				return rs.getString("member_name"); // 조회결과가 있을 경우에는 true.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null; // 조회된 결과가 없을 경우는 null.
	}

	// 상세조회
	// 반환: Student클래스, 매개:학생번호, 메소드: selectStudent
	public Student selectStudent(String sno) {
		getConn();
		String sql = "select * from tbl_student where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno); // 파라미터(?) 값 지정.
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student std = new Student(); // 인스턴스 생성.
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				return std; // 조회결과 반환하고 메소드 종료.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	// 점수등록
	// 반환:boolean, 매개:Student, 메소드:updateStudent.
	public boolean updateStudent(Student std) {
		getConn();
		String sql = "update tbl_student "//
				+ "   set    eng_score = ? "//
				+ "         ,math_score = ? "//
				+ "   where std_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(3, std.getStdNo()); // std_no
			psmt.setInt(1, std.getEngScore()); // std_name
			psmt.setInt(2, std.getMathScore()); // std_phone
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true; // 정상 등록.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	// 등록. 반환:boolean, 매개:Student, 메소드:insertStudent.
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student (std_no" //
				+ "                           ,std_name" //
				+ "                           ,std_phone)" //
				+ "   values(?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo()); // std_no
			psmt.setString(2, std.getStdName()); // std_name
			psmt.setString(3, std.getStdPhone()); // std_phone
			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true; // 정상 등록.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return false;
	}

	// 학생목록.
	// 검색조건(학생이름, 연락처, 영어, 수학 검색조건 + 정렬 조건 )
	public ArrayList<Student> studentList(Search search) {
		getConn();
		// 조회결과를 반환.
		ArrayList<Student> studList = new ArrayList<Student>();

		String sql = "select std_no" //
				+ "        , std_name" //
				+ "        , std_phone" //
				+ "        , eng_score" //
				+ "        , math_score" //
//				+ "        , to_char(creation_date, 'yyyy-mm-dd hh24:mi:ss') cdate" //
				+ "        ,creation_date " //
				+ "   from tbl_student" //
				+ "   where std_name like '%'||?||'%' " //
				+ "   and   eng_score >= ? "; //

		if (search.getOrderBy().equals("std_no")) {
			sql += "  order by std_no";
		} else if (search.getOrderBy().equals("std_name")) {
			sql += "  order by std_name";
		}

		try {
			psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환.
			psmt.setString(1, search.getName());
			psmt.setInt(2, search.getEngScore());

			rs = psmt.executeQuery();
			// 반복 ArrayList에 담는 작업.
			while (rs.next()) {
				Student stud = new Student();
				stud.setStdNo(rs.getString("std_no"));
				stud.setStdName(rs.getString("std_name"));
				stud.setStdPhone(rs.getString("std_phone"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setCreationDate(rs.getDate("creation_date"));

				studList.add(stud); // ArrayList에 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 연결해제.
		}
		// 반환값.
		return studList;
	}
}
