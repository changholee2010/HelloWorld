package com.yedam;

public class StudentAry {
	Student[] storage = new Student[10];
	int cnt = 0;

	void add(Student student) {
		storage[cnt++] = student;
	}

	void showList() {
		for (int i = 0; i < cnt; i++) {
			storage[i].introduce();
		}
	}
}
