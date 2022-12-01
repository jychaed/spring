package org.hdcd.controller.form.hidden;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.java.swing.plaf.motif.resources.motif;

@Controller
@RequestMapping("/formtag/hidden")
public class JSPFormHiddenController {
	private static Logger logger = LoggerFactory.getLogger(JSPFormHiddenController.class);
	
	/*
	 * 8장 스프링 폼 태그
	 * 12. 숨겨진 필드 요소
	 * - HTML 숨겨진 필드를 출력하려면 <form:hidden> 요소를 사용한다.
	 * 
	 */
	
	// 객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@RequestMapping(value = "/registerFormHidden01" , method = RequestMethod.GET)
	public String registerFormHidden01(Model model) {
		logger.info("registerFormHidden01");
		
		Member member = new Member();
		member.setUserId("hongkd");
		member.setUserName("홍길동");
		model.addAttribute("member", member);
		return "form/hidden/registerFormHidden01";
	}	
	
	// 텍스트 필드에 값을 입력하고 등록 버튼을 누른다
	@RequestMapping(value = "/result" , method = RequestMethod.POST)	
	public String registerFormHiddenResult(Member member, Model model) {
		logger.info("registerFormHiddenResult");
		
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getUserName() : " + member.getUserName());
		model.addAttribute("member", member); // 자바빈즈라서 안해도 넘어는 감!
		
		return "form/hidden/result";
	}
}
