package com.yedam.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
