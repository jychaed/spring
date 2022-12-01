package org.hdcd.controller;

import java.util.List;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/formtag")
public class JSPFormTagController {
	private static final Logger logger = LoggerFactory.getLogger(JSPFormTagController.class);
	
	// 1) 모델에 폼 객체를 추가하지 않으면 에러가 발생한다.
	@RequestMapping(value = "/registerForm01_Error", method = RequestMethod.GET)
	public String registerForm01_Error(Model model) {
		logger.info("registerForm01_Error");
		return "home/formtag/registerForm01_Error";
	}
	
	// 2) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성값이 일치해야 한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		// 속성명에 'member'를 지정하고 폼 객체를 모델에 추가한다.
		model.addAttribute("member", new Member());
		// 클라이언트의 modelAttribute 설정과 서버와의 설정 연결을 위한 과정
		// JSP(클라이언트)에서는 modelAttribute 속성 값으로 'member' 설정
		// 컨트롤러 메소드 내 model.addAttribute('member',값) 으로 연결 준비!
		return "home/formtag/registerForm02";
	}
	
	// 3) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성값이 일치하지 않으면 에러가 발생한다.
	@RequestMapping(value = "/registerForm03", method = RequestMethod.GET)
	public String registerForm03(Model model) {
		logger.info("registerForm03");
		// 속성명에 'user'를 지정하고 폼 객체를 모델에 추가한다.
		model.addAttribute("user", new Member());
		return "home/formtag/registerForm03";
	}
	
	// 4) 폼 객체의 속성명과 스프링 폼 태그의 modelAttribute 속성값이 일치해야한다.
	@RequestMapping(value = "/registerForm04", method = RequestMethod.GET)
	public String registerForm04(Model model) {
		logger.info("registerForm04");
		// 속성명에 'user'를 지정하고 폼 객체를 모델에 추가한다.
		model.addAttribute("user", new Member());
		return "home/formtag/registerForm04";
	}
	
	// 5) 컨트롤러 메소드의 매개변수로 자바빈즈 객체가 전달이 되면 기본적으로 다시 화면으로 전달된다.
	@RequestMapping(value = "/registerForm05", method = RequestMethod.GET)
	public String registerForm05(Member member) {
		// 자바빈즈 클래스(Member)를 매개변수로 받으면 바로 해당 페이지로 전달된다.
		logger.info("registerForm05");
		return "home/formtag/registerForm05";
	}
	
	// 6) 폼 객체의 속성명은 직접 지정하지 않으면 폼 객체의 클래스명의 맨 처음 문자를 소문자로 변환하여 처리한다.
	@RequestMapping(value = "/registerForm06", method = RequestMethod.GET)
	public String registerForm06(Member user) {
		logger.info("registerForm06");
		return "home/formtag/registerForm06";
	}
	
	// 7) @ModelAttribute 어노테이션으로 폼 객체의 속성명을 직접 지정할 수 있다.
	// 500Error 발생
	@RequestMapping(value = "/registerForm07", method = RequestMethod.GET)
	public String registerForm07(@ModelAttribute("user") Member member) {
		//modelAttribute 속성값이 폼 객체의 속성명과 일치하지 않으면 에러가 발생한다.
		logger.info("registerForm07");
		return "home/formtag/registerForm07";
	}
	
	// 8) @ModelAttribute 어노테이션으로 폼 객체의 속성명을 직접 지정할 수 있다.
	@RequestMapping(value = "/registerForm08", method = RequestMethod.GET)
	public String registerForm08(@ModelAttribute("user") Member member) {
		logger.info("registerForm08");
		return "home/formtag/registerForm08";
	}
	
	// 9) 폼 객체의 프로퍼티에 값을 지정하여 모델을 통하여 전달한다.
	@RequestMapping(value = "/registerForm09", method = RequestMethod.GET)
	public String registerForm09(Model model) {
		logger.info("registerForm09");
		
		//폼 객체에 프로퍼티에 값을 지정한다.
		Member member = new Member();
		member.setUserId("hongkd");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		return "home/formtag/registerForm09";
	}
	
	// 결과) registerForm_Error ~ 09 까지의 action 결과 페이지 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Member member, Model model) {
		logger.info("register");
		logger.info("member.getUserId(): " + member.getUserId());
		logger.info("member.getUserName(): " + member.getUserName());
		logger.info("member.getEmail(): " + member.getEmail());
		logger.info("member.getPassword(): " + member.getPassword());
		logger.info("member.getIntroduction(): " + member.getIntroduction());
		logger.info("member.isForeigner(): " + member.isForeigner());
		logger.info("member.getDeveloper(): " + member.getDeveloper());
		logger.info("member.getHobby(): " + member.getHobby());
		
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
		return "home/formtag/result";
	}
	
	
}
