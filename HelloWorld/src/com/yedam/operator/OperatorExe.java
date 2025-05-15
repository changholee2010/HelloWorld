package com.yedam.operator;

public class OperatorExe {

	public static void main(String[] args) {
		test4();
	}

	public static void test5() {
		String pass = "";
		int score = (int) (Math.random() * 100);
//		if (score >= 60) {
//			if (score >= 80) {
//				pass = "우수";
//			} else {
//				pass = "합격";
//			}
//		} else {
//		    if (score < 20) {
//			    pass = "불불합격";
//	        } else {
//	        	pass = "불합격";
//	        }
//		}
		// 삼항연산자로 변경.
		pass = (score >= 60) ? (score >= 80) ? "우수" : "합격" : "불합격";
		System.out.printf("%d점은 %s\n", score, pass);
	}

	// "월" 정보를 입력하면 "공란" 반환하는 메소드. getSpace()
	public static int getSpace(int month) {
		int space = 0;
		if (month == 3) { // 3월달
			space = 6;
		} else if (month == 4) {// 4월달
			space = 2;
		} else if (month == 5) {// 5월달
			space = 4;
		} else if (month == 7) {// 7월달
			space = 2;
		}
		return space;
	} // end of getSpace.

	// "월" 정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;
	} // end of getLastDate.

	public static void test4() {
		int mon = 4; // 월정보입력...
		System.out.printf("           <%02d월>           ", mon);
		System.out.println("\nSun Mon Tue Wed Thu Fri Sat");
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);
		// 빈공간.
		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}
		// 날짜출력.
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day); // ___
			if ((day + space) % 7 == 0) {
				System.out.println();
			}
		}
	}

	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글(on -> off, off -> on)
		}
	}

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;
		System.out.printf("num1 => %d, num2 => %d, result => %d", num1, num2, result);

		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("참입니다.");
		}
		// == 부정은 !=, > 부정은 <=, >= 부정은 < .
		result = 30;
		if (!(result != 30)) {
			System.out.println("\nresult 는 30보다 작거나 같다.");
		}

		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 => %d", num1);
		}
	}

	// 연습2. byte,short,long,int,char
	public static void test1() {
		byte num1 = 127;
		byte num2 = 1;
		byte sum = (byte) (num1 + num2); // 정수연산의 기본 int.
		System.out.println(sum);

		long num3 = 10000000000L;
		long num4 = 100L;
		System.out.println(Integer.MAX_VALUE); // 2147483647
	}

	// 연습1.
	public static void test() {
		// 증가, 감소 연산자 (++, --)
		byte num1 = -128;
		num1 = 127;
		num1++;
		System.out.println(num1);

		char ch1 = 'A'; // 65
		ch1 = 66;
		ch1 = 'A';
		ch1 = 'a';
		ch1 = '가';
		ch1 = 0x29D7;
		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);
		}
	}
}
