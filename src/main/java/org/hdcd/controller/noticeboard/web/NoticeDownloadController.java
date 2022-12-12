package org.hdcd.controller.noticeboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.RegEx;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hdcd.controller.noticeboard.service.INoticeService;
import org.hdcd.controller.noticeboard.view.NoticeDownloadView;
import org.hdcd.vo.NoticeFileVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
public class NoticeDownloadController {
	
	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value = "/notice/download.do")
	private View noticeProcess(HttpServletRequest req, HttpServletResponse resp,
								int fileNo, Model model) {
		NoticeFileVO noticeFileVO = noticeService.noticeDownload(fileNo);
		Map<String, Object> noticeFileMap = new HashMap<String, Object>();
		noticeFileMap.put("fileName", noticeFileVO.getFileName());
		noticeFileMap.put("fileSize", noticeFileVO.getFileSize());
		noticeFileMap.put("fileSavepath", noticeFileVO.getFileSavepath());
		model.addAttribute("noticeFileMap", noticeFileMap);
		
		// 리턴되는 noticeDownloadView는 jsp페이지로 존재하는 페이지 Name을 요청하는게 아니라,
		// 클래스를 요청하는 것인데, 해당 클래스가 스프링에서 제공하는 AbstractView 클래스를 상속받은 클래스인데
		// 그 클래스는 AbstractView를 상속받아 renderMergeOutputModel 함수를 재정의할 때 View로 취급할 수 있게 해준다
		return new NoticeDownloadView();
	}
	
}
