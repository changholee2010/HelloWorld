package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class GetReplyCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno
		String bno = req.getParameter("bno");

		ReplyDAO rdao = new ReplyDAO();
		int rcount = rdao.selectReplyCount(Integer.parseInt(bno)); // 댓글건수.
		// {"replyCount": 35}
		resp.getWriter().print("{\"replyCount\": " + rcount + "}");

	}

}
