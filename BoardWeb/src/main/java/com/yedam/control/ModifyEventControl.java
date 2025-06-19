package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class ModifyEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = req.getParameter("t");
		String start = req.getParameter("s1");
		String newStart = req.getParameter("s2");
		String end = req.getParameter("e1");
		String newEnd = req.getParameter("e2");

		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("start", start);
		map.put("end", end);
		map.put("newStart", newStart);
		map.put("newEnd", newEnd);

		BoardService svc = new BoardServiceImpl();
		if (svc.modifyEvent(map)) {
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}

	}

}
