package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ReplyList.do => json문자열 반환.
		// 자바객체 -> json문자열로 변환(Gson)
		resp.setContentType("text/json;charset=utf-8");

		String bno = req.getParameter("bno");

		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		System.out.println(json);

		PrintWriter out = resp.getWriter();
		out.print(json);

	}

}
