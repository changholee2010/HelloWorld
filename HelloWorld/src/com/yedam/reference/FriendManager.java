package com.yedam.reference;

import java.util.Scanner;

/*
 *  친구정보 저장 기능.
 *  1.추가 2.목록 3.조회(숙제) 9.종료 
	storage[1] = null; // 요렇게 꼭 사용하세요!!!!!! 중요...
	
	
	storage[1].friendName = "홍길동";
	storage[1].friendPhone = "010-1111-1111";
	storage[1].friendBirth = "1999-01-01";
	
	C(reate)R(ead)U(pdate)D(elete)
 */

public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10];
		init(storage); // 친구정보 저장할수 있는 공간 10개 확보.

		while (run) {
			System.out.println("----------------------------");
			System.out.println("1.추가 2.목록 3.조회(숙제) 4.수정(연락처) 5.삭제 9.종료 ");
			System.out.println("----------------------------");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가.
				System.out.print(" 친구 이름 입력>> ");
				String name = scn.nextLine();
				System.out.print(" 친구 연락처 입력>> ");
				String phone = scn.nextLine();
				System.out.print(" 친구 생일 입력>> ");
				String birth = scn.nextLine();

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) { // 비어있는 위치에 저장.
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						System.out.println(" 등록완료!!");
						break; // for 종료.
					}
				}
				break; // switch 종료.
			case 2: // 목록.
				System.out.println(" --------------------");
				System.out.println("  이름    전화번호 ");
				System.out.println(" --------------------");
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%4s %14s \n", storage[i].friendName, storage[i].friendPhone);
					}
				}
				System.out.println();
				break; // switch 종료.
			case 3: // 조회.

				boolean isExists = false;
				System.out.print(" 친구 이름 입력>> ");
				name = scn.nextLine();
				int idx = -1;
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 이 아닌 요소 기준 조회.
						isExists = storage[i].friendName.equals(name);
						if (isExists) {
							idx = i;
							break; // for 반복문에..
						}
					}
				}
				// 3.찾는 이름이 있으면 이름과 점수 출력.
				// 4.없으면 "찾는 이름 없음" 출력.
				if (isExists) {
					System.out.println(" -------------------------------");
					System.out.printf(" 이름:%4s | 생년월일: %11s \n 연락처: %10s\n", //
							storage[idx].friendName, storage[idx].friendBirth, storage[idx].friendPhone);
					System.out.println(" -------------------------------");

				} else {
					System.out.println("찾는 이름 없음");

				}
				break; // switch 종료.
			case 4: // 수정=> 이름, 연락처 입력.
				System.out.print(" 친구 이름 입력>> ");
				name = scn.nextLine();
				System.out.print(" 친구 연락처 입력>> ");
				phone = scn.nextLine();
				// 10개 중에서 6개 저장, 4개 null.
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닌 요소 대상.
						if (storage[i].friendName.equals(name)) {
							storage[i].friendPhone = phone;
							break;
						}
					}
				}
				break; // switch 종료.
			case 5: // 삭제. 배열의 위치에 null값을 대입함.
				System.out.print(" 삭제할 친구 이름 입력>> ");
				name = scn.nextLine();

				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) { // null 값이 아닌 요소 대상.
						if (storage[i].friendName.equals(name)) {
							storage[i] = null;
							break;
						}
					}
				}
				break; // switch 종료.
			case 9: // 종료.
				run = false;
				break; // switch 종료.
			default:
				System.out.println("메뉴를 다시 선택하세요");
			} // end of switch.

		} // end of while.
		System.out.println(":::: 프로그램 끝 ::::");
	} // end of main().

//	
//	
//
//
//	
//	

	public static void init(Friend[] storage) {

		Friend f1 = new Friend();
		f1.friendName = "홍길동";
		f1.friendPhone = "010-1111-1111";
		f1.friendBirth = "1999-04-05";

		Friend f2 = new Friend();
		f2.friendName = "김민수";
		f2.friendPhone = "010-2222-2222";
		f2.friendBirth = "1999-08-08";

		Friend f3 = new Friend();
		f3.friendName = "최두식";
		f3.friendPhone = "010-3333-3333";
		f3.friendBirth = "1999-09-09";

		storage[0] = f1;
		storage[1] = f2;
		storage[2] = f3;
	}
} // end of class.
