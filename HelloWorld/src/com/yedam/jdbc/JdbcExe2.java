package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExe2 {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setLastName("Park");
		emp.setHireDate("2000-01-01");
		emp.setEmployeeId(214);

		delete(emp.getEmployeeId());
		select();

		System.out.println("end of prog.");
	}

	// 연결.
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드.
			// Connection 객체.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println("연결중 에러.");
			e.printStackTrace();
		}
		return conn; // connection 객체 반환.
	}

	// 삭제기능.
	public static void delete(int empId) {
		Connection conn = getConn();
		String query = "delete from employees" //
				+ "     where employee_id = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, empId);

			int r = stmt.executeUpdate();
			System.out.println(r + "건 처리됨.");

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 수정기능.
	public static void update(Employee emp) {
		Connection conn = getConn();
		String query = "update employees" //
				+ "        set first_name = ? "//
				+ "           ,phone_number = ? "//
				+ "           ,salary = ? "//
				+ "     where employee_id = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getFirstName());
			stmt.setString(2, emp.getPhoneNumber());
			stmt.setInt(3, emp.getSalary());
			stmt.setInt(4, emp.getEmployeeId());

			int r = stmt.executeUpdate();
			System.out.println(r + "건 처리됨.");

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 입력기능.
	public static void insert(Employee emp) {
		Connection conn = getConn();
		String query = "insert into employees (employee_id" //
				+ "                          , last_name" //
				+ "                          , email" //
				+ "                          , hire_date" //
				+ "                          , job_id) " //
				+ "values(employees_seq.nextval " // empId
				+ "     , ? " // last_name
				+ "     , ? " // email
				+ "     , ? " // hire_date
				+ "     , ? )";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getLastName());
			stmt.setString(2, emp.getEmail());
			stmt.setString(3, emp.getHireDate());
			stmt.setString(4, emp.getJobId());

			int r = stmt.executeUpdate();
			System.out.println(r + "건 처리됨.");

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 조회기능.
	public static void select() {
		Connection conn = getConn();

		// sql작성. Statement 객체.
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from employees where employee_id > 200 order by employee_id desc";
			// 조회.
			ResultSet rs = stmt.executeQuery(query);
			// 결과출력.
			while (rs.next()) {
				System.out.println(rs.getInt("employee_id") + ", "//
						+ rs.getString("first_name") + ", "//
						+ rs.getString("last_name") + ", "//
						+ rs.getInt("salary") + ", "//
						+ rs.getString("phone_number") + ", "//
						+ rs.getString("email"));
			}
			conn.close(); // 연결 해제.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("== end of data ==");

	}
}
