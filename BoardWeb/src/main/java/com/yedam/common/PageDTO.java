package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	// 게시글 건수 -> 페이지 계산.
	private int start, end, currentPage;
	private boolean prev, next;

	public PageDTO(int page, int totalCnt) {
		this.currentPage = page; // 3page
		this.end = (int) Math.ceil(1.0 * page / 10) * 10;
		this.start = this.end - 9;

		int realEnd = (int) Math.ceil(1.0 * totalCnt / 5); // 건수를 기준으로 실제 마지막페이지.
		this.end = this.end > realEnd ? realEnd : this.end;

		// 이전, 이후 페이지의 존재 체크.
		this.prev = this.start > 1;
		this.next = this.end < realEnd;

	}
}
