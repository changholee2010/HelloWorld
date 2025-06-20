package com.yedam.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String page = req.getParameter("page");
		page = page == null ? "1" : page; // boardList.do => 1페이지 출력.
		String sc = req.getParameter("searchCondition");
		sc = sc == null ? "" : sc; // null값이 경우.
		String kw = req.getParameter("keyword");
		kw = kw == null ? "" : kw;
		kw = URLDecoder.decode(kw); // 16진수 -> 한글
		// 검색조건.
		SearchDTO search = new SearchDTO();
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		// 데이터처리.
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		// 페이징 계산.
		int totalCnt = svc.getTotalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		// jsp페이지에 정보 전달.
		req.setAttribute("blist", list); // 요청정보에 값을 담아서 전달.
		req.setAttribute("pageInfo", paging);
		req.setAttribute("search", search);
		// 요청재지정(페이지이동) admin/board/
		HttpSession session = req.getSession();
		String auth = (String) session.getAttribute("auth");
		if (auth != null && auth.equals("User")/* 일반사용자 */) {
			req.getRequestDispatcher("user/boardList.tiles").forward(req, resp);
		} else if (auth != null && auth.equals("Admin")/* 관리자 */) {
			req.getRequestDispatcher("admin/board/boardList.tiles").forward(req, resp);
		} else {
			req.getRequestDispatcher("user/boardList.tiles").forward(req, resp);
		}
	}

}
