package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AllControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.GetReplyControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyListControl;

/*
 * M-V-Control역할.
 * url패턴 - 실행서블릿 관리.
 */
public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// boardList.do - 글목록 출력 기능.
		// 처리순서가 중요.
		map.put("/boardList.do", new BoardListControl()); // 글목록.
		map.put("/board.do", new BoardControl()); // 상세화면.
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정화면
		map.put("/removeBoard.do", new RemoveBoardControl()); // 삭제화면

		// member관련.
		map.put("/loginForm.do", new LoginFormControl()); // 화면.
		map.put("/login.do", new LoginControl()); // id,pw 로그인처리.
		map.put("/logout.do", new LogoutControl());
		// 회원목록.
		map.put("/memberList.do", new MemberListControl());
		// 상품관련.
		map.put("/allProduct.do", new AllControl());

		// 댓글관련. json파일.
		map.put("/replyList.do", new ReplyListControl()); // 댓글목록.
		map.put("/addReply.do", new AddReplyControl()); // 댓글등록.
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓글삭제.
		map.put("/getReply.do", new GetReplyControl()); // 단건조회.

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url이 호출(http://localhost:8080/BoardWeb/boardList.do) -> 페이지 호출 -> Control.
		String uri = req.getRequestURI(); // /BoardWeb/boardList.do
		String context = req.getContextPath(); // /BoardWeb or /HelloWorld
		String page = uri.substring(context.length()); // /boardList.do
		Control sub = map.get(page);
		sub.exec(req, resp);

	}
}
