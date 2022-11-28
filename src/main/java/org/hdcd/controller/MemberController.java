package org.hdcd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.vo.Address;
import org.hdcd.vo.AllMember;
import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.hdcd.vo.MultiFileMember;
import org.hdcd.vo.fileMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	// 4. 요청 처리 자바빈즈
	// 1)
	// 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/beans/register01", method = RequestMethod.POST) ///beans/register01 이 url 타입으로 
	public String registerJavaBeans01(Member member){	// () 안의 매개변수를 받는데 어찌 받는지 방법론 기억하기
		logger.info("registerJavaBeans01");
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " + member.getPassword());
		logger.info("member.getCoin() : " + member.getCoin());
		return "success";
	}
	
	// 2)
	// 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다.
	@RequestMapping(value = "/beans/register02", method = RequestMethod.POST) 
	public String registerJavaBeans02(Member member, int coin){	// () 매개변수 받을 때 => 맵은 예외 어노테이션 무조건 써야하고 그외는 이름이 같으면 자동바인딩 됨
		logger.info("registerJavaBeans02");
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " + member.getPassword());
		logger.info("coin : " + coin);
		return "success";
	}
	
	// 3)
	// 여러개의 폼 텍스트 필드 요소값을 매개변수 순서와 상관없이 매개변수명을 기준으로 처리한다.
	@RequestMapping(value = "/beans/register03", method = RequestMethod.POST) 
	public String registerJavaBeans03(Member member, int uid){	
		logger.info("registerJavaBeans03");
		logger.info("uid : " + uid);
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " + member.getPassword());
		logger.info("member.getCoin() : " + member.getCoin());
		return "success";
	}

	
	// 5. Date 타입 처리
	// 1)
	// 쿼리 파라미터(dateOfBirth=1234)로 전달 받은 값이 날짜 문자열 형식에 맞지 않아 Date타입으로 변환에 실패한다
	@RequestMapping(value = "/registerByGet01", method = RequestMethod.GET) // a태그로 요청했으니 get이겠죠 
	public String registerByGet01(String userId, @DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth){	
		logger.info("registerByGet01");
		logger.info("userId : " + userId);
		logger.info("dateOfBirth : " + dateOfBirth);
		return "success"; // 404 떠야함 ㅎㅎㅎ
	}
	
	// 5)
	// Member 매개변수와 쿼리 파라미터(dateOfBirth=20180908)로 전달 받은 값이 날짜 문자열 형식에 맞지 않아 Date타입으로 변환에 실패한다
	@RequestMapping(value = "/registerByGet02", method = RequestMethod.GET) 
	public String registerByGet02(Member member){	
		logger.info("registerByGet02");
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getDateOfBirth() : " + member.getDateOfBirth());
		return "success"; 
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST) 
	public String register(Member member){	
		logger.info("register");
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " + member.getPassword());
		logger.info("member.getDateOfBirth() : " + member.getDateOfBirth());
		return "success"; 
	}
	
	
	// 7. 폼방식 요청 처리
 	// 1) 
	// 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	
	@RequestMapping(value = "/registeruserId", method = RequestMethod.POST) 
	public String registeruserId(String userId){	
		logger.info("registeruserId");
		logger.info("userId : " + userId);
		return "success"; 
	}
	
	// 2) 
	// 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다
	@RequestMapping(value = "/registerMemberUserId", method = RequestMethod.POST) 
	public String registerMemberUserId(Member member){	
		logger.info("registerMemberUserId");
		logger.info("member.getUserId() : " + member.getUserId());
		return "success"; 
	}
	
	// 3) 
	// 폼 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다
	@RequestMapping(value = "/registerPassword", method = RequestMethod.POST) 
	public String registerPassword(Member member){	
		logger.info("registerPassword");
		logger.info("member.getPassword() : " + member.getPassword());
		return "success"; 
	}
	
	// 4) 
	// 폼 라디오 버튼 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerRadio", method = RequestMethod.POST) 
	public String registerRadio(String gender){	
		logger.info("registerRadio");
		logger.info("gender : " + gender);
		return "success"; 
	}
	
	// 5) 
	// 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerSelect", method = RequestMethod.POST) 
	public String registerSelect(String nationality){	
		logger.info("registerSelect");
		logger.info("nationality : " + nationality);
		return "success"; 
	}
	
	// 6) 
	// 복수 선택이 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultiSelect01", method = RequestMethod.POST) 
	public String registerMultiSelect01(String cars){	
		logger.info("registerMultiSelect01");
		logger.info("cars : " + cars);
		return "success"; 
	}
	
	// 7) 
	// 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 배열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultiSelect02", method = RequestMethod.POST) 
	public String registerMultiSelect02(String[] carArray){	
		logger.info("registerMultiSelect02");
		
		if(carArray != null) {
			logger.info("carArray.length : " + carArray.length);
			for(int i = 0 ; i< carArray.length; i++) {
				logger.info("carArray[" + i + "] : " + carArray[i]);
			}
		}else {
			logger.info("carArray == null ");
		}
		return "success"; 
	}
	
	// 8) 
	// 복수 선택이 가능한 폼 셀렉트 박스 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultiSelect03", method = RequestMethod.POST) 
	public String registerMultiSelect03(ArrayList<String> carList){	
		logger.info("registerMultiSelect03");
		
		// 리스트로는 셀렉트 박스 값을 가져올 수 없습니다.
		// 배열 형태를 사용하거나 객체를 이용하세요
		if(carList != null && carList.size() > 0) {
			logger.info("carList.size() : " + carList.size());
			for(int i = 0 ; i < carList.size(); i++) {
				logger.info("carList[" + i + "] : " + carList.get(i));
			}
		}else {
			logger.info("carList == null ");
		}
		
		return "success"; 
	}
	
	// 9)
	// 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox01", method = RequestMethod.POST) 
	public String registerCheckbox01(String hobby){
		logger.info("registerCheckbox01");
		logger.info("hobby: " + hobby);
		return "success"; 
	}
	
	// 10)
	// 폼 체크박스 요소값을 문자열 배열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox02", method = RequestMethod.POST) 
	public String registerCheckbox02(String[] hobbyArray){
		logger.info("registerCheckbox02");
		if(hobbyArray != null) {
			logger.info("hobbyArray.length : " + hobbyArray.length);
			for(int i = 0 ; i < hobbyArray.length; i++) {
				logger.info("hobbyArray[" + i + "] : " + hobbyArray[i]);
			}
		}else {
			logger.info("hobbyArray == null ");
		}
		return "success"; 
	}
	
	// 11)
	// 폼 체크박스 요소값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다
	@RequestMapping(value = "/registerCheckbox03", method = RequestMethod.POST) 
	public String registerCheckbox03(List<String> hobbyList){	
		logger.info("registerCheckbox03");
		// 1) ArrayList로 값을 받는 경우
		// - 값이 넘어오지 않아 size 0
		
		// 2) List로 값을 받는 경우
		// - No primary or default constructor found for interface java.util.List 에러발생
		// - Spring에서 List로는 데이터를 받는게 XXXXXXXXX
		// - 리스트와 같은 형태의 값을 받으려면 String[] 로 여러 데이터를 받아서 List에 담는 방법이 있습니다.
		if(hobbyList != null && hobbyList.size() > 0) {
			logger.info("hobbyList.size() : " + hobbyList.size());
			for(int i = 0 ; i < hobbyList.size(); i++) {
				logger.info("hobbyList[" + i + "] : " + hobbyList.get(i));
			}
		}else {
			logger.info("hobbyList == null ");
		}
		
		return "success"; 
	}
	
	// 12)
	// 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다
	@RequestMapping(value = "/registerCheckbox04", method = RequestMethod.POST) 
	public String registerCheckbox04(String developer){	
		logger.info("registerCheckbox04");
		logger.info("developer : " + developer);
		return "success"; 
	}
	
	// 13)
	// 폼 체크박스 요소값을 기본 데이터 타입인 불리언 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox05", method = RequestMethod.POST) 
	public String registerCheckbox05(boolean foreigner){	
		logger.info("registerCheckbox05");
		logger.info("foreigner : " + foreigner);
		return "success"; 
	}
	
	// 14)
	// 폼 체크박스 요소값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerAddress", method = RequestMethod.POST) 
	public String registerAddress(Address address){	
		logger.info("registerAddress");
		if(address != null){
			logger.info("address.getPostCode() : " + address.getPostCode());
			logger.info("address.getLocation() : " + address.getLocation());
		}else {
			logger.info("address == null ");
		}
		return "success"; 
	}
	
	// 15)
	// 폼 체크박스 요소값을 중첩된 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerUserAddress", method = RequestMethod.POST) 
	public String registerUserAddress(Member member){	
		logger.info("registerUserAddress");
		
		Address address = member.getAddress();
		
		if(address != null){
			logger.info("address.getPostCode() : " + address.getPostCode());
			logger.info("address.getLocation() : " + address.getLocation());
		}else {
			logger.info("address == null");
		}
		return "success"; 
	}
	
	// 16)
	// 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다
	@RequestMapping(value = "/registerUserCardList", method = RequestMethod.POST) 
	public String registerUserCardList(Member member){	
		logger.info("registerUserCardList");
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null){
			logger.info("cardList.size() :" + cardList.size());
			
			for(int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() :" + card.getNo());
				logger.info("card.getValidMonth() :" + card.getValidMonth());
			}
		}else {
			logger.info("cardList == null");
		}
		return "success"; 
	}
	
	
	// 17)
	// 폼 텍스트 영역 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerTextArea", method = RequestMethod.POST) 
	public String registerTextArea(String introduction){	
		logger.info("registerTextArea");
		logger.info("introduction :" + introduction);
		return "success"; 
	}
	
	// 18)
	// 폼 텍스트 영역 요소값을 Date 타입 매개변수로 처리한다.
	// 정상적인 날짜 데이터를 출력하기 위해서는 날짜 문자열 형식을 'yyyy/MM/dd' 형식으로 지정해야한다.
	// 내가 원하는 문자열 형식을 지정하려면 @DateTimeFormat 어노테이션을 이용하여 해당 형식에 맞춰 데이터를 보내면 된다.
	@RequestMapping(value = "/registerDate01", method = RequestMethod.POST) 
