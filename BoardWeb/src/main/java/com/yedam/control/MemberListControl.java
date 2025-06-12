package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 정렬순서(order)
		String order = req.getParameter("order");
		order = order == null ? "member_id" : order; // 기준정렬은 id정렬.
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList(order);
		req.setAttribute("memberList", list);
		// 출력jsp
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
	}

}
