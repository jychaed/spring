package org.hdcd.controller.form.radio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.controller.form.checkbox.JSPFormCheckboxTagController;
import org.hdcd.vo.CodeLabelValue;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/radio")
public class JSPFormRadioTagController {
	private static Logger logger = LoggerFactory.getLogger(JSPFormRadioTagController.class);
	
	/*
	 * 8장 스프링 폼태그
	 * 9. 여러 개의 라디오 버튼 요소
	 * - HTML 여러 개의 라디오 버튼을 출력하려면 <form:radiobuttons> 요소를 사용한다.
	 */
	
	/*여러 개의 라디오 버튼 요소*/
	// 1) 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadios01", method = RequestMethod.GET)
	public String registerFormRadios01(Model model) {
		logger.info("registerFormRadios01");
		
		// 컨트롤러에서 Map타입으로 라디오 버튼에서 사용될 내용을 구성 후 브라우저로 보내주면
		// 브라우저 JSP단에서 form:radiobuttons 라디오 버튼 여러개를 취급하는 요소가
		// 갯수만큼 해당 내용들을 가지고 작성해준다.
		Map<String, String> genderCodeMap = new HashMap<String, String>();
		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");
		
		model.addAttribute("genderCodeMap", genderCodeMap);
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadios01";
	}
	
	// 2) 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadios02", method = RequestMethod.GET)
	public String registerFormRadios02(Model model) {
		logger.info("registerFormRadios02");
		
		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		genderCodeList.add(new CodeLabelValue("01", "Male"));
		genderCodeList.add(new CodeLabelValue("02", "Female"));
		genderCodeList.add(new CodeLabelValue("03", "Other"));
		
		model.addAttribute("genderCodeList", genderCodeList);
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadios02";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerFormRadiosResult(Member member, Model model) {
		logger.info("registerFormRadiosResult");
		
		logger.info("member.getGender() : " + member.getGender());
		model.addAttribute("gender", member.getGender());
		return "form/radio/result";
		
	}
	
	/*여러 개의 라디오 버튼 요소 end*/
	
	
	/*라디오 버튼 요소*/
	// 1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadio01", method = RequestMethod.GET)
	public String registerFormRadio01(Model model) {
		logger.info("registerFormRadio01");
		
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadio01";
	}
	
	@RequestMapping(value = "/registerFormRadio02", method = RequestMethod.GET)
	public String registerFormRadio02(Model model) {
		logger.info("registerFormRadio02");
		
		Member member = new Member();
		member.setGender("female");
		model.addAttribute("member", member);
		return "form/radio/registerFormRadio01";
	}
	
	@RequestMapping(value = "/result2", method = RequestMethod.POST)
	public String registerFormRadioResult(Member member, Model model) {
		logger.info("registerFormRadioResult");
		
		logger.info("member.getGender() : " + member.getGender());
		model.addAttribute("member", member);
		return "form/radio/result2";
		
	}
	/*라디오 버튼 요소 end*/
}