//	public String registerDate01(Date dateOfBirth){	
	public String registerDate01(@DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth){	
		logger.info("registerDate01");
		if(dateOfBirth != null) {
			logger.info("dateOfBirth : " + dateOfBirth);
		} else {
			logger.info("dateOfBirth == null ");
		}
		return "success"; 
	}
	
	
	// ===================================
	// Register All Form 요청 컨트롤러 메소드
	// ===================================
	@RequestMapping(value="/registerAllForm")
	public String registerAllForm() {
		return "member/registerAllForm";
	}
	
	@RequestMapping(value="/registerUser")
	public ModelAndView registerAllFormProcess(AllMember allMember) {
		logger.info("userId;" + allMember.getUserId());
		logger.info("password;" + allMember.getPassword());
		logger.info("userName;" + allMember.getUserName());
		logger.info("email;" + allMember.getEmail());
		logger.info("dateOfBirth;" + allMember.getDateOfBirth());
		logger.info("gender;" + allMember.getGender());
		logger.info("developer;" + allMember.getDeveloper());
		logger.info("foreigner;" + allMember.getForeigner());
		logger.info("nationality;" + allMember.getNationality());
		logger.info("cars;" + allMember.getCars());
		logger.info("hobby;" + allMember.getHobby());
		logger.info("postCode;" + allMember.getPostCode());
		logger.info("address;" + allMember.getAddress());
		logger.info("cardNo;" + allMember.getCardNo());
		logger.info("validMonth;" + allMember.getValidMonth());
		logger.info("introduction;" + allMember.getIntroduction());
		
		String gender = allMember.getGender();
		if(gender.equals("male")) {
			allMember.setGender("남자");
		}else {
			allMember.setGender("여자");
		}
		
		String developer = allMember.getDeveloper();
		if(developer.equals("Y")) {
			allMember.setDeveloper("개발자 O");
		}else {
			allMember.setDeveloper("개발자 X");
		}
		
		String foreigner = allMember.getForeigner();
		if(foreigner == null) {
			allMember.setForeigner("외국인 X");
		}else {
			allMember.setForeigner("외국인 O");
		}
		
		String nationality = allMember.getNationality();
		if(nationality.equals("korea")) {
			allMember.setNationality("대한민국");
		}else if(nationality.equals("germany")) {
			allMember.setNationality("독일");
		}else if(nationality.equals("austrailia")) {
			allMember.setNationality("호주");
		}else if(nationality.equals("canada")) {
			allMember.setNationality("캐나다");
		}
		
		String cars = allMember.getCars();
		String[] carsArr = cars.split(",");
		String carStr = "";
		for (int i = 0; i < carsArr.length; i++) {
			if(carsArr[i].equals("jeep")) {
				carStr += "지프 ";
			}else if(carsArr[i].equals("bmw")) {
				carStr += "비엠더블유 ";
			}else if(carsArr[i].equals("audi")) {
				carStr += "아우디 ";
			}else if(carsArr[i].equals("volvo")) {
				carStr += "볼보 ";
			}
		}
		allMember.setCars(carStr);
		
		String hobby = allMember.getHobby();
		String[] hobArr = hobby.split(",");
		String hobStr = "";
		for (int i = 0; i < hobArr.length; i++) {
			if(hobArr[i].equals("sports")) {
				hobStr += "운동 ";
			}else if(hobArr[i].equals("music")) {
				hobStr += "음악 ";
			}else if(hobArr[i].equals("movie")) {
				hobStr += "영화 ";
			}
		}
		allMember.setHobby(hobStr);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("allMember", allMember);
		mav.setViewName("member/registerAllResult");
		return mav;
	}
	
	
	
	
	// 8. 파일업로드 폼 방식 요청 처리
	// 파일 업로드 폼 방식
	// 1) 
	// 파일 업로드 폼 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개 변수로 처리한다
	@RequestMapping(value = "/registerFile01", method = RequestMethod.POST) 
	public String registerFile01(MultipartFile picture){	
		logger.info("registerFile01");
		logger.info("OriginalFilename" + picture.getOriginalFilename());
		logger.info("Size" + picture.getSize());
		logger.info("ContentType" + picture.getContentType());
		return "success"; 
	}
	
	//20221128
	// 2) 
	// 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개 변수와 문자열 매개변수로 처리한다
	@RequestMapping(value = "/registerFile02", method = RequestMethod.POST) 
	public String registerFile02(String userId, String password, MultipartFile picture){	
		logger.info("registerFile02");
		logger.info("userId" + userId);
		logger.info("password" + password);
		
		logger.info("OriginalFilename" + picture.getOriginalFilename());
		logger.info("Size" + picture.getSize());
		logger.info("ContentType" + picture.getContentType());
		
		return "success"; 
	}
	
	// 3) 
	// 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개 변수와 자바빈즈 매개변수로 처리한다
	@RequestMapping(value = "/registerFile03", method = RequestMethod.POST) 
	public String registerFile03(Member member, MultipartFile picture){	
		logger.info("registerFile03");
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getPassword() : " + member.getPassword());
		
		logger.info("OriginalFilename" + picture.getOriginalFilename());
		logger.info("Size" + picture.getSize());
		logger.info("ContentType" + picture.getContentType());
		
		return "success"; 
	}
	
	// 4) 
	// 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 FileMember 타입의 자바빈즈 매개변수로 처리한다
	@RequestMapping(value = "/registerFile04", method = RequestMethod.POST) 
	public String registerFile04(fileMember fileMember){	
		logger.info("registerFile04");
		logger.info("member.getUserId() : " + fileMember.getUserId());
		logger.info("member.getPassword() : " + fileMember.getPassword());
		
		MultipartFile picture = fileMember.getPicture();
		
		logger.info("OriginalFilename" + picture.getOriginalFilename());
		logger.info("Size" + picture.getSize());
		logger.info("ContentType" + picture.getContentType());
		
		return "success"; 
	}
	
	// 5) 
	// 여러 개의 파일 업로드를 폼 파일 요소 값을 여러개의 MultipartFile 매개변수로 처리한다
	@RequestMapping(value = "/registerFile05", method = RequestMethod.POST) 
	public String registerFile05(MultipartFile picture, MultipartFile picture2 ){	
		logger.info("registerFile05");
		logger.info("OriginalFilename" + picture.getOriginalFilename());
		logger.info("Size" + picture.getSize());
		logger.info("ContentType" + picture.getContentType());
		
		logger.info("OriginalFilename" + picture2.getOriginalFilename());
		logger.info("Size" + picture2.getSize());
		logger.info("ContentType" + picture2.getContentType());
		
		return "success"; 
	}
	
	// 6) 
	// 여러 개의 파일 업로드를 폼 파일 요소 값을 MultipartFile 타입의 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다
	@RequestMapping(value = "/registerFile06", method = RequestMethod.POST) 
	public String registerFile06(List<MultipartFile> pictureList ){	
		// 컬렉션 리스트로는 이미지 파일을 가져올 수 없다.
		logger.info("registerFile06");
		logger.info("pictureList.size() " + pictureList.size());
	
		for(int i = 0; i < pictureList.size(); i++) {
			logger.info("OriginalFilename" + pictureList.get(i).getOriginalFilename());
			logger.info("Size" + pictureList.get(i).getSize());
			logger.info("ContentType" + pictureList.get(i).getContentType());
		}
		
		return "success"; 
	}
	
	// 7) , 7-2) 
	// 여러 개의 파일 업로드 폼 파일 요소 값과 텍스트 필드 요소값을 MultipartFileMember 타입의 자바빈즈 매개변수로 처리한다
	// 객체 내에 존재하는 key(변수명)로 파일을 받을 수 있다.
	// 7)은 input file 2개로 객체에 mapping
	// 7-2)는 multiple 요소 이용하여 개게에 mapping
	@RequestMapping(value = "/registerFile07", method = RequestMethod.POST) 
	public String registerFile07(MultiFileMember multifileMember){	
		logger.info("registerFile07");
		
		List<MultipartFile> pictureList =  multifileMember.getPictureList();
		logger.info("registerFile07 pictureList.size() : " + pictureList.size());
		
		for(MultipartFile picture : pictureList) {
			logger.info("OriginalFilename" + picture.getOriginalFilename());
			logger.info("Size" + picture.getSize());
			logger.info("ContentType" + picture.getContentType());
		}
		
		return "success"; 
	}
	
	// 8) 
	// 파일 업로드 폼 파일 요소 값과 텍스트 필드 요소값을 MultipartFile 타입의 배열 매개변수로 처리한다
	@RequestMapping(value = "/registerFile08", method = RequestMethod.POST) 
	public String registerFile08(MultipartFile[] pictureList){	
		logger.info("registerFile08");
		logger.info("registerFile08 pictureList.length : " + pictureList.length);
		
		for(MultipartFile picture : pictureList) {
			logger.info("OriginalFilename" + picture.getOriginalFilename());
			logger.info("Size" + picture.getSize());
			logger.info("ContentType" + picture.getContentType());
		}
		
		return "success"; 
	}
	
	
	
}














