package com.yedam.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)//
			throws ServletException, IOException {

		// 한글처리.
		req.setCharacterEncoding("utf-8");

		// 요청방식 (GET/ POST) 구분 처리.
		if (req.getMethod().equals("GET")) {

			// WEB-INF/jsp/addBoard.jsp
			req.getRequestDispatcher("user/addBoard.tiles").forward(req, resp);

		} else if (req.getMethod().equals("POST")) { // 등록.
			// POST 요청.
			// addBoard.serv?title=제목&content=내용&writer=user01
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			// 메소드의 매개값.
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);

			// 업무 서비스.
			BoardService svc = new BoardServiceImpl();
			if (svc.registerBoard(board)) {
				System.out.println("등록성공.");
				// 목록페이지로 이동.
				resp.sendRedirect("boardList.do");
			} else {
				System.out.println("등록실패.");
			}
		} // end of if.

	} // end of exec.

} // end of class.
