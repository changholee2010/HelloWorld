package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// GET방식: 조회 vs. POST방식: 등록.

		BoardDAO bdao = new BoardDAO();
		if (req.getMethod().equals("GET")) {
			// 파라미터(board_no);
			String bno = req.getParameter("board_no");
			BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건조회.

			req.setAttribute("board", bvo); // board의 속성에 조회된 결과를 전달.
			req.getRequestDispatcher("html/board.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			// 파라미터(title, content, writer);
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);

			if (bdao.insertBoard(board)) {
				// 목록이동.
				resp.sendRedirect("boardList.do"); // 페이지재지정.
			} else {
				// 등록화면으로 이동.
				req.getRequestDispatcher("html/boardForm.jsp").forward(req, resp);
			}

		}
	}

}
