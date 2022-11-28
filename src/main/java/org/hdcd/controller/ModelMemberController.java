package org.hdcd.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hdcd.vo.Address;
import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModelMemberController {
	
	private static Logger logger = LoggerFactory.getLogger(AjaxMemberFileController.class);
	/*
	 * 6장. 데이터 전달자 모델
	 * - Model 객체 이용
	 * 1) 매개변수에 선언된 Model 객체의 addAttribute() 메서드를 호출하여 데이터를 뷰(View)에 전달한다.
	 */
	@RequestMapping(value = "/read01", method = RequestMethod.GET)
	public String read01(Model model) {
		logger.info("read01");
		model.addAttribute("userId", "hongkd");
		model.addAttribute("password", "1234");
		model.addAttribute("email", "aaa@ccc.com");
		model.addAttribute("userName", "홍길동");
		model.addAttribute("birthDay", "2022-11-28");
		return "member/read01";
	}
	
	// 2) Model 객체에 자바빈즈 클래스 객체를 값으로만 전달할 때는 
	// 뷰에서 참조할 이름을 클래스명의 앞글자를 소문자로 변환하여 처리한다.
	@RequestMapping(value = "/read02", method = RequestMethod.GET)
	public String read02(Model model) {
		logger.info("read02");
		
		Member member = new Member();
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setBirthDay("2022-11-28");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONDAY, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		model.addAttribute(member);
		return "member/read02";
	}
	
	// 3) Model 객체에 자바빈즈 클래스 객체를 특정한 이름을 지정하여 전달할 수 있다
	@RequestMapping(value = "/read03", method = RequestMethod.GET)
	public String read03(Model model) {
		logger.info("read03");
		
		Member member = new Member();
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setBirthDay("2022-11-28");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONDAY, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateOfBirth(cal.getTime());
		model.addAttribute("user", member);
		
		return "member/read03";
	}
	
	// 4) Model 객체를 통해 배열과 컬렉션 객체를 전달할 수 있다
	@RequestMapping(value = "/read04", method = RequestMethod.GET)
	public String read04(Model model) {
		logger.info("read04");
		
		String[] carArray = {"jeep", "bmw"};
		
		List<String> carList = new ArrayList<String>();
		carList.add("jeep");
		carList.add("bmw");
		
		String[] hobbyArray = {"Music", "Movie"};

		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		model.addAttribute("carArray", carArray);
		model.addAttribute("carList", carList);
		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("hobbyList", hobbyList);
		
		return "member/read04";
	}
	
	// 5) Model 객체를 통해 중첩된 자바빈즈 객체를 전달할 수 있다
	@RequestMapping(value = "/read05", method = RequestMethod.GET)
	public String read05(Model model) {
		logger.info("read05");
		
		Member member = new Member();
		
		Address address = new Address();
		address.setPostCode("080908");
		address.setLocation("seoul");;
		
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<Card>();
		Card card1 = new Card();
		card1.setNo("123456");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("456789");
		
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		card2.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		model.addAttribute("user", member);

		return "member/read05";
	}
	
	// 6) Model 객체를 통해 다양한 타입의 값을 전달할 수 있다.
	@RequestMapping(value = "/read06", method = RequestMethod.GET)
	public String read06(Model model) {
		logger.info("read06");
		
		Member member = new Member();
		member.setUserId("hongkd");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("홍길동");
		member.setBirthDay("2022-11-28");
		member.setGender("male");
		member.setDeveloper("Y");
		member.setForeigner(true);
		member.setNationality("Canada");
		member.setCars("jeep");
		member.setHobby("Sports");
		
		String[] carArray = { "jeep", "bmw" };
		member.setCarArray(carArray);
		
		List<String> carList = new ArrayList<String>();
		carList.add("jeep");
		carList.add("bmw");
		member.setCarList(carList);
		
		String[] hobbyArray = {"Music", "Movie"};
		member.setHobbyArray(hobbyArray);
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		member.setHobbyList(hobbyList);
		
		Address address = new Address();
		address.setPostCode("090890");
		address.setLocation("Daejeon");
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<Card>();
		Card card1 = new Card();
		card1.setNo("123456");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card1.setNo("456789");
		
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		card2.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 2);
		
		member.setDateOfBirth(cal.getTime());
		
		String introduction = "안녕하세요\n 반갑습니다.";
		member.setIntroduction(introduction);
		model.addAttribute("user", member);
				
		return "member/read06";
	}
	
	
	
	
	
	
	
	
	
	
}




