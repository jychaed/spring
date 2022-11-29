package org.hdcd.controller;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModelAttributeMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(ModelAttributeMemberController.class);
	
	/*
	 * 3. @ModelAttribute 어노테이션
	 * - @ModelAttribute 어노테이션은 전달받은 매개변수를 강제로 Model에 담아서 전달하도록 할대 필요한 어노테이션이다. 
	 */
	
	// 3번 @ModelAttribute 어노테이션입력 Form 페이지
	@RequestMapping(value = "/modelattribute/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		return "member/registerModelAttributeForm";
	}
	
	// 1)  기본 자료형은 매개변수로 선언하더라고 기본적으로 전달되지 않는다.
	@RequestMapping(value = "/modelattribute/register01", method = RequestMethod.POST)
	public String register01(String userId) { //String userId 매개변수는 return "result"전달 놉
		// 매개변수로 기본 자료형을 선언하더라도 결과 페이지로 전달되지 않는다.
		logger.info("register01");
		logger.info("userId : " + userId);
		return "result";
	}
	
	// 2) 기본 자료형인 매개변수에  @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.
	@RequestMapping(value = "/modelattribute/register02", method = RequestMethod.POST)
	public String register02(@ModelAttribute("userId") String userId) { 
		// 모델 설정 안해도 ! 넘어감 이 @ModelAttribute 어노테이션 사용시
		logger.info("register02");
		logger.info("userId : " + userId);
		return "result";
	}
	
	// 3) 기본 자료형인 매개변수가 여러 개인 경우 각각의 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.
	@RequestMapping(value = "/modelattribute/register03", method = RequestMethod.POST)
	public String register03(@ModelAttribute("userId") String userId, 
							 @ModelAttribute("password") String password ) { 
		// @ModelAttribute 어노테이션 각각 주면 매개변수 넘어간다! 모델 없이도 ㅎㅎ
		logger.info("register03");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		return "result";
	}
	
	// 4) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다
	@RequestMapping(value = "/modelattribute/register04", method = RequestMethod.POST)
	public String register04(Member member) { 
		// @ModelAttribute 어노테이션을 사용하지 않아도! 모델로 넘겨주지 않아도! 객체로 받는 즉시 넘겨줌 원하는 값 출력가능
		logger.info("register04");
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " +  member.getPassword());
		return "result";
	}
	
	// 5) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다 (2)
	@RequestMapping(value = "/modelattribute/register05", method = RequestMethod.POST)
	public String register05(Member member) { 
		logger.info("register05");
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " +  member.getPassword());
		logger.info("member.getAddress().getPostCode() : " +  member.getAddress().getPostCode());
		logger.info("member.getAddress().getLocation() : " +  member.getAddress().getLocation());
		return "result";
	}
	
}
