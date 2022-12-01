package org.hdcd.vo;

import java.util.Date;

import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class Card {
	// 문자열이 null이 아니고 trim한 길이가 0보다 크다는 것을 검사
	@NotBlank
	private String no;
	// 미래 날짜인지 검사
	@Future
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date validMonth;
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Date getValidMonth() {
		return validMonth;
	}
	public void setValidMonth(Date validMonth) {
		this.validMonth = validMonth;
	}
	
	
}
