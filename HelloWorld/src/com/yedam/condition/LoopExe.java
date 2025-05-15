package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {

	// "가위(1)","바위(2)","보(3)"
	// 1,2,3 <==> 가위(1), 바위(2), 보(3) , 종료(4)
	public static void main(String[] args) {
		game2();
	}

	// case별로 비교(가위, 바위, 보 의 각 경우에 이기는 경우와 지는 경우).
	public static void game1() {
		// "You lost", "You win", "Same"
		Scanner scn = new Scanner(System.in);
		while (true) {
			// computer가 제출한 값.
			int systemValue = (int) (Math.random() * 3) + 1;
			System.out.println("\n가위(1), 바위(2), 보(3) 입력. 종료는 4");
			System.out.print("선택>> ");
			// 내가 제출한 값.
			int myValue = Integer.parseInt(scn.nextLine());
			// 종료를 선택한 경우.
			if (myValue == 4) {
				System.out.println("종료합니다.");
				break;
			}
			// 가위, 바위, 보를 선택한 경우.
			if (systemValue == myValue) {
				System.out.println("You Same.");
				continue; // 아래코드를 실행하지 않고 반복문의 처음으로.
			}
			// 이기는 경우: -1, 2 인 경우.
			// 지는 경우: -1, 1 인 경우.
			if (systemValue == 1) { // computer:가위
				if (myValue == 2) {
					System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
				} else {
					System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
				}
			} else if (systemValue == 2) {// computer:바위
				if (myValue == 3) {
					System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
				} else {
					System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
				}
			} else if (systemValue == 3) {// computer:보
				if (myValue == 1) {
					System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
				} else {
					System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
				}
			} // end of if.

		} // end of while.
		System.out.println("end of prog.");
	} // end of game1.

	// 가위, 바위, 보의 각 값에 대한 차이를 활용한 경우.
	public static void game2() {
		// "You lost", "You win", "Same"
		Scanner scn = new Scanner(System.in);
		while (true) {
			int systemValue = (int) (Math.random() * 3) + 1;
			System.out.println("\n가위(1), 바위(2), 보(3) 입력. 종료는 4");
			System.out.print("선택>> ");
			int myValue = Integer.parseInt(scn.nextLine());
			// 종료를 선택한 경우.
			if (myValue == 4) {
				System.out.println("종료합니다.");
				break;
			}
			// 가위, 바위, 보를 선택한 경우.
			int diff = systemValue - myValue;
			if (diff == 0) {
				System.out.println("You Same.");
				continue;
			}
			// 이기는 경우: -1, 2 인 경우.
			// 지는 경우: 2, 1 인 경우.
			if (diff == -1 || diff == 2) {
				System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
			} else {
				System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
			}
		} // end of while.
		System.out.println("end of prog.");
	} // end of game2.

	public static void test() {
		// while vs. do .. while
		boolean run = false;

		// while (run) {
		// System.out.println("while문");
		// run = !run;
		// }

		do {
			System.out.println("while문");
			run = !run;
		} while (run);

		System.out.println("end of prog.");

	}
}