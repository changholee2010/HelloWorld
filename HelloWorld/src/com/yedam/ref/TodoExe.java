package com.yedam.ref;

import java.util.Scanner;

// 혼공자 223페이지 연습문제6번.
// 답은 여러분들이 만들어보세요.
// TodoExe클래스를 만들어서 여기다가 작성하세요.
public class TodoExe {
	public static void main(String[] args) {
		boolean run = true; // 반복문 실행/종료
		int studentNum = 0; // 학생수
		Student[] scores = null; // 학생점수저장.
		Scanner scanner = new Scanner(System.in);
		while (run) {
			System.out.println("---------------------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scanner.nextLine());
			// 배열의 선언없이 메뉴를 선택할 경우에는 NullPointer예외.
			if (selectNo == 2 || selectNo == 3 || selectNo == 4)
				if (scores == null) {
					System.out.println("학생수를 지정하세요.");
					continue;
				}

			if (selectNo == 1) { // 학생수 지정.
				System.out.print("학생수>> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new Student[studentNum]; // 배열의 크기지정.

			} else if (selectNo == 2) { // 점수입력.

				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d] 이름>> ", i);
					String name = scanner.nextLine(); // 이름저장.
					System.out.printf("scores[%d] 점수>> ", i);
					int score = Integer.parseInt(scanner.nextLine());

					// 인스턴스 생성.
					Student student = new Student();
					student.studentName = name;
					student.score = score;

					scores[i] = student; // 배열에 저장.
				}

			} else if (selectNo == 3) { // 목록.
				// 배열의 합이 0이면 점수입력하세요.
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score; // 점수 누적.
				}
				// 점수입력하도록 메세지 보여주기.
				if (sum == 0) {
					System.out.println("점수를 입력하세요.");
					continue;
				}
				// "이름, 점수" 출력.
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> %s %d \n", i, scores[i].studentName, scores[i].score);
				}

			} else if (selectNo == 4) { // 분석(최고점수, 평균)
				int max = 0, sum = 0; // 최고점수, 합계 변수선언.
				double avg = 0; // 평균 변수 선언.
				Student maxStd = new Student(); // 최고점수를 받은 학생의 정보를 저장.
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score; // 점수 누적.
					if (max < scores[i].score) {
						max = scores[i].score;
						maxStd.score = scores[i].score;
						maxStd.studentName = scores[i].studentName;
					}
				}
				avg = 1.0 * sum / scores.length;
				System.out.printf("학생이름:%s, 최고점수: %d\n평균점수: %.2f\n", maxStd.studentName, maxStd.score, avg);

			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
