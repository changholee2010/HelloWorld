package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. 실행
 * 5. ResultSet
 * 6. 출력
 */
public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		// 세션.
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			conn.setAutoCommit(false);
			System.out.println("연결성공.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Statement 객체.
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "delete from product where p_code = 201";
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert,update,delete
			if (r > 0) {
				conn.commit();// 커밋.
				System.out.println(r + "건 등록됨.");
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = stmt.executeQuery("select * from product");
			System.out.println("상품코드 상품이름      가격");
			System.out.println("-----------------------");
			while (rs.next()) {
				System.out.println(rs.getInt("p_code") + " "//
						+ rs.getString("p_name") + " "//
						+ rs.getInt("p_price")//
				);
			}
			System.out.println("-------end of rows-----");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of main.
}
