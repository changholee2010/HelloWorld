package com.yedam.variable;

import java.util.Scanner;

public class TodoExe3 {
	public static void main(String[] args) {
		String[] names = { "박창석", "홍영민", "김익수", "이화영" };

		Scanner scn = new Scanner(System.in);
		System.out.print("친구이름을 입력하세요>>> ");
		String search = scn.nextLine();

		boolean isExists = false;
		for (int i = 0; i < names.length; i++) {
			isExists = names[i].equals(search);
			if (isExists) {
				break;
			}
		}

		if (isExists) {
			System.out.printf("입력한 이름 %10s이(가) 존재합니다 나이는 %2d입니다.\n", search, 10);
		} else {
			System.out.printf("입력한 이름 " + search + "이(가) 없습니다");
		}

		// "입력한 이름이 존재합니다", "입력한 이름이 없습니다"
		System.out.println("end of prog.");
	}
}
