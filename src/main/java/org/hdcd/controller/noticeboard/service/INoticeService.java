package org.hdcd.controller.noticeboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.ServiceResult;
import org.hdcd.vo.NoticeFileVO;
import org.hdcd.vo.NoticeVO;
import org.hdcd.vo.PaginationInfoVO;

public interface INoticeService {
	
	public ServiceResult insertNotice(HttpServletRequest req, NoticeVO noticeVO);

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public NoticeVO selectNotice(int boNo);

	public ServiceResult updateNotice(HttpServletRequest req, NoticeVO noticeVO);

	public ServiceResult deleteNotice(HttpServletRequest req, int boNo);

	public NoticeFileVO noticeDownload(int fileNo);
}
