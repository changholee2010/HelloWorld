package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시글 번호 15번에 대한 조회결과 html/modifyForm.jsp 출력.
		// 수정항목은 제목, 내용으로 제한.
		String bno = req.getParameter("board_no"); // 9글
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 글번호 상세정보 반환.

		// 조회한 board정보를 jsp페이지에 전달.
		req.setAttribute("board", bvo);
		req.getRequestDispatcher("html/modifyForm.jsp").forward(req, resp);
	}

}
