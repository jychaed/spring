package org.hdcd.controller.form.validation;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag/validation")
public class JSPFormValidationController {
	
	private static Logger logger = LoggerFactory.getLogger(JSPFormValidationController.class);
	
	/*
	 * 8장 스프링 폼 태그
	 * 15. 입력값 검증 에러
	 * - 입력값 검증 에러를 출력하려면 <form:errors> 요소를 사용한다.
	 * 
	 * >> 값을 누락시키고 컨트롤러로 넘겼는데 결과 페이지로 이동한다???
	 * - ' /formtag/validation/registerFormValidation01 ' 로 요청을 보내고 데이터 입력 폼을 다 비우고 등록 버튼 땅!
	 * - 빈 값이므로 데이터를 입력해달라느니 뭔가의 에러메세지가 form:errors를 통해서 나타날 것으로 예상했는데 안나타남??
	 * - 해당 이유는 아래 참고
	 * 
	 * 클라이언트에서 서버로 modelAttribute에서 바인딩 할 객체를 설정하고 아이디를 누락 시킨 후 서버로 요청했을 때,
	 * form:errors에 담길 메세지는 바인딩 되서 넘어오지만, 바인딩 됬다고 출력을 위한 validation 역할자가 없기 때문에
	 * 그 역할을 담당할 validation이 역할을 다 못하므로 그냥 없는 채로 결과 페이지가 출력된다.
	 * 
	 * 
	 */
	
	// 객체를 생성하여 값을 설정한 후 화면에 전달한다
	@RequestMapping(value = "/registerFormValidation01" , method = RequestMethod.GET)
	public String registerFormValidation01(Model model) {
		logger.info("registerFormValidation01");
		
		Member member = new Member();
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동순");	
		
		model.addAttribute("member", member);
		
		return "form/validation/registerFormValidation01";
	}	
	
	// 결과
	@RequestMapping(value = "/result" , method = RequestMethod.POST)
	public String registerFormValidationResult(Member member, Model model) {
		logger.info("registerFormValidationResult");
		
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getUserName() : " + member.getUserName());
		logger.info("member.getEmail() : " + member.getEmail());
		
		model.addAttribute("member", member);
		return "form/validation/result";
	}	
	
	
}

