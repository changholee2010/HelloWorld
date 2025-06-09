package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class RemoveControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		// 글상세조회.
		BoardService svc = new BoardServiceImpl();
		svc.getBoard(Integer.parseInt(bno));
		// ......
		// 요청재지정(페이지이동)
		resp.sendRedirect("boardList.do");

	}

}