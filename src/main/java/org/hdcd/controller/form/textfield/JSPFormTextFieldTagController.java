package org.hdcd.controller.form.textfield;

import org.hdcd.controller.JSPFormTagController;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/textfield")
public class JSPFormTextFieldTagController {
	
	private static final Logger logger = LoggerFactory.getLogger(JSPFormTextFieldTagController.class);
	
	/*
	 * 8장 스프링 폼 태그 20221130
	 * 4. 텍스트 필드 요소
	 * - HTML 텍스트 필드를 출력하려면 <form:input> 요소를 사용한다.
	 */
	
	// 1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		model.addAttribute("member", new Member());
		return "form/textfield/registerForm01";
	}
	
	// 2) 폼 객체를 생성하여 값을 설정한 후에 전달한다.
	// 실행하고 값을 입력하고 등록을 눌러서 result 페이지로 가서 확인한다
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		logger.info("registerForm02");
		Member member = new Member();
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길순");
		
		model.addAttribute("member", member);
		return "form/textfield/registerForm01";
	}
	
}













