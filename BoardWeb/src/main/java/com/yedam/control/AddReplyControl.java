package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// parameter(bno, replyer, reply)
		resp.setContentType("text/json;charset=utf-8");

		String a = req.getParameter("bno");
		String b = req.getParameter("replyer");
		String c = req.getParameter("reply");

		ReplyVO rv = new ReplyVO();
		rv.setBoardNo(Integer.parseInt(a));
		rv.setReply(c);
		rv.setReplyer(b);

		// json문자열 생성.
		Gson gson = new GsonBuilder().create();
		String json = "";

		// 반환되는 값
		Map<String, Object> resultMap = new HashMap<>();

		ReplyDAO rdao = new ReplyDAO();
		if (rdao.insertReply(rv)) {
			// 성공했을때.
			resultMap.put("retCode", "OK");
			resultMap.put("retVal", rv);

			json = gson.toJson(resultMap);
			resp.getWriter().print(json);
		} else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}

	}

}
