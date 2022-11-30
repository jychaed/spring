package org.hdcd.controller.form.checkbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.controller.form.checkboxes.JSPFormCheckboxesTagController;
import org.hdcd.vo.CodeLabelValue;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/checkbox")
public class JSPFormCheckboxTagController {
private static Logger logger = LoggerFactory.getLogger(JSPFormCheckboxTagController.class);
	
	/*
	 * 8장 스프링 폼태그
	 * 8. 체크박스 요소
	 * - HTML 여러 개의 체크박스를 출력하려면 <form:checkbox> 요소를 사용한다.
	 */
	
	// 1)모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		model.addAttribute("member", new Member());
		return "form/checkbox/registerForm01";
	}
	
	// 2)
		@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
		public String registerForm02(Model model) {
			logger.info("registerForm02");
			
			Member member = new Member();
			member.setDeveloper("Y");
			member.setForeigner(true);
			member.setHobby("Movie");
			
			String[] hobbyArray = {"Music","Movie"};
			member.setHobbyArray(hobbyArray);
			
			List<String> hobbyList = new ArrayList<String>();
			hobbyList.add("Music");
			hobbyList.add("Movie");
			member.setHobbyList(hobbyList);
			
			model.addAttribute("member", member);
			
			return "form/checkbox/registerForm01";
		}
	
		// 3)
		@RequestMapping(value = "/result", method = RequestMethod.POST)
		public String registerResult(Member member, Model model) {
			logger.info("registerResult");
			logger.info("member.isForeigner() : " + member.isForeigner() );
			logger.info("member.getDeveloper() : " + member.getDeveloper() );
			logger.info("member.getHobby() : " + member.getHobby() );
			
			String[] hobbyArray = member.getHobbyArray();
			
			if(hobbyArray != null) {
				logger.info("hobbyArray != null: " + hobbyArray.length);
				
				for(int i = 0; i < hobbyArray.length; i++) {
					logger.info("hobbyArray["+i+"]: " + hobbyArray[i]);
				}
			} else {
				logger.info("hobbyArray == null");
			}
			
			List<String> hobbyList = member.getHobbyList();
			if(hobbyList != null) {
				logger.info("hobbyList != null: " + hobbyList.size());
				
				for(int i = 0; i < hobbyList.size(); i++) {
					logger.info("hobbyList["+i+"]: " + hobbyList.get(i));
				}
			} else {
				logger.info("hobbyList == null");
			}
			
			model.addAttribute("member", member);
			
			return "form/checkbox/result";
		}
		
}
