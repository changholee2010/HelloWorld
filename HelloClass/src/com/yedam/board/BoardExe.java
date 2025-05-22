package com.yedam.board;

import java.util.Scanner;

import com.yedam.Calendar;

/*
 * 추가(addBoard)
 * /수정(modifyBoard) - 글번호, 바뀔내용, 바뀔제목
 * /삭제(removeBoard) - 글번호
 * /목록(boardList) - 상세화면 조회
 * /조회기능(getBoard) - 글번호 -> 글반환
 * /순번부여(nextSequence) - 현재글번호 + 1
 */

public class BoardExe {
	// 필드.
	private Board[] boards = new Board[100]; // 데이터 저장.
	private Scanner scn = new Scanner(System.in);
	private int bno = 2; // 배열인덱스를 2지정.

	// 생성자.
	public BoardExe() {
//		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 좋습니다.", "오늘 기온이 30도입니다", "홍길동");
		boards[1] = new Board(11, "자바가[11] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[2] = new Board(12, "자바가[12] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[3] = new Board(13, "자바가[13] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[4] = new Board(14, "자바가[14] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[5] = new Board(15, "자바가[15] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[6] = new Board(16, "자바가[16] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[7] = new Board(17, "자바가[17] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[8] = new Board(18, "자바가[18] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[9] = new Board(19, "자바가[19] 힘들어요", "자바는 힘들지 않아요...", "김민규");
		boards[10] = new Board(20, "자바가[20] 힘들어요", "자바는 힘들지 않아요...", "김민규");
	}

	// loginCheck()
	boolean loginCheck() {
		// 3번 기회. 숙제. 2025년 05월 21일.
		// 아이디 입력.
		// 비밀번호 입력.
		for (int i = 1; i <= 3; i++) {
			String id = userMessage("아이디를 입력");
			String pw = userMessage("비밀번호를 입력");
			// 로그인 성공하면...
			if (!UserExe.login(id, pw)) {
				System.out.println("아이디와 비밀번호를 확인하세요.");
				if (i == 3) {
					System.out.println("3번 실패했습니다. 종료합니다.");
					return false;
				}
				continue;
			} // 실패의 경우.
//		    로그인을 성공하면 언제라도 반복문을 빠져 나와서 아래 코드를 실행.
			return true;
		} // 3번의 기회를 제공.
		return false;
	} // end of loginCheck().

	// 메소드.
	void execute() {
		if (!loginCheck()) {
			return; // execute()메소드의 종료.
		}
		System.out.println("환영합니다!!!");

		boolean run = true;
		while (run) {
			System.out.println("--------------------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("--------------------------------------");
			System.out.print("선택>> ");
			// 문자를 숫자 변경 예외발생.
			int selectNo = 0;
			// 예외처리.
			try {
				selectNo = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("1 ~ 5번중에 선택.");
				continue;
			}
			switch (selectNo) {
			case 1: // 추가.
				addBoard();
				break;
			case 2: // 수정.
				modifyBoard();
				break;
			case 3: // 삭제.
				removeBoard();
				break;
			case 4: // 목록.
				boardList();
				break;
			case 5: // 종료.
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			} // end of switch.
		} // end of while.
		System.out.println(" ** end of prog. ** ");
	} // end of execute.

	// 기능.
	// "글번호를 입력하세요>> " 1
	// "제목을 입력하세요>> " 오늘은 덥네요.
	// "내용을 입력하세요>> " 오늘 기온이 30도가 넘습니다.......
	// "작성자를 입력하세요>> " 홍길동
	// "추가성공"/ "추가실패" 메세지출력.
	void addBoard() {
		int no = nextSequence();// Integer.parseInt(userMessage("글번호를 입력하세요"));
		String title = userMessage("제목을 입력하세요");
		String content = userMessage("내용을 입력하세요");
		String writer = userMessage("작성자를 입력하세요");

		// Board인스턴스 선언하고 값을 지정.
		Board board = new Board(no, title, content, writer);

		// 배열에 저장.
		boards[bno++] = board;
		System.out.println("추가성공");
	} // end of addBoard.

	/* 기능 */
	// 글번호 제목 작성자
	// ==============================
	// 1 날씨가 좋아요 홍길동
	// 2 클래스 멋짐! 김민규
	// 3 자바어려움 박석민
	// 4 그래도 열심히!! 김민규
	// ------------------------------
	// 상세보기: 글번호입력, 메뉴로 이동(q)
	// ------------------------------

	// ** 등록된 글이 없습니다 **
	void boardList() {
//		sort();
		int page = 1;
		// while반복.
		while (true) {
			int start = (page - 1) * 5;
			int end = page * 5;
			System.out.println("글번호     제목          작성자");
			System.out.println("==============================");
			for (int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
				}
			}
			// 상세보기.
			System.out.println("------------------------------");
			System.out.println("상세보기: 글번호입력,(이전:p)/ (다음:n) 메뉴로 이동(q)");
			System.out.println("------------------------------");
			System.out.print("선택>> ");
			String str = scn.nextLine();
			// 메뉴,상세
			if (str.equals("q")) {
				break;// return;
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("p")) {
				page--;
			} else {
				// 글번호외에 다른 문자가 들어오면...예외처리.
				int no = 0;
				try {
					no = Integer.parseInt(str); // 글번호입력.
				} catch (NumberFormatException e) {
					System.out.println("목록에 있는 글번호를 선택하세요.");
					continue; // 다시 목록부터 보여주기.
				}
				// 배열에서 조회.
				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회결과 없습니다.");
					return;
				}
				sboard.showAllInfo(); // 상세보기.
			}
		} // end of while.
		System.out.println();
	} // end of boardList.

	// 수정.
	void modifyBoard() {
		int bno = userMenu("수정할 글번호 입력");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}
		String title = userMessage("수정할 제목 입력");
		String content = userMessage("수정할 내용 입력");
		// 제목과 내용 변경.
		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정 완료.");

	} // end of modifyBoard.

	// 삭제.
	void removeBoard() {
		int bno = userMenu("삭제할 글번호 입력");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null;
				System.out.println("삭제 완료.");
			}
		}
	} // end of removeBoard().

	// 단건조회(getBoard)
	// 글번호를 활용해서 배열에서 조회하고 Board 반환.
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		}
		return null; // 조건에 맞는 글번호 없으면 null 반환.
	} // end of getBoard.

	// 사용자의 입력값을 반환.
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}

	int userMenu(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	}

	// 순번생성.
	int nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		}
		return max + 1;
	}

	void sort() {
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.

} // end of class.
