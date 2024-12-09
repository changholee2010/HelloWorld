package com.yedam.vo;

import java.util.Date;

import lombok.Data;

/*
 * VO: Value Object
 * Lombok 사용: 1. Lombok 다운로드 설치
 *             2. Lombok 라이브러리 다운로드
 *             3. eclipse 재실행
 *             4. 어노테이션.
 */

@Data
public class BoardVO {
	private int boardNo; // board_no => boardNo 형식.
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private Date creationDate;
	private Date updateDate;
}
