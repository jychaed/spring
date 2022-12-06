package org.hdcd.controller.noticeboard.service;

import java.util.List;

import org.hdcd.ServiceResult;
import org.hdcd.vo.NoticeVO;
import org.hdcd.vo.PaginationInfoVO;

public interface INoticeService {
	
	public ServiceResult insertNotice(NoticeVO noticeVO);

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public NoticeVO selectNotice(int boNo);

	public ServiceResult updateNotice(NoticeVO noticeVO);

	public ServiceResult deleteNotice(int boNo);
}
