package com.yedam.reference;

import java.util.Scanner;

/*
 * 배열활용 연습.
 * 작성일시: 2024.11.29
 * 작성자: 이창호
 * 
 * 수정일        수정자       수정내용
 * ------------------------------------------------------
 * 2024.11.29   홍길동     신규작업
 * 
 */

public class ArrayEx3 {
	public static void main(String[] args) {
		// 배열의 인덱스 활용(같은 순번에 있는 값들은 동일한 사람의 값)
		String[] names = { "홍길동", "김민수", "최두식" };
		int[] scores = { 80, 90, 70 };

		boolean run = true;
		Scanner scn = new Scanner(System.in);
		// 사용자 입력값. names[i].equals(searchName) 비교는 equals.
		String searchName = "";

		while (run) {
			// names 배열에서 사용자 입력한 이름 찾아서 이름과 점수 출력.
			// quit의 값을 입력하면 프로그램 종료.

			// 1.사용자의 입력값을 searchName에 저장.
			searchName = scn.nextLine();
			if (searchName.equals("quit")) {
				run = false;
			} else {
				// 2.searchName의 값을 names배열에서 검색.
				// 김민수 : 홍길동, 김민수, 최두식
				
				boolean isExists = false;
				int idx = -1;
				for (int i = 0; i < names.length; i++) {
					isExists = names[i].equals(searchName);
					if (isExists) {
						idx = i;
						break;
					}
				}
				// 3.찾는 이름이 있으면 이름과 점수 출력.
				// 4.없으면 "찾는 이름 없음" 출력.
				if (isExists) {
					System.out.println(names[idx] + ", " + scores[idx]);
				} else {
					System.out.println("찾는 이름 없음");
				}
			} // end of if구문.

			// 5.입력값이 quit이면 while반복문 종료.

		} // end of while.
		System.out.println("프로그램 종료");
	} // end of main.
} // end of class.
