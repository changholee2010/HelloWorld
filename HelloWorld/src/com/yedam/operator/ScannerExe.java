package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 계좌의 금액.
		// 조건추가..10만원을 초과(X), 마이너스금액(x)
		while (true) {
			System.out.println("\n1.입금 2.출금 3.잔액 4.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); // Integer.parseInt("30");
			int money = 0; // 사용자입금을 처리하기 위한 변수.
			if (menu == 1) {
				System.out.print("입금액을 입력>> ");
				// 입금기능구현.
				money = Integer.parseInt(scn.nextLine());
				if (balance + money > 100000) { // 합산이 10만원 초과.
					System.out.println("10만원을 초과하므로 입금을 할 수 없습니다.");
				} else {
					balance = balance + money;
					System.out.printf("%d원을 입금했습니다.\n", money);
				}

			} else if (menu == 2) {
				System.out.print("출금액을 입력>> ");
				// 출금기능구현.
				money = Integer.parseInt(scn.nextLine());
				if (balance < money) { // 합산이 10만원 초과.
					System.out.println("잔액을 초과하여 출금할 수 없습니다.");
				} else {
					balance = balance - money;
					System.out.printf("%d원을 출금했습니다.\n", money);
				}

			} else if (menu == 3) {
				System.out.printf("현잔액>> %d원\n", balance);

			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("1 ~ 4번중에 선택하세요.");
			}
		} // end of while.
		System.out.println("end of prog.");
	} // end of main.

}
