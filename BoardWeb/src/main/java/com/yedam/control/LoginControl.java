package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 기능.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		BoardDAO bdao = new BoardDAO();
		if (bdao.login(id, pw) != null) {
			HttpSession session = req.getSession();
			session.setAttribute("logId", id); // 서버존재.
			
			// 목록이동.
			resp.sendRedirect("boardList.do");

		} else {
			resp.sendRedirect("loginForm.do");
		}

	}

}
