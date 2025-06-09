package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)//
			throws ServletException, IOException {
		// TODO forward 페이지이동.
//		req.setAttribute("myName", "Hongkildong");
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();

		req.setAttribute("blist", list); // 요청정보에 값을 담아서 전달.

		// 요청재지정(페이지이동)
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
	}

}
