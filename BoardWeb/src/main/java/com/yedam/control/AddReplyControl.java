package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글등록. 원본글번호,댓글작성자,댓글
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");// 원본글번호.
		String reply = req.getParameter("reply");// 댓글내용.
		String replyer = req.getParameter("replyer");// 작성자.

		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		// DB 입력처리.
		ReplyService svc = new ReplyServiceImpl();
		if (svc.addReply(rvo)) {
			// {"retCode": "Success"}
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			// {"retCode": "Fail"}
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}

	}

}
