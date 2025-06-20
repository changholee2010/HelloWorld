package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		// http://localhost:8080/BoardWeb/board.do?bno=22
		String bno = req.getParameter("bno");
		// 추가파라미터.(page,searchCondition,keyword)
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		// 글상세조회.
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		// 요청정보 저장.
		req.setAttribute("board", board); // attribute의 "board" 속성으로 저장.
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		// 요청재지정(페이지이동)
		req.getRequestDispatcher("user/board.tiles").forward(req, resp);
	}

}
