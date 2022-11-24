package org.hdcd.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 1. 컨트롤러 메서드 매개변수
 * 
 * Model1
 * - 이동 대상에 전달할 데이터를 가지고 있는 인터페이스
 * RedirectAttributtes
 * - 리타이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
 * 자바빈즈 클래스
 * - 요청 파라미터를 가지고 있는 자바빈즈 클래스
 * MultipartFile
 * - Multipart 요청을 사용해 업로드 된 파일 정보를 가지고 있는 인터페이스
 * BindingResult
 * - 도메인 클래스의 입력값 검증을 가지고 있는 인터페이스
 * java.security.Principal
 * - 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스
 * 
 * 2. 요청 데이터 처리 어노테이션
 * @PathVariable
 * - URL 에서 경로 변수 값을 가져오기 위한 어노테이션
 * @RequestParam
 * - 요청 파라미터 값을 가져오기 위한 어노테이션 /// ( 키값은거 ) 폼에서 변수명이 다를 때 사용
 * @RequestHeader
 * - 요청 헤더 값을 가져오기 위한 어노테이션
 * @RequestBody
 * - 요청 본문 내용을 가져오기 위한 어노테이션
 * @CookieValue
 * - 쿠키값을 가져오기 위한 어노테이션
 * 
 */
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 5장 . 컨트롤러 요청 처리
	// 1. 컨트롤러 메서드 매개변수 / 2. 요청처리
	// 컨트롤러 요청 처리를 위한 registerForm시작점(시작 페이지)
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("registerForm");
		return "member/registerForm";
	}
	
	// 1)
	// URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerByParameter(String userId, String password) {
		logger.info("registerByParameter");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		return "success";
		
	}
	// 2) 
	// URL 경로상의 경로 변수로부터 요청 데이터르 취득할 수 없다.
	@RequestMapping(value = "/register/{userId}")
	public String registerByPath(String userId) { //public String registerByPath(@PathVariable String userId) { 이거면  null아니고 받을 수 있음
		// userId가 null로 표시됩니다.
		// 넘겨받은 id를 위와 같은 형태로 받을려면
		// @PathVariable 를 이용한다. 
		// 경로상의 특정값{userId}을 가져오고 싶을때  @PathVariable 어노테이션을 이용해서 경로상에 들어온 특정 값을 값으로 인식
		logger.info("registerByPath");
		logger.info("userId : " + userId);
		return "success";
		
	}
	
	// 3)
	// HTML 폼 필드명과 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		logger.info("register01");
		logger.info("userId : " + userId);
		return "success";
		
	}
	
	// 4)
	// HTML 폼 필드가 여러개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(String userId, String password) {
		logger.info("register02");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		return "success";
		
	}
	
	// 5)
	// HTML 폼 필드가 여러개일 경우에 컨트롤러 매개변수의 위치는 상관없다.
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public String register03(String password, String userId) {
		logger.info("register03");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		return "success";
		
	}
	
	// 6)
	// HTML Form 필드 값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청 데이터를 취득한다.
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public String register04(String userId, String password, String coin) {
		logger.info("register04");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		logger.info("coin : " + coin);
		return "success";
		
	}
	
	// 7)
	// HTML Form 필드 값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입변환하여 요청 데이터를 취득한다.
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public String register05(String userId, String password, int coin) {
		logger.info("register05");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		logger.info("coin : " + coin);
		return "success";
		
	}
	
	
	
	
	
	
	// 3. 요청 데이터 처리 어노테이션
	// 1) register/100 위에서 이미 요청 처리를 했기 때문에 여기선 처리를 하지 않습니다!!
	// 2)
	// URL 경로 상의 변수가 여러 개일때, @PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정해준다.
	@RequestMapping(value = "/register/{userId}/{coin}")
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		logger.info("registerByPath - @PathVariable");
		logger.info("userId : " + userId);
		logger.info("coin : " + coin);
		return "success";
		 
	}
	
	// 3)
	// HTML 폼의 필드명과 컨트롤러 매개변수명이 일치하면 요청을 처리할 수 있다.
	@RequestMapping(value = "/register0101",method = RequestMethod.POST)
	public String register0101(String userId) {
		logger.info("register0101");
		logger.info("userId : " + userId);
		return "success";
		
	}
	
	// 4)
	// HTML 폼의 필드명과 컨트롤러 매개변수명이 일치(대소문자구분)하지 않으면 요청을 처리할 수 없다.
	@RequestMapping(value = "/register0201",method = RequestMethod.POST)
	public String register0201(String username) {
		logger.info("register0201");
		logger.info("username : " + username);
		return "success";
		
	}
	
	// 5)
	//  @RequestParms 어노테이션을 사용하여 특정한 HTML Form의 필드명을 지정하여 요청을 처리한다.
	@RequestMapping(value = "/register0202",method = RequestMethod.POST)
	public String register0202(@RequestParam("userId") String username) {
		logger.info("register0202");
		logger.info("username : " + username);
		return "success";
		
	}
	
	
	
}













