package org.hdcd.controller.noticeboard.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.hdcd.controller.noticeboard.service.INoticeService;
import org.hdcd.controller.noticeboard.service.NoticeServiceImpl;
import org.hdcd.vo.NoticeVO;
import org.hdcd.vo.PaginationInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {

	@Inject
	private INoticeService noticeService;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView noticeListView(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage, //page로 받아서 currentPage로 사용할거
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord
			) {
		ModelAndView mav = new ModelAndView();

		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<NoticeVO>();
		
		if(StringUtils.isNotBlank(searchWord)) { // 이부분 해당되면 타고 아니면 넘어가겠죠?
			if("title".equals(searchType)) {
				pagingVO.setSearchType("title");	// 제목으로 검색
			}else {
				pagingVO.setSearchType("writer");	// 작성자료 검색
			}
			pagingVO.setSearchWord(searchWord);
			mav.addObject("searchType", searchType);
			mav.addObject("searchWord", searchWord);
		}

		pagingVO.setCurrentPage(currentPage);
		int totalRecord = noticeService.selectNoticeCount(pagingVO); // 전체 게시물 수

		pagingVO.setTotalRecord(totalRecord);
		List<NoticeVO> dataList =  noticeService.selectNoticeList(pagingVO);

		pagingVO.setDataList(dataList);

		mav.addObject("pagingVO", pagingVO);
		mav.setViewName("notice/list");
		return mav;
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String noticeDetailView(int boNo, Model model) {
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("noticeVO",noticeVO);
		return "notice/detail";
	
	}
	

}