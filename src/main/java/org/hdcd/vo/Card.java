package org.hdcd.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Card {
	private String no;
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
