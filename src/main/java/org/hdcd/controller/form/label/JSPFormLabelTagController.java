package org.hdcd.controller.form.label;

import org.hdcd.controller.form.hidden.JSPFormHiddenController;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/label")
public class JSPFormLabelTagController {
	private static Logger logger = LoggerFactory.getLogger(JSPFormLabelTagController.class);
	
	/*
	 * 8장 스프링 폼 태그
	 * 13. 라벨 요소
	 * - HTML 라벨을 출력하려면 <form:label> 요소를 사용한다.
	 */
	
	// 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormLabel01" , method = RequestMethod.GET)
	public String registerFormLabel01(Model model) {
		logger.info("registerFormLabel01");
		
		model.addAttribute("member", new Member());
		return "form/label/registerFormLabel01";
	}	
	
	// 객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@RequestMapping(value = "/registerFormLabel02" , method = RequestMethod.GET)
	public String registerFormLabel02(Model model) {
		logger.info("registerFormLabel02");
		
		Member member = new Member();
		member.setUserId("hongkildong");
		member.setUserName("홍길순");
		member.setEmail("aaa@ccc.com");
		
		model.addAttribute("member", member);
		return "form/label/registerFormLabel01";
	}	
	
	// 결과
	@RequestMapping(value = "/result" , method = RequestMethod.POST)
	public String registerFormLabelResult(Member member, Model model) {
		logger.info("registerFormLabelResult");
		
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getUserName() : " + member.getUserName());
		logger.info("member.getEmail() : " + member.getEmail());
		// 자바빈즈 클래스는 매개변수로 선언해 놓으면 model전달자로 데이터를 옮기지 않아도 된다.
		// 여기서는 옮겨보자 전달자를 통해서
		model.addAttribute("member", member);
		return "form/label/result";
	}	
}
