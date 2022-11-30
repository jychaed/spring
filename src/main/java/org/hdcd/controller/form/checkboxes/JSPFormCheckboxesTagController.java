package org.hdcd.controller.form.checkboxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.controller.form.textarea.JSPFormTextareaController;
import org.hdcd.vo.CodeLabelValue;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/checkboxes")
public class JSPFormCheckboxesTagController {
	private static Logger logger = LoggerFactory.getLogger(JSPFormCheckboxesTagController.class);
	
	/*
	 * 8장 스프링 폼태그
	 * 7. 여러개의 체크박스 요소
	 * - HTML 여러 개의 체크박스를 출력하려면 <form:checkboxes> 요소를 사용한다.
	 */
	
	// 1)모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		Map<String, String> hobbyMap = new HashMap<String, String>();
		hobbyMap.put("01", "Sports");
		hobbyMap.put("02", "Music");
		hobbyMap.put("03", "Movie");
		
		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("member", new Member());
		
		return "form/checkboxes/registerForm01";
	}
	
	// 2)모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		
		List<CodeLabelValue> hobbyCodeList = new ArrayList<CodeLabelValue>();
		hobbyCodeList.add(new CodeLabelValue("01", "Sports")); //이게 key 옆에 value //  vo 생성자 순서대로 넣어주니 주의
		hobbyCodeList.add(new CodeLabelValue("02", "Music"));
		hobbyCodeList.add(new CodeLabelValue("03", "Movie"));
		
		model.addAttribute("hobbyCodeList", hobbyCodeList);
		model.addAttribute("member", new Member());
		
		return "form/checkboxes/registerForm02";
	}
	
	
}
