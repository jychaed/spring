package org.hdcd.controller.noticeboard.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.ServiceResult;
import org.hdcd.mapper.INoticeMapper;
import org.hdcd.vo.NoticeVO;
import org.hdcd.vo.PaginationInfoVO;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements INoticeService {

	@Inject
	private INoticeMapper noticeMapper;
	
	@Override
	public ServiceResult insertNotice(NoticeVO noticeVO) {
		ServiceResult result = null;	// ServiceResult는 enum으로 만들어 둠.
		int cnt = noticeMapper.insertNotice(noticeVO);
		if(cnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeMapper.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeMapper.selectNoticeList(pagingVO);
	}

	@Override
	public NoticeVO selectNotice(int boNo) {
		noticeMapper.incrementHit(boNo);	// 조회수 증가
		return noticeMapper.selectNotice(boNo);		// 게시글 1행 정보 조회	
	}

	@Override
	public ServiceResult updateNotice(NoticeVO noticeVO) {
		ServiceResult result = null;
		int cnt = noticeMapper.updateNotice(noticeVO);
		if(cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult deleteNotice(int boNo) {
		ServiceResult result = null;
		int cnt = noticeMapper.deleteNotice(boNo);
		if(cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}
	
}
