package com.yedam.ref.app;

import java.util.Scanner;

/*
 * 회원 추가,수정,삭제,조회 기능.
 * 1)추가
 *   - 아이디,이름,전화번호,포인트
 * 2)수정
 *   - 아이디 
 *   - 전화번호 (바뀔항목)
 * 3)삭제
 *   - 아이디
 * 4)조회
 *   - 이름 (조회)
 */

public class MemberExe {
	public static void main(String[] args) {
		boolean run = true; // 반복문 실행/종료
		Member[] members = new Member[10]; // 저장공간으로 배열을 선언.

		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>> ");

			int selectNo = Integer.parseInt(scn.nextLine());

			switch (selectNo) {
			case 1: // 추가.
				System.out.print("아이디를 입력>> ");
				String id = scn.nextLine();
				System.out.print("이름를 입력>> ");
				String name = scn.nextLine();
				System.out.print("전화번호를 입력>> ");
				String telNo = scn.nextLine();
				System.out.print("포인트를 입력>> ");
				int point = Integer.parseInt(scn.nextLine());
				// 멤버변수 선언과 값 할당.
				Member member = new Member();
				member.memberId = id;
				member.memberName = name;
				member.phone = telNo;
				member.point = point;

				// 배열에 추가.
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member;
						System.out.println("등록완료.");
						break; // 한건을 추가했으면 반복문 종료.
					}
				}
				break; // switch의 case 1 종료.

			case 2: // 수정.
				System.out.print("아이디를 입력>> ");
				id = scn.nextLine();
				System.out.print("전화번호를 입력>> ");
				telNo = scn.nextLine();

				// 같은 값을 찾아서 변경하기.
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						if (members[i].memberId.equals(id)) {
							members[i].phone = telNo;
							System.out.println("수정완료.");
						}
					}
				}
				break;

			case 3: // 삭제.
				System.out.print("아이디를 입력>> ");
				id = scn.nextLine();

				// 같은 값을 찾아서 삭제하기.
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						if (members[i].memberId.equals(id)) {
							members[i] = null;
							System.out.println("삭제완료.");
						}
					}
				}
				break;

			case 4: // 조회.
				System.out.print("이름를 입력>> ");
				name = scn.nextLine();

				// 조회.
				System.out.printf("%-10s %-5s %-15s\n", "UserId", "회원명", "TelNo");
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null && (name.equals("") || name.equals(members[i].memberName))) {
						System.out.printf("%-10s %-5s %-15s\n", members[i].memberId, members[i].memberName,
								members[i].phone);
					}
				}
				break;

			case 5: // 종료.
				run = false;
				break;

			default:
				System.out.println("메뉴를 다시 선택하세요.");

			}

		} // end of while.
		System.out.println("*** end of prog ***");

	} // end of main.
}
