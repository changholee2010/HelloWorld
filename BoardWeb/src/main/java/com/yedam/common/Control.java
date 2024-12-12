package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 인터페이스는 구현클래스를 통해 실제 기능이 정의.
 * 인터페이스는 규칙만 제시.
 */
public interface Control {
	// 메소드의 선언만 있는 메소드를 추상메소드.
	public void exec(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException;
}
