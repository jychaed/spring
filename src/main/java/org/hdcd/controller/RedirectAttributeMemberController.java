package org.hdcd.controller;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectAttributeMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(RedirectAttributeMemberController.class);
	
	/*
	 * 4. @RedirectAttributes 어노테이션
	 * - @RedirectAttributes 어노테이션은 일회성으로 데이터를 전달하는 용도로 사용된다.
	 */
	
	@RequestMapping(value = "/redirectAttributes/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("redirectattribute registerForm");
		return "member/registerRedirectAttributeForm";
	}
	// 1) RedirectAttributes는 일회성으로 데이터를 전달하는 용도로 사용 된다.
	@RequestMapping(value = "/redirectattribute/register", method = RequestMethod.POST)
	public String register(Member member, RedirectAttributes redirectAttributes) {
		logger.info("register");
		redirectAttributes.addFlashAttribute("msg", "success");
		return "redirect:/redirectattribute/result";
	}
	
	// (1)번 처리후 넘어갈 결과 페이지
	@RequestMapping(value = "/redirectattribute/result", method = RequestMethod.GET)
	public String result() {
		logger.info("result");
		return "result";
	}

	
}
