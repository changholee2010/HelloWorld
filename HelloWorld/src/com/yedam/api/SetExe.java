package com.yedam.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * hashCode() 메소드의 오버라이딩.
 */
public class SetExe {
	public static void main(String[] args) {

		// Map 컬렉션. 키 & 값을 저장.
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김길동");
		map.put(300, "최길동");

		String result = map.get(100); // 키 => 값 을 반환.
		System.out.println(result);

		Set<Integer> kset = map.keySet(); // 키값들을 set 에 반환.
		for (Integer key : kset) {
			System.out.printf("key: %d, value: %s\n", key, map.get(key));
		}

		System.out.println("end of prog.");

	}

	public void set() {
		// Set => 중복된 값은 저장X.
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student(1001, "홍길동", 80));
		students.add(new Student(1002, "김민동", 70));
		students.add(new Student(1003, "최우동", 60));
		students.add(new Student(1004, "박길돈", 50));
		students.add(new Student(1001, "홍길동", 80));

		for (Student std : students) {
			System.out.println(std);
		}

		HashSet<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		set.add("Hello");

		// 중복값은 저장X.
		for (String str : set) {
			System.out.println(str);
		}
	}

	public void arrayList() {
		// Student 객체.
		ArrayList<Student> students = new ArrayList<Student>();

		students.add(new Student(1001, "홍길동", 80));
		students.add(new Student(1002, "김민동", 70));
		students.add(new Student(1003, "최우동", 60));
		students.add(new Student(1004, "박길돈", 50));
		students.add(new Student(1001, "홍길동", 80));

		for (Student std : students) {
			if (std.getScore() > 50) {
				System.out.println(std);
			}
		}

		ArrayList<String> strList = new ArrayList<String>();
		strList.add("Hello");
		strList.add("World");
		strList.add(0, "Nice");

		strList.remove(1);

		System.out.println("strList의 크기 " + strList.size());

		// 조회.
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i)); // strList[0]
		}
	}

	// 코드백업.
	public void list() {
		// Collection -> List(인덱스 저장), Set(집합), Map(키, 값)

		ArrayList<String> list = new ArrayList<String>();
		list.add("apple"); // [0]
		list.add("orange"); // [1]
//				list.add(10); // [2]
		String v1 = list.get(0); // Object -> String
//				int v2 = (Integer) list.get(2); // Object -> Integer

		// 컴파일 시점에 에러 발생.
		// 실행에러보다는 컴파일에러가 유리.
		for (int i = 0; i < list.size(); i++) {
			String result = list.get(i);
		}
	}
}
