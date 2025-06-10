package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)//
			throws ServletException, IOException {
		// boardList.do?page=2&searchCondition=W&keyword=guest
		// TODO forward 페이지이동.
//		req.setAttribute("myName", "Hongkildong");
		String page = req.getParameter("page");
		page = page == null ? "1" : page; // boardList.do => 1페이지 출력.
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		// 검색조건.
		SearchDTO search = new SearchDTO();
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		search.setKeyword(kw);

		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		// 페이징 계산.
		int totalCnt = svc.getTotalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);

		req.setAttribute("blist", list); // 요청정보에 값을 담아서 전달.
		req.setAttribute("pageInfo", paging);
		req.setAttribute("search", search);

		// 요청재지정(페이지이동)
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
	}

}
