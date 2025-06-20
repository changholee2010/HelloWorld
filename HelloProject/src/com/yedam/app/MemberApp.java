package com.yedam.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceStream;
import com.yedam.vo.Member;

/*
 * 사용자의 입력값을 등록,수정,삭제,목록 기능을 실행.
 */
public class MemberApp {
	public void execute() {
		Scanner scn = new Scanner(System.in);
		MemberService svc;

		// 2개중에 선택해서 기능을 실행할 수 있음.
		svc = new MemberServiceStream(); // 1) 파일에 저장.
//		svc = new MemberServiceDAO(); // 2) DB에 저장.

		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.회원등록 2.정보수정 3.회원삭제 4.목록보기 5.종료");
			System.out.print("선택>> ");
			// 메뉴선택.
			int menu = scn.nextInt();
			scn.nextLine();
			switch (menu) {
			case 1: // 등록.
				System.out.print("회원아이디>> ");
				String mid = scn.nextLine();
				System.out.print("회원이름>> ");
				String name = scn.nextLine();
				System.out.print("연락처>> ");
				String phone = scn.nextLine();
				System.out.print("포인트>> ");
				String point = scn.nextLine();
				// parameter(Member)
				Member member = new Member(mid, name, phone, Integer.parseInt(point));
				if (svc.addMember(member)) {
					System.out.println("등록완료.");
				} else {
					System.out.println("등록실패.");
				}
				break;
			case 3: // 삭제.
				System.out.print("삭제할 회원아이디>> ");
				mid = scn.nextLine();
				if (svc.removeMember(mid)) {
					System.out.println("삭제완료.");
				} else {
					System.out.println("삭제실패.");
				}
				break;
			case 4: // 목록
				List<Member> list = svc.memberList();
				System.out.println("회원ID  회원이름  연락처");
				System.out.println("--------------------------");
				for (Member mbr : list) {
					System.out.printf("%-8s%-6s%-10s\n"//
							, mbr.getMemberId()//
							, mbr.getMemberName()//
							, mbr.getPhone()//
					);
				}
				System.out.println("---------- end -----------");
				break;
			case 5: // 종료.
				run = false;
				svc.save();
			} // end of switch.
		} // end of while.
		System.out.println("end of prog.");
		scn.close();
	} // end of execute.

}
