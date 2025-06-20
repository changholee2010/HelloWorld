package com.yedam.collection.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 배열활용해서 저장 -> 컬렉션(ArrayList)를 활용해서 저장.
 * 2025.05.23 
 */
public class MemberExe {
	public static void main(String[] args) {
		boolean run = true; // 반복문 실행/종료
//		Member[] members = new Member[10]; // 저장공간으로 배열을 선언.
		List<Member> members = new ArrayList<>();

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
				Member member = new Member(id, name, telNo, point);
//				member.setMemberId(id);
//				member.setMemberName(name);
//				member.setPhone(telNo);
//				member.setPoint(point);

				// arraylist에 추가.
				if (members.add(member)) {
					System.out.println("등록성공");
				}

				break; // switch의 case 1 종료.

			case 2: // 수정.
				System.out.print("아이디를 입력>> ");
				id = scn.nextLine();
				System.out.print("전화번호를 입력>> ");
				telNo = scn.nextLine();

				// 같은 값을 찾아서 변경하기.
				for (int i = 0; i < members.size(); i++) {
					// members[i]
					if (members.get(i).getMemberId().equals(id)) {
						members.get(i).setPhone(telNo);
						System.out.println("수정완료.");
					}
				}
				break;

			case 3: // 삭제.
				System.out.print("아이디를 입력>> ");
				id = scn.nextLine();

				// 같은 값을 찾아서 삭제하기.
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberId().equals(id)) {
						members.remove(i);
						System.out.println("삭제완료.");
					}
				}
				break;

			case 4: // 조회.
				System.out.print("이름를 입력>> ");
				name = scn.nextLine();

				// 조회.
				System.out.printf("%-10s %-5s %-15s\n", "UserId", "회원명", "TelNo");
				for (int i = 0; i < members.size(); i++) {
					if (name.equals("") || name.equals(members.get(i).getMemberName())) {
						System.out.printf("%-10s %-5s %-15s\n"//
								, members.get(i).getMemberId()//
								, members.get(i).getMemberName()//
								, members.get(i).getPhone());
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
