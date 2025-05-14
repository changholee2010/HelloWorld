package com.yedam;

// ctrl+shft+f 
public class HelloJava {
	public static void main(String[] args) {
		// int(정수), double(실수), boolean(참거짓)
		int num1 = 10; // 초기화.
		double num2 = 20; // 자동형변환(promotion)

		num1 = (int) num2; // 강제형변환(casting)

		int num3 = 100;
		double num4 = 200;
		double result = (double) num3 + num4;
		System.out.println("결과는 " + result);

		// 20 + 30 => 50
		System.out.println("결과는 " + (20 + 30));
	}
}
