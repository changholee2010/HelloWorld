package com.yedam.ref;

import java.util.Scanner;

// 혼공자 223페이지 연습문제6번.
// 답은 여러분들이 만들어보세요.
// TodoExe클래스를 만들어서 여기다가 작성하세요.
public class TodoExe {
	static Student[] scores = null; // 학생점수저장.

	public static void main(String[] args) {
		init(); // 초기데이터 생성.

		boolean run = true; // 반복문 실행/종료
		int studentNum = 0; // 학생수
		Scanner scanner = new Scanner(System.in);
		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트(성별) 4.분석 5.종료");
			System.out.println("--------------------------------------------");
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
//					Double.parseDouble("175.6"); 문자를 실수타입으로 변환.
					System.out.printf("scores[%d] 키>> ", i);
					double height = Double.parseDouble(scanner.nextLine());
					System.out.printf("scores[%d] 성별>> ", i);
					String gender = scanner.nextLine(); // 성별저장.
					Gender gen = Gender.MALE;
					if (gender.equals("남") || gender.equals("남자")) {
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}

					// 인스턴스 생성.
					Student student = new Student();
					student.studentName = name;
					student.score = score;
					student.height = height;
					student.gender = gen;

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
				System.out.print("검색조건 ex)남 또는 여 >> ");
				String keyword = scanner.nextLine(); // "남", "여", "엔터"
				Gender gen = Gender.MALE; // 초기화.
				if (keyword.equals("남") || keyword.equals("남자") //
						|| keyword.equals("Men") || keyword.equals("M")) {
					gen = Gender.MALE;
				} else if (keyword.equals("여") || keyword.equals("여자")//
						|| keyword.equals("Women") || keyword.equals("W")) {
					gen = Gender.FEMALE;
				}
				// "이름, 점수" 출력.
				for (int i = 0; i < scores.length; i++) {
					if (keyword.equals("") || gen == scores[i].gender) {
						System.out.printf("scores[%d]> %s %d \n", i, scores[i].studentName, scores[i].score);
					}
				}

			} else if (selectNo == 4) { // 분석(최고큰 키, 평균)
				double max = 0;
				int sum = 0; // 최고점수, 합계 변수선언.
				double avg = 0; // 평균 변수 선언.
				Student maxStd = new Student(); // 최고점수를 받은 학생의 정보를 저장.

				for (int i = 0; i < scores.length; i++) {
					sum += scores[i].score; // 점수 누적.
					if (max < scores[i].height) {
						max = scores[i].height;
						// 최대값 저장.
						maxStd.score = scores[i].score; // 점수.
						maxStd.studentName = scores[i].studentName; // 이름.
						maxStd.height = scores[i].height; // 키.
						maxStd.gender = scores[i].gender; // 성별.

					}
				}
				avg = 1.0 * sum / scores.length;
				System.out.printf("학생이름:%s, 키: %.1f\n평균점수: %.2f\n", maxStd.studentName, maxStd.height, avg);

			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	} // end of main.

	public static void init() {
		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE; // "남자", "Men",

		Student s2 = new Student(); // 인스턴스 생성.
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;

		Student s3 = new Student(); // 인스턴스 생성.
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.3;
		s3.gender = Gender.MALE;

		// 초기데이터.
		scores = new Student[] { s1, s2, s3 };

	}
}
