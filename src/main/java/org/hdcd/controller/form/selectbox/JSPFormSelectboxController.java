package org.hdcd.controller.form.selectbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.controller.JSPFormTagController;
import org.hdcd.vo.CodeLabelValue;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/selectbox")
public class JSPFormSelectboxController {
	
	private static final Logger logger = LoggerFactory.getLogger(JSPFormSelectboxController.class);
	
	/*
	 * 8장 스프링 폼 태그
	 * 11. 셀렉트 박스 요소
	 * - HTML 셀렉트 박스를 출력하려면 <form:select> 요소를 사용한다. 
	 */
	
	// 1) 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox01", method = RequestMethod.GET)
	public String registerFormSelectbox01(Model model) {
		logger.info("registerFormSelectbox01");
		
		Map<String, String> nationalityCodeMap = new HashMap<String, String>();
		nationalityCodeMap.put("01", "Korea");
		nationalityCodeMap.put("02", "Canada");
		nationalityCodeMap.put("03", "Austrailia");
		
		model.addAttribute("nationalityCodeMap", nationalityCodeMap);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox01";
	}
	
	// 2) 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox02", method = RequestMethod.GET)
	public String registerFormSelectbox02(Model model) {
		logger.info("registerFormSelectbox02");
		
		List<CodeLabelValue> nationalityCodeList = new ArrayList<CodeLabelValue>();
		nationalityCodeList.add(new CodeLabelValue("01", "Korea"));
		nationalityCodeList.add(new CodeLabelValue("02", "Canada"));
		nationalityCodeList.add(new CodeLabelValue("03", "Austrailia"));
		
		model.addAttribute("nationalityCodeList", nationalityCodeList);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox02";
	}
	
	// 3) 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox03", method = RequestMethod.GET)
	public String registerFormSelectbox03(Model model) {
		logger.info("registerFormSelectbox03");
		
		Map<String, String> carCodeMap = new HashMap<String, String>();
		carCodeMap.put("01", "Jeep");
		carCodeMap.put("02", "Bmw");
		carCodeMap.put("03", "Audi");
		
		model.addAttribute("carCodeMap", carCodeMap);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox03";
	}
	
	// 4) 모델에 CodeLabelValue 타입의 요소를 가지는 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox04", method = RequestMethod.GET)
	public String registerFormSelectbox04(Model model) {
		logger.info("registerFormSelectbox04");
		
		List<CodeLabelValue> carCodeList = new ArrayList<CodeLabelValue>();
		carCodeList.add(new CodeLabelValue("01", "Jeep"));
		carCodeList.add(new CodeLabelValue("02", "Bmw"));
		carCodeList.add(new CodeLabelValue("03", "Audi"));
		
		model.addAttribute("carCodeList", carCodeList);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox04";
	}
	
	// 5) 모델에 CodeLabelValue 타입의 요소를 가지는 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormSelectbox05", method = RequestMethod.GET)
	public String registerFormSelectbox05(Model model) {
		logger.info("registerFormSelectbox05");
		
		List<CodeLabelValue> carCodeList = new ArrayList<CodeLabelValue>();
		carCodeList.add(new CodeLabelValue("01", "Jeep"));
		carCodeList.add(new CodeLabelValue("02", "Bmw"));
		carCodeList.add(new CodeLabelValue("03", "Audi"));
		
		model.addAttribute("carCodeList", carCodeList);
		model.addAttribute("member", new Member());
		
		return "form/selectbox/registerFormSelectbox05";
	}
	
	// 결과 1
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerFormSelectboxResult(Member member, Model model) {
		logger.info("registerFormSelectboxResult");
		logger.info("member.getNationality() : " + member.getNationality());
		model.addAttribute("nationality",  member.getNationality());
		return "form/selectbox/result";
	}
	
	// 결과 2
	@RequestMapping(value = "/result2", method = RequestMethod.POST)
	public String registerFormSelectboxResult2(Member member, Model model) {
		logger.info("registerFormSelectboxResult2");
		
		List<String> carList = member.getCarList();
		
		if(carList != null) {
			logger.info("carList != null : " +  carList.size());
			
			for(int i = 0; i<carList.size(); i++) {
				logger.info("carList("+i+") : " +  carList.get(i));
			}
		}else {
			logger.info("carList == null");
		}
		
		model.addAttribute("carList",  carList);
		return "form/selectbox/result2";
	}
	
}
