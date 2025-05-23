package com.yedam.api;

public class StringUtil {
	// 1.성별
	static String getGender(String ssn) {//
		int pos = -1;// 성별 문자의 위치.
		pos = ssn.length() - 7; // 14-7=7
		// 남성/여성 판별.
		char gNo = ssn.charAt(pos);
		switch (gNo) {
		case '1':
		case '3':
			return "남성";
		case '2':
		case '4':
			return "여성";
		default:
			return "알수없음";
		}
	}

	// 2.파일명
	static String getFileName(String file) {
		return getFileName1(file);
	}

	// 3.파일확장자
	static String getExtName(String file) {
		String ext = file.substring(file.indexOf(".") + 1);
		return ext;
	}

	// indexOf만 활용하기.
	static String getFileName1(String file) {
		int pos = 0; // 인덱스를 구하기 위한 시작점.
		String fileName = "";
		// "c:/temp/orange.jpg"
		while (true) {
			int idx = file.indexOf("/", pos); // 찾을 값, 찾을 위치의 시작값.
			// "/" 가 여러개일 경우에 마지막 이후부터가 파일명이기 때문에 마지막 위치 찾기.
			if (idx == -1) {
				//fileName = file.substring(pos, file.indexOf(".")); // 파일명만 구하기.
				fileName = file.substring(pos); // 확장자까지 구하기.
				break;
			}
			pos = idx + 1;// 다음 문자를 찾을 위치를 지정.
		}
		return fileName;
	}

	// lastIndexOf를 활용하기.
	static String getFileName2(String file) {
		String fileName = "";
		fileName = file.substring(file.lastIndexOf("/") + 1);
		return fileName;
	}
}
