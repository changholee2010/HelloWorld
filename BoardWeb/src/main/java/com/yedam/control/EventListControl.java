package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class EventListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");

		BoardService svc = new BoardServiceImpl();
		List<Map<String, String>> map = svc.eventList();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);

		PrintWriter out = resp.getWriter();
		out.print(json);

	}

}
