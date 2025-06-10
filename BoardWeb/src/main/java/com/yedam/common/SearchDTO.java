package com.yedam.common;

import lombok.Data;

// 검색조건(page, searchCondition, keyword)
@Data
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
