package com.yedam.inheritance;

public class DataMain {
	public static void main(String[] args) {
		Dao dao = new OracleDao();

		dao.insert();

		dao.update();

		dao.delte();
	}
}
