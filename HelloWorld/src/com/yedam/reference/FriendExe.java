package com.yedam.reference;

import java.util.Scanner;

public class FriendExe {
	public static void main(String[] args) {
		String name = new String("홍길동"); // "홍길동";
		int age = 20;

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

		Friend[] myFriends = { f1, f2, f3 };

//		System.out.println(myFriends[0].friendName); // 홍길동.
//		System.out.println(myFriends[0].friendPhone); // 010-1111-1111.
//		System.out.println(myFriends[0].friendBirth); // 1999-04-05

		// 이름 => 이름, 연락처, 생년월일 출력.
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String searchName = "";

		while (run) {
			// 1.사용자의 입력값을 searchName에 저장.
			System.out.print("검색할 이름 입력>>> ");
			searchName = scn.nextLine();
			if (searchName.equals("quit")) {
				break; // while 반복문 종료.
			}
			// 2.searchName의 값을 myFriends배열에서 검색.
			boolean isExists = false;
			int idx = -1;
			for (int i = 0; i < myFriends.length; i++) {
				isExists = myFriends[i].friendName.equals(searchName);
				if (isExists) {
					idx = i;
					break;
				}
			}
			// 3.찾는 이름이 있으면 이름과 점수 출력.
			// 4.없으면 "찾는 이름 없음" 출력.
			if (isExists) {
				System.out.println(myFriends[idx].friendName + ", "//
						+ myFriends[idx].friendPhone + ", " //
						+ myFriends[idx].friendBirth);

			} else {
				System.out.println("찾는 이름 없음");

			}
			// 3.찾는 이름이 있으면 이름, 연락처, 생년월일 출력.
			// 4.없으면 "찾는 이름 없음" 출력.
			// 5.입력값이 quit이면 while반복문 종료.

		}
		System.out.println(">>프로그램 끝<<");

	} // end of main().
} // end of class.
