package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	public static void main(String[] args) {
		friendApp();
	}

	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		String[] friendAry = new String[10];

		boolean run = true;
		while (run) {
			System.out.println("=======================");
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.println("=======================");
			System.out.print("선택>> ");
			// 메뉴선택.
			int menu = Integer.parseInt(scn.nextLine());
			//
			switch (menu) {
			case 1: // 추가.
				System.out.print("이름입력>> ");
				String name = scn.nextLine();
				// 이름이 존재하는 지를 확인.
				boolean isExist = false;
				for (int i = 0; i < friendAry.length; i++) {
					// 찾는 이름이 존재하는 경우.
					if (friendAry[i] != null && friendAry[i].equals(name)) {
						isExist = true;
						break;
					}
				}
				// 추가 또는 취소 결정.
				if (isExist) {
					System.out.print("존재하는 이름입니다. 추가하겠습니까? 추가(1)/취소(2)>> ");
					menu = Integer.parseInt(scn.nextLine());
					if (menu == 2) {
						System.out.println("  😅취소했습니다😅\n");
						continue;
					}
				}
				// 배열에 추가.
				for (int i = 0; i < friendAry.length; i++) {
					// 빈공간(null)인지 확인 후 추가.
					if (friendAry[i] == null) {
						friendAry[i] = name;
						System.out.println("  ❤등록성공❤\n");
						break;
					}
				} // end of for.
				break;

			case 2: // 목록.
				// 입력값 출력.
				int no = 1;
				System.out.println("번호 이름");
				System.out.println("=============");
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf(" %d) %s\n", no++, friendAry[i]);
					}
				}
				System.out.println();
				break;

			case 3: // 삭제.
				System.out.print("삭제할 친구 이름>> ");
				name = scn.nextLine();
				isExist = false; // 친구이름이 있는지를 확인여부.
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(name)) {
						friendAry[i] = null; // 삭제.
						System.out.println("  ⛏삭제성공⛏\n");
						isExist = true;
						break;
					}
				}
				// 이름을 못찾을 경우에 출력해주는 조건.
				if (!isExist) {
					System.out.println("  😅찾는 이름이 없습니다😅\n");
				}
				break;

			case 4: // 종료.
				System.out.println("프로그램을 종료합니다 Bye~~ ");
				run = false;
			}
		} // end of while.

		System.out.println("<< end of prog >>");

	} // end of friendApp().

	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언.
		String[] stringAry = new String[10];
		stringAry[0] = "홍길동";
		stringAry[1] = "김친구";
		stringAry[2] = "김태완";
		stringAry[3] = "김태희";

		System.out.print("삭제할 친구 이름>> ");
		String name = scn.nextLine();

		// 삭제할 친구이름을 검색.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null; // 삭제.
			}
		}
		// 입력값 출력.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog.");
	}

	// 문자열배열.
	public static void strAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언.
		String[] stringAry = new String[10]; // 입력값을 저장.

		// 추가작업을 반복.
		while (true) {
			System.out.print("이름을입력>> ");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break; // while문 종료.
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null)인지 확인 후 추가.
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력성공.");
					break;
				}
			} // end of for.

		} // end of while.

		// 입력값 출력.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog.");

	} // end of main.
} // end of class.
