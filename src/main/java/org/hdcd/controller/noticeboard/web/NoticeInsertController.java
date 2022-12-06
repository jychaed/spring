package org.hdcd.controller.noticeboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.hdcd.ServiceResult;
import org.hdcd.controller.noticeboard.service.INoticeService;
import org.hdcd.vo.NoticeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {

	@RequestMapping(value = "/form.do", method = RequestMethod.GET)
	public String noticeFormView() {
		return "notice/form";
	}
	
	@Inject
	private INoticeService noticeService;
	
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String noticeInsert(NoticeVO noticeVO, ModelMap model) {	// Model이나 ModelMap이나 똑같음.
		String goPage = "";
		Map<String, String> errors = new HashMap<String, String>();
		
		// StringUtils : lang3으로 임포트하려고 pom.xml에서 설정
		if(StringUtils.isBlank(noticeVO.getBoTitle())) {	// isBlank가 공백 여부를 확인해 T/F를 리턴해준다.
			errors.put("boTitle", "제목을 입력해주세요.");
		}
		if(StringUtils.isBlank(noticeVO.getBoContent())) {	// isBlank가 공백 여부를 확인해 T/F를 리턴해준다.
			errors.put("boContent", "내용을 입력해주세요.");
		}
		
		if(errors.size() > 0) {	// 에러가 있음!
			model.addAttribute("errors", errors);
			model.addAttribute("noticeVO", noticeVO);
			goPage = "notice/form";
		}else { // 에러 없음! 정상!!!
			noticeVO.setBoWriter("a001");	// 현재 회원 정보가 없으므로 더미데이터 하나 넣어 놓음.
			ServiceResult result = noticeService.insertNotice(noticeVO);
			if(result.equals(ServiceResult.OK)) {
				goPage = "redirect:/notice/list.do";
			}else {
				model.addAttribute("message", "서버 에러, 다시 시도해주세요!");
				goPage = "notice/form";
			}
		}
		return goPage;
		
	}
	
	
	
	
	
}
