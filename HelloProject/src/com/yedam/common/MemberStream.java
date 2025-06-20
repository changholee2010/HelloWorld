package com.yedam.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Member;

public class MemberStream {
	List<Member> storage = new ArrayList<>();

	public MemberStream() {
		init(); // 파일을 읽어 초기값을 활성화.
	}

	// 등록.
	public boolean insert(Member member) {
		return storage.add(member);
	}

	// 수정.
	public boolean update(Member member) {
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getMemberId().equals(member.getMemberId())) {
				storage.get(i).setPhone(member.getPhone());
				return true;
			}
		}
		return false;
	}

	// 삭제.
	public boolean delete(String memberId) {
		for (int i = 0; i < storage.size(); i++) {
			if (storage.get(i).getMemberId().equals(memberId)) {
				storage.remove(i);
				return true;
			}
		}
		return false;
	}

	// 목록.
	public List<Member> list() {
		return storage;
	}

	// 초기화.
	public void init() {
		try {
			InputStream is = new FileInputStream("c:/temp/member.db");
			ObjectInputStream ois = new ObjectInputStream(is);
			storage = (List<Member>) ois.readObject();
			ois.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 종료.
	public void save() {
		try {
			OutputStream os = new FileOutputStream("c:/temp/member.db");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(storage);
			oos.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
