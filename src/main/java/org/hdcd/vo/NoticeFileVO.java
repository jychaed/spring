package org.hdcd.vo;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class NoticeFileVO {
	private MultipartFile item;
	private int boNo;
	private int fileNo;
	private String fileName;
	private long fileSize;
	private String fileFancysize;
	private String fileMime;
	private String fileSavepath;
	private String fileDowncount;
	
	public NoticeFileVO() {}
	
	public NoticeFileVO(MultipartFile item) {
		this.item = item;
		fileName = item.getOriginalFilename();
		fileSize = item.getSize();
		fileMime = item.getContentType();
		fileFancysize = FileUtils.byteCountToDisplaySize(fileSize); //근접한 근사치의 KB/MB/GB 사이즈로 출력
	}

	public MultipartFile getItem() {
		return item;
	}

	public void setItem(MultipartFile item) {
		this.item = item;
	}

	public int getBoNo() {
		return boNo;
	}

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileFancysize() {
		return fileFancysize;
	}

	public void setFileFancysize(String fileFancysize) {
		this.fileFancysize = fileFancysize;
	}

	public String getFileMime() {
		return fileMime;
	}

	public void setFileMime(String fileMime) {
		this.fileMime = fileMime;
	}

	public String getFileSavepath() {
		return fileSavepath;
	}

	public void setFileSavepath(String fileSavepath) {
		this.fileSavepath = fileSavepath;
	}

	public String getFileDowncount() {
		return fileDowncount;
	}

	public void setFileDowncount(String fileDowncount) {
		this.fileDowncount = fileDowncount;
	}
	
	
}
