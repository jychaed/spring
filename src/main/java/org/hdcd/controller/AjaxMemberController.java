package org.hdcd.controller;

import java.util.List;

import org.hdcd.vo.Address;
import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.ls.LSInput;

@Controller
@RequestMapping("/ajax")
public class AjaxMemberController {
	private static Logger logger = LoggerFactory.getLogger(AjaxMemberController.class);
	
	// 9. Ajax 방식 요청 처리 시작 페이지
	// URL : /ajax/registerForm
	@RequestMapping(value = "/registerForm")
	public String ajaxRegisterForm() {
		return "member/ajaxRegisterForm";	
	}
	
	// 1)
	// URL 경로상의 경로 변수 값을 @PathVariable 어노테이션을 지정하며 문자열 매개변수 처리한다.
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public ResponseEntity<String> ajaxRegister01(@PathVariable("userId") String userId){
		logger.info("ajaxRegister01");
		logger.info("userId : " + userId);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 2)
	// URL 경로 상의 여러개의 경로 변수 값을 @PathVariable 어노테이션을 지정하여 문자열 매개변수로 처리한다.
	@RequestMapping(value = "/register/{userId}/{password}", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister02(
			@PathVariable("userId") String userId,
			@PathVariable("password") String password){
		logger.info("ajaxRegister02");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 3)
	// 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정하여 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register03", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister03(@RequestBody Member member){
		logger.info("ajaxRegister03");
		logger.info("userId : " + member.getUserId());
		logger.info("password : " + member.getPassword());
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 4)
	// 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다.
	@RequestMapping(value = "/register04", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister04(String userId){
		// 요청 본문에서 데이터가 바인딩 되지 않아 userId가 null이 나온다.
		// 요청 본문에서 데이터를 가져오려면 @RequestBody 어노테이션이 필요하다.
		logger.info("ajaxRegister04");
		logger.info("userId : " + userId);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 5)
	// 요청 URL에 쿼리파라미터를 붙여서 전달하면 문자열 매개변수로 처리한다
	@RequestMapping(value = "/register05", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister05(String userId, String password){
		// userId 는 쿼리스트링에 담겨져 오는 데이터이기 때문에, 일반적인 방식으로도 데이터를 받을 수 있지만,
		// password는 요청 본문에서 데이터를 바인딩해 받아오지 못하므로 null이 출력된다.
		logger.info("ajaxRegister05");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 6)
	// 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와
	// @ReauestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/register06/{userId}", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister06(@PathVariable("userId") String userId,
			@RequestBody Member member){
		logger.info("ajaxRegister06");
		logger.info("userId : " + userId);
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " + member.getPassword());
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 7)
	// 객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬렉션 매개변수에 @ReauestBody 어노테이션을 지정하여 처리한다.
	@RequestMapping(value = "/register07", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister07(@RequestBody List<Member> memberList){ // 그냥 List는 안되고 @RequestBody 해줘서 가능
		logger.info("ajaxRegister07");
		
		for(Member member : memberList) {
			logger.info("userId() : " + member.getUserId());
			logger.info("password() : " + member.getPassword());
		}
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 8)
	// 중첩된 객체 배열 타입의 JSON 요청 데이터를 @ReauestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다
	@RequestMapping(value = "/register08", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister08(@RequestBody Member member){ // 그냥 List는 안되고 @RequestBody 해줘서 가능
		logger.info("ajaxRegister08");
		
		logger.info("userId : " + member.getUserId());
		logger.info("password : " + member.getPassword());

		Address address = member.getAddress();
		
		if(address != null) {
			logger.info("address .password : " + address.getPostCode());
			logger.info("address .password : " + address.getLocation());
		}else {
			logger.info("address == null");
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 9)
	// 중첩된 객체 타입의 JSON 요청 데이터를 @ReauestBody 어노테이션을 지정하여 중첩된 자바빈즈 매개변수로 처리한다
	@RequestMapping(value = "/register09", method = RequestMethod.POST)
	public ResponseEntity<String> ajaxRegister09(@RequestBody Member member){ // 그냥 List는 안되고 @RequestBody 해줘서 가능
		logger.info("ajaxRegister09");
		
		logger.info("userId : " + member.getUserId());
		logger.info("password : " + member.getPassword());
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList.size() : " + cardList.size());
			
			for(int i = 0; i< cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() : " + card.getNo());
				logger.info("card.getValidMonth() : " + card.getValidMonth());
			}
		}else {
			logger.info("cardList == null");
		}
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
}
