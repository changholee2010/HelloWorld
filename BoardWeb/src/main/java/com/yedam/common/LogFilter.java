package com.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogFilter implements Filter {
	List<String> list = new ArrayList<>();

	public LogFilter() {
		System.out.println("필터객체 생성.");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		String host = req.getRemoteAddr();
		String port = "" + req.getRemotePort();

		System.out.println("접속Host:" + host + "Port:" + port);
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());
		System.out.println("요청페이지: " + page);

		// localhost의 요청이 아니면 loginForm.do 페이지로 리다이렉션 하기.
//		if (!host.equals("0:0:0:0:0:0:0:1") && !page.equals("/loginForm.do")) {
//			System.out.println("IP: " + host + ", Page: " + page);
//			HttpServletResponse response = (HttpServletResponse) resp;
//			response.sendRedirect("loginForm.do");
//			return;
//		}

//		HttpSession session = request.getSession();
//		String login = (String) session.getAttribute("logId");
//		if (!page.equals("loginForm.do") && (login == null || login.equals(""))) {
//			HttpServletResponse response = (HttpServletResponse) resp;
//			response.sendRedirect("loginForm.do");
//			return;
//		}
		chain.doFilter(req, resp); // 서블릿 실행.

	}

}
