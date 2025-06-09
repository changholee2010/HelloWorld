package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

/*
 * M-V-Control역할.
 * url패턴 - 실행서블릿 관리.
 */
public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// boardList.do - 글목록 출력 기능.
		// 처리순서가 중요.
		map.put("/boardList.do", new BoardListControl()); //글목록.
		map.put("/board.do", new BoardControl()); //상세화면.
		map.put("/addBoard.do", new AddBoardControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url이 호출(http://localhost:8080/BoardWeb/boardList.do) -> 페이지 호출 -> Control.
		String uri = req.getRequestURI(); // /BoardWeb/boardList.do
		String page = uri.substring(9); // /boardList.do
		Control sub = map.get(page);
		sub.exec(req, resp);

	}
}
