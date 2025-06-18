package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// GET요청=화면출력.
		// POST요청=회원등록.
		if (req.getMethod().equals("GET")) {
			req.getRequestDispatcher("member/signUp.tiles").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			// db insert.
			// images 폴더에 업로드.
			// 1.요청정보 2.경로 3.최대크기 4.인코딩 5.리네임정책
			String savePath = req.getServletContext().getRealPath("images");
			MultipartRequest mr = new MultipartRequest(//
					req, // 요청정보.
					savePath, // 업로드경로.
					1024 * 1024 * 5, // 최대크기(5MB).
					"UTF-8", // 인코딩.
					new DefaultFileRenamePolicy() // 리네임정책.
			);
			// db입력.
			String id = mr.getParameter("userId");
			String pw = mr.getParameter("userPw");
			String nm = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");

			// parameter 셋팅.
			MemberVO member = new MemberVO();
			member.setMemberId(id);
			member.setMemberName(nm);
			member.setPassword(pw);
			member.setImg(img);

			MemberService svc = new MemberServiceImpl();
			if (svc.addMember(member)) {
				resp.sendRedirect("boardList.do");
			}

		}
	}

}
