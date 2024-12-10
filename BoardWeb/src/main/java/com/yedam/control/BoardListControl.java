package com.yedam.control;

import java.io.IOException;
import java.util.List;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList();

		req.setAttribute("list", list);
		// 요청재지정.
		req.getRequestDispatcher("html/boardList.jsp").forward(req, resp);

	}

}
