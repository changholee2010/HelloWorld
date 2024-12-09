package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {

	static Scanner scn = new Scanner(System.in);
// 	db 처리기능.
	static StudentDAO dao = new StudentDAO();

	public static void main(String[] args) {
		boolean run = true;

		while (true) {
			// 로그인 기능. code here...
			System.out.print("아이디입력>> ");
			String id = scn.nextLine();
			System.out.print("비번입력>> ");
			String pass = scn.nextLine();

			// 로그인메소드 호출 login()
			String name = dao.login(id, pass);
			if (name != null) {
				System.out.println(name + " 환영합니다.");
				break;
			} else {
				System.out.println("다시 로그인하세요.");
			}
		}

		while (run) {
			System.out.println("1.목록 2.등록 3.점수등록 4.상세조회 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 목록.
				list();
				break;

			case 2: // 등록.
				System.out.print("학생번호 입력>> ");
				String no = scn.nextLine();
				System.out.print("학생이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("연락처 입력>> ");
				String phone = scn.nextLine();

				// 3개항목을 매개값으로 받는 생성자 선언.
				Student std = new Student(no, name, phone);

				if (dao.insertStudent(std)) {
					System.out.println("정상 등록.");
				} else {
					System.out.println("등록 실패.");
				}
				break;

			case 3: // 점수등록.
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();
				System.out.print("영어점수 입력>> ");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수 입력>> ");
				int mscore = Integer.parseInt(scn.nextLine());

				std = new Student(); // 인스턴스 생성.
				std.setStdNo(no);
				std.setEngScore(escore);
				std.setMathScore(mscore);

				// 성적수정.
				if (dao.updateStudent(std)) {
					System.out.println("정상 수정.");
				} else {
					System.out.println("수정 실패.");
				}
				break;
			case 4: // 상세조회.
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();

				std = dao.selectStudent(no); // Student 값 반환.
				if (std == null) {
					System.out.println("조회된 결과 없습니다.");
					break;
				}
				System.out.println(std.showDetail());// 상세출력.
				break;

			case 9: // 종료.
				run = false;
			}
		}
		System.out.println("end of prog.");
	} // end of main.

	// 목록기능.
	public static void list() {
		Search search = new Search();

		System.out.println("1.학생이름 2.연락처 3.영어");
		System.out.print("선택>> ");
		int menu = Integer.parseInt(scn.nextLine());

		switch (menu) {
		case 1:
			System.out.print("검색할 이름>> ");
			String name = scn.nextLine();
			search.setName(name);
			break;
		case 2:
			System.out.print("검색할 연락처>> ");
			String phone = scn.nextLine();
			search.setPhone(phone);
			break;
		case 3:
			System.out.print("검색할 영어점수>> ");
			int escore = Integer.parseInt(scn.nextLine());
			search.setEngScore(escore);

		} // end of switch.

		System.out.println("1.학생번호정렬 2.학생이름정렬");
		System.out.print("선택>> ");
		int orderBy = Integer.parseInt(scn.nextLine());
		// 정렬조건 추가. orderBy => 값을 ? 지정.
		// 완성...

		ArrayList<Student> list = dao.studentList(search);
		for (Student stud : list) { // 학생번호, 이름, 연락처, 영어, 생성일.
			System.out.println(stud.대충보기());
		}
	} // end of list().

}
