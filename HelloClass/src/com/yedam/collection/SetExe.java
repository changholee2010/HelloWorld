package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		// Set컬렉션.
		Set<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("월요일");
		set.add("금요일");

		// 삭제.
		if (set.contains("홍길동")) {
			System.out.println(set.remove("홍길동"));
		}

		// 반복.
		Iterator<String> iter = set.iterator(); // 반복자 획득.
		while (iter.hasNext()) { // 반복요소의 여부체크.
			String result = iter.next();
			System.out.println(result);
		}

	}
}
