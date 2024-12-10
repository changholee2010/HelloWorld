package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * url pattern에서 ??.do => FrontControl을 실행.
 * 
 */
public class FrontControl extends HttpServlet {
	Map<String, Control> map;

	public FrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화.
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl()); // 목록.
		map.put("/board.do", new BoardControl()); // 상세.
		// 게시글 등록화면.
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/board.do", new BoardControl());
		// 게시글 수정화면.
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)//
			throws ServletException, IOException {
		// http://localhost:80/BoardWeb/hello.do
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path); // "/hello.do" 공통부분을 제외한 나머지 부분.

		// 요청url === 실행할 컨트롤
		Control contol = map.get(path);
		contol.exec(req, resp);
	}
}
