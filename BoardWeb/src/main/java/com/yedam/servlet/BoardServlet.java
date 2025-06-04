package com.yedam.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("service 메소드 호출.");
	}
}
