package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/*
 * 클래스가 서블릿이 되는 순서.
 * HttpServlet을 상속.
 * 생성자선언 - init() - service() 순으로 작성.
 * url 등록("board.serv")
 */
@WebServlet("/board.serv")
public class BoardServlet extends HttpServlet {
	// 생성자선언.
	public BoardServlet() {
		System.out.println("BoardServlet 생성자 호출.");
	}

	// init() 메소드.
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출.");
	}

	// service() 메소드.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service 메소드 호출.");
		resp.setContentType("text/html;charset=utf-8"); // content 타입지정.
		// 요청페이지?bno=3
		String boardNo = req.getParameter("bno");

		// 상세조회.
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(boardNo));

		// 출력포맷.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// table(표) 출력.
		String str = "";
		str += "<table border='1'>";
		str += "<tbody>";
		str += "<tr><th>글번호</th><td>" + board.getBoardNo() //
				+ "</td><th>조회수</th><td>" + board.getReadCnt() //
				+ "</td></tr>";
		str += "<tr><th>제목</th><td colspan='3'>" + board.getTitle() + "</td></tr>";
		str += "<tr><th>내용</th><td colspan='3'>" + board.getContent() + "</td></tr>";
		str += "<tr><th>작성자</th><td colspan='3'>" + board.getWriter() + "</td></tr>";
		str += "<tr><th>작성일시</th><td colspan='3'>" + sdf.format(board.getWriteDate()) + "</td></tr>";
		str += "</tbody></table>";
		str += "<p><a href='servlet/boardList.serv'>목록이동</a></p>";
		PrintWriter out = resp.getWriter();
		out.print(str);
	}
}
