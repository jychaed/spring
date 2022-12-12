package org.hdcd.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {
	private int rnum;
	private int boNo;
	private String boTitle;
	private String boContent;
	private String boWriter;
	private String boDate;
	private int boHit;
	
	// 20221212 추가 
	private Integer[] delNoticeNo;
	private MultipartFile[] boFile;
	private List<NoticeFileVO> noticeFileList;
	
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getBoNo() {
		return boNo;
	}
	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}
	public String getBoTitle() {
		return boTitle;
	}
	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}
	public String getBoContent() {
		return boContent;
	}
	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}
	public String getBoWriter() {
		return boWriter;
	}
	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}
	public String getBoDate() {
		return boDate;
	}
	public void setBoDate(String boDate) {
		this.boDate = boDate;
	}
	public int getBoHit() {
		return boHit;
	}
	public void setBoHit(int boHit) {
		this.boHit = boHit;
	}
	
	// 20221212
	public Integer[] getDelNoticeNo() {
		return delNoticeNo;
	}
	public void setDelNoticeNo(Integer[] delNoticeNo) {
		this.delNoticeNo = delNoticeNo;
	}
	public MultipartFile[] getBoFile() {
		return boFile;
	}
	public void setBoFile(MultipartFile[] boFile) {
		this.boFile = boFile;
		if(boFile != null) {
			List<NoticeFileVO> noticeList = new ArrayList<NoticeFileVO>();
			for (MultipartFile items : boFile) {
				if (StringUtils.isBlank(items.getOriginalFilename())) {
					continue;
				}
				NoticeFileVO noticeFileVO = new NoticeFileVO(items);
				noticeList.add(noticeFileVO);
			}
			this.noticeFileList = noticeList;
		}
	}
	public List<NoticeFileVO> getNoticeFileList() {
		return noticeFileList;
	}
	public void setNoticeFileList(List<NoticeFileVO> noticeFileList) {
		this.noticeFileList = noticeFileList;
	}
	
	
	
}
