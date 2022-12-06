package org.hdcd.controller.noticeboard.web;

import javax.inject.Inject;

import org.hdcd.ServiceResult;
import org.hdcd.controller.noticeboard.service.INoticeService;
import org.hdcd.vo.NoticeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice")
public class NoticeModifyController {
	
	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String noticeUpdateView(int boNo, ModelMap model) {
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status", "u");
		return "notice/form";
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String noticeUpdate(NoticeVO noticeVO, ModelMap model) {
		String goPage="";
		ServiceResult result = noticeService.updateNotice(noticeVO);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/detail.do?boNo=" + noticeVO.getBoNo();
			
		}else {
			model.addAttribute("message", "수정 실패");
			model.addAttribute("noticeVO", noticeVO);
			goPage = "notice/form";
		}
		return goPage;
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String noticeDelete(int boNo, ModelMap model) {
		String goPage="";
		ServiceResult result = noticeService.deleteNotice(boNo);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/list.do";
			
		}else {
			model.addAttribute("message", "서버오류, 다시 시도");
			goPage = "redirect:/notice/detail.do?boNo=" + boNo;
		}
		return goPage;
	}
	
	
	
	
	
	
	
	
	
}
