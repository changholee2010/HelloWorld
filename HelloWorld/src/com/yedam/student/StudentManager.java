package com.yedam.student;

import java.util.Scanner;

/*
 * CRUD 처리.
 * 1.추가 2.목록 3.수정(영어,수학) 4.삭제  5.상세조회(합계,평균) 6.합계점수기준 정렬 9.종료
 */
// Student => stdNo, stdName, engScore, mathScore

public class StudentManager {
	static Student[] storage = new Student[10];

	public static void main(String[] args) {
		init();

		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("1.추가 2.목록 3.수정(영어,수학) 4.삭제 9.종료");
			System.out.printf("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 추가.
				System.out.print("학생번호 입력>> ");
				String sno = scn.nextLine();
				System.out.print("학생이름 입력>> ");
				String sname = scn.nextLine();
				System.out.print("영어점수 입력>> ");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수 입력>> ");
				int mscore = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) {
						storage[i] = new Student(sno, sname, escore, mscore); // 인스턴스 생성.
						break;
					}
				}
				break;
			case 2: // 목록.
//				System.out.printf("%5s %3s %2s %2s \n", "학생번호", "학생이름", "영어", "수학");
				System.out.println("===========================");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
//						System.out.printf(" %5s  %3s   %2d  %2d \n", storage[i].stdNo //
//								, storage[i].stdName //
//								, storage[i].engScore //
//								, storage[i].mathScore //
//						);
						storage[i].introduce();
					}
				}
				break;
			case 3: // 수정.
				System.out.print("수정할 학생번호 입력>> ");
				sno = scn.nextLine();
				System.out.print("영어점수 입력>> ");
				escore = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수 입력>> ");
				mscore = Integer.parseInt(scn.nextLine());

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].stdNo.equals(sno)) {
							storage[i].engScore = escore;
							storage[i].mathScore = mscore;
						}
					}
				}
				break;
			case 4: // 삭제.
				System.out.print("삭제할 학생번호 입력>> ");
				sno = scn.nextLine();

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						if (storage[i].stdNo.equals(sno)) {
							storage[i] = null;
						}
					}
				}
				break;
			case 9: // 종료.
				run = false;
			}
		} // end of while.
		System.out.println(":: 프로그램 끝 ::");
	} // end of main.

	public static void init() {
		storage[0] = new Student("S-001", "홍길동", 90, 80);
		storage[1] = new Student("S-002", "박문식", 70, 78);
	}
} // end of class.
