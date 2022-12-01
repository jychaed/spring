package org.hdcd.controller.form.button;


import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/button")
public class JSPFormButtonTagController {
	private static Logger logger = LoggerFactory.getLogger(JSPFormButtonTagController.class);
	
	/*
	 * 8장 스프링 폼 태그
	 * 14. 버튼 요소
	 * - HTML 버튼을 출력하려면 <form:button> 요소를 사용한다.
	 */
	
	// 객체를 생성하여 값을 설정한 후 화면에 전달한다
	@RequestMapping(value = "/registerFormButton01" , method = RequestMethod.GET)
	public String registerFormButton01(Model model) {
		logger.info("registerFormButton01");
		Member member = new Member();
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");		
		model.addAttribute("member", member);
		return "form/button/registerFormButton01";
	}	
	
	// 결과
		@RequestMapping(value = "/result" , method = RequestMethod.POST)
		public String registerFormButtonResult(Member member, Model model) {
			logger.info("registerFormButtonResult");
			
			logger.info("member.getUserId() : " + member.getUserId());
			logger.info("member.getUserName() : " + member.getUserName());
			logger.info("member.getEmail() : " + member.getEmail());
			
			model.addAttribute("member", member);
			return "form/button/result";
		}	
}
