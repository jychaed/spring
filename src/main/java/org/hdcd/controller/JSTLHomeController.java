package org.hdcd.controller;

import java.awt.CardLayout;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jstl")
public class JSTLHomeController {
	private static final Logger logger = LoggerFactory.getLogger(JSTLHomeController.class);
	
	/*
	 * 7장 JSP
	 * 5. 표준 태그 라이브러리 (JSTL) & 코어 태그
	 */
	
	// 1) c:out value 속성에 저장한 값을 출력한다.
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Locale locale, Model model) {
		logger.info("home0101");
		Member member = new Member();
		member.setUserId("hongkd");
		model.addAttribute("member", member); // 키밸류 하듯이 정확히 명명해서 넘겨주는 역할
		return "home/jstl/home0101";
	}
	
	// 2) escapeXml 속성의 기본값은 true 이므로 특수문자를 변환한다. // 여기서 특수문자는 태그들! <a> <span> 같은거!
	@RequestMapping(value = "/home0102", method = RequestMethod.GET)
	public String home0102(Model model) {
		logger.info("home0102");
		Member member = new Member();
		member.setUserId("hongkd<>&%0102");
		model.addAttribute("member", member); 
		return "home/jstl/home0102";
	}
	
	// 3) escapeXml 속성값을 false로 지정하면 특수문자를 변환하지 않는다. // 여기서 특수문자는 태그들! <a> <span> 같은거!
	@RequestMapping(value = "/home0103", method = RequestMethod.GET)
	public String home0103(Model model) {
		logger.info("home0103");
		Member member = new Member();
		member.setUserId("<p>hongkd<>&%0102</p>");
		model.addAttribute("member", member); 
		return "home/jstl/home0103";
	}
	
	// value 속성에 지정한 값이 존재하지 않으면 default 속성에 지정한 값이 출력된다.
	@RequestMapping(value = "/home0105", method = RequestMethod.GET)
	public String home0105(Model model) {
		logger.info("home0105");
		Member member = new Member();
		model.addAttribute("member", member); 
		return "home/jstl/home0105";
	}
	
	// JSP에서 사용될 변수를 설정하지 않고 자바빈즈 프로퍼티 값을 바로 표시한다.
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		logger.info("home0201");
		Member member = new Member();
		member.setUserId("hongkd0201");
		model.addAttribute("member", member); 
		return "home/jstl/home0201";
	}
	
	// JSP에서 사용될 변수 memberId를 설정해서 사용한다.
	@RequestMapping(value = "/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		logger.info("home0202");
		Member member = new Member();
		member.setUserId("hongkd0202");
		model.addAttribute("member", member); 
		return "home/jstl/home0202";
	}
	
	// 태그의 몸체를 값으로 사용한다.
	@RequestMapping(value = "/home0203", method = RequestMethod.GET)
	public String home0203(Model model) {
		logger.info("home0203");
		Member member = new Member();
		member.setUserId("home0203");
		model.addAttribute("member", member); 
		return "home/jstl/home0203";
	}
	
	// member 객체의 userId 프로퍼티 값을 설정한다.
	@RequestMapping(value = "/home0204", method = RequestMethod.GET)
	public String home0204(Model model) {
		logger.info("home0204");
		Member member = new Member();
		model.addAttribute("member", member); 
		return "home/jstl/home0204";
	}
	
	// c:set 태그로 지정한 변수 memberId를 삭제한다.
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		logger.info("home0301");
		Member member = new Member();
		member.setUserId("hongkd0301");
		model.addAttribute("member", member); 
		return "home/jstl/home0301";
	}
	
	// EL 식 내부에서 발생항 예외는 EL식 내부에서 처리하므로 catch 변수 'ex'에 저장되지 않는다.
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		logger.info("home0401");
		Member member = new Member();
		String[] hobbyArray0401 = {"Music0401", "Movie0401"};
		member.setHobbyArray(hobbyArray0401);
		model.addAttribute("member", member); 
		return "home/jstl/home0401";
	}
	
	// JSP 표현식에서 발생한 예외는 catch 변수 'ex'에 저장된다.
	@RequestMapping(value = "/home0402", method = RequestMethod.GET)
	public String home0402(Model model) {
		logger.info("home0402");
		return "home/jstl/home0402";
	}
	
	// test 속성에 true나 false를 리턴하는 조건문이 온다.
	@RequestMapping(value = "/home0501", method = RequestMethod.GET)
	public String home0501(Model model) {
		logger.info("home0501");
		Member member = new Member();
		model.addAttribute("member", member); 
		return "home/jstl/home0501";
	}
	
	// test 속성에 true나 false를 값으로 가지는 불리언 변수가 올 수 있다.
	@RequestMapping(value = "/home0502", method = RequestMethod.GET)
	public String home0502(Model model) {
		logger.info("home0502");
		Member member = new Member();
		model.addAttribute("member", member); 
		return "home/jstl/home0502";
	}
	
	// 모든 c:when 태그의 test 결과값이 false이면 c:otherwise가 실행된다.
	@RequestMapping(value = "/home0601", method = RequestMethod.GET)
	public String home0601(Model model) {
		logger.info("home0601");
		Member member = new Member();
		model.addAttribute("member", member); 
		return "home/jstl/home0601"; 
	}
	
	// 
	@RequestMapping(value = "/home0602", method = RequestMethod.GET)
	public String home0602(Model model) {
		logger.info("home0602");
		Member member = new Member();
		member.setGender("F");
		model.addAttribute("member", member); 
		return "home/jstl/home0601"; // member.setGender("F"); 이거 담아가니~
	}
	
	// 배열값을 순차적으로 처리한다.
	@RequestMapping(value = "/home0701", method = RequestMethod.GET)
	public String home0701(Model model) {
		logger.info("home0701");
		Member member = new Member();
		String[] hobbyArray0701 = {"Music", "Movie", "Drive", "Game"};
		member.setHobbyArray(hobbyArray0701);
		model.addAttribute("member", member); 
		return "home/jstl/home0701"; 
	}
	
	// List에 저장되어 잇는 값을 순차적으로 처리한다.
	@RequestMapping(value = "/home0702", method = RequestMethod.GET)
	public String home0702(Model model) {
		logger.info("home0702");
		Member member = new Member();
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		hobbyList.add("Drive");
		hobbyList.add("Game");
		hobbyList.add("Development");
		hobbyList.add("Study");
		member.setHobbyList(hobbyList);
		model.addAttribute("member", member); 
		return "home/jstl/home0702"; 
	}
	
	// 객체를 요소값으로 가지는 List인 경우에 var 속성에 객체 변수를 지정하여 처리한다.
	@RequestMapping(value = "/home0703", method = RequestMethod.GET)
	public String home0703(Model model) {
		logger.info("home0703");
		Member member = new Member();
		List<Card> cardList = new ArrayList<Card>();
		Card card1 = new Card();
		card1.setNo("12345");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 10);
		card1.setValidMonth(cal.getTime());;
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("67890");
		
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 11);
		card2.setValidMonth(cal.getTime());;
		cardList.add(card2);
		
		member.setCardList(cardList);
		model.addAttribute("member", member); 
		return "home/jstl/home0703"; 
	}
	
	// delims속성에 지정된 구분자를 사용하여 items 속성에 전달된 문자열을 나누고 var 속성에 명시한 변수에 나위어진 문자열을 지정한다.
	// c:forTokens 사용
	@RequestMapping(value = "/home0801", method = RequestMethod.GET)
	public String home0801(Model model) {
		logger.info("home0801");
		Member member = new Member();
		String hobby = "Music,Movie,Drive,Game";
		member.setHobby(hobby);
		model.addAttribute("member", member); 
		return "home/jstl/home0801"; 
	}
	
	// 특정 URL의 결과를 읽어와서 현재 위치에 삽입한다.
	// c:import
	@RequestMapping(value = "/home0901", method = RequestMethod.GET)
	public String home0901(Model model) {
		logger.info("home0901");
		Member member = new Member();
		return "home/jstl/home0901"; 
	}
	
	// 웹어플리케이션 내에서의 절대 경로를 사용하면 실제로 생성된 컨텍스트 경로가 포함된다.
	@RequestMapping(value = "/home1001", method = RequestMethod.GET)
	public String home1001(Model model) {
		logger.info("home1001");
		Member member = new Member();
		return "home/jstl/home1001"; 
	}
	
	// 지정한 페이지로 리다이렉트시킨다.
	@RequestMapping(value = "/home1101", method = RequestMethod.GET)
	public String home1101(Model model) {
		logger.info("home1101");
		return "home/jstl/home1101"; 
	}
	
	// 지정한 페이지로 리다이렉트시킨다.
	@RequestMapping(value = "/home1102", method = RequestMethod.GET)
	public String home1102(Model model) {
		logger.info("home1102");
		return "home/jstl/home1102"; 
	}
	
	
	
	
	
}







