package org.hdcd.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/formHome", method = RequestMethod.GET)	
	public String formHome() {
		return "formHome";
	}
	
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		return "ajaxHome";
	}
	
//	@RequestMapping(value = "/hoho")
//	public String hoho() {
//		return "board/hoho";
//	}
	
	// 4. 컨트롤러 응답
	
	/* 1) void 타입  =================================================================== */
	//호출하는 URL과 동일한 뷰 이름을 나타내기 위해 사용합니다.
	
	@RequestMapping(value = "/goHome0101", method = RequestMethod.GET) //goHome0101 해당 요청했을때 갈 jsp 페이지가 리턴됨
	public void goHome0101() {
		logger.info("goHome0101");
	}
	
	@RequestMapping(value = "/sub/goHome0102", method = RequestMethod.GET) // value 값으로 주소를 지정해서 찾아줌
	public void goHome0102() {
		logger.info("goHome0102");
	}
	
	/* void 타입 End */
	
	
	/* 2) String 타입 ===================================================================*/
	//뷰 파일의 경로와 파일 이름을 나타내기 위해 사용합니다.
	
	@RequestMapping(value = "/goHome0201", method = RequestMethod.GET)
	public String goHome0201() {
		logger.info("goHome0201");
		return "goHome0201";
	}
	
	@RequestMapping(value = "/sub/goHome0202", method = RequestMethod.GET)
	public String goHome0202() {
		logger.info("goHome0202");
		return "goHome0202";
	}
	// /sub/goHome0202 이녀석은 그냥 출발지고! return "goHome0202" 이게 도착지임!!! 경로 확인해서 잘쓰기 리턴~
	
	
	// 반환값이 "sub/goHome0203"이므로, 뷰(/sub/goHome0203.jsp)를 가리킨다.
	@RequestMapping(value = "/sub/goHome0203", method = RequestMethod.GET)
	public String goHome0203() {
		logger.info("goHome0203");
		return "sub/goHome0203";
	}
	// "/sub/goHome0203" 이게 요청 url 이고  return "sub/goHome0203"; 여기가 최종 목적지
	// 이건 뷰리졸버가 서버에서 리소스를 찾는게 그걸 찾아서 응답 데이터를 그냥 담아서 200보냄 forword방식 
	// 하나의 리퀘스트 최초의 그것이 공유되는것
	
	
	// 반환값이 "redirect:"로 시작하면 리타이렉트 방식으로 처리한다.
	// 클라이언트에서 출발지를 /sub/goHome0204로 요청하고 해당 URL을 매핑하는 컨드롤러 메서드가 실행되는데,
	// 이때, 퍼리부문에서 "redirect:"가 이뤄지면 처음 요청된 요청(/sub/goHome0204)이 출발지에서 시작되고
	// 서버에서 redirect하고자하는 URL을 재차 클라이언트에게 물어봅니다.
	// 클라이언트는 재차 물어본 해당 URL이 맞으면 서버측으로 다시 최종 도착지 URL(/sub/goHome0203)을 다시 요청합니다(여기서 새로운 요청/응답이 생성)
	// 서버는 최종 도착지 URL을 요청으로 받아 해당 요청에 맞는 페이지를 응답으로 만들어서 클라이언트로 최종 리턴합니다.
	@RequestMapping(value = "/sub/goHome0204", method = RequestMethod.GET)
	public String goHome0204() {
		logger.info("goHome0204");
		return "redirect:/sub/goHome0203"; 
	}
	// 리다이렉트 만나서 변경됨! Status Code: 302 이거 나왔다가 변경됨! 최종으로 다시 요청 서버는 리다이렉트하면 Status Code: 200됨 

	
	// "/"로 시작하면 웹 어플리케이션의 컨텍스트 경로에 영향을 받지 않는 절대 경로를 의미합니다.
	// 해당 경로 예) D:\Class\Spring2\workspace\.metadata\.plugins\org.eclipse.wst.server.core\...
	//				 WEB-INF\views\sub\home0205.jsp
	@RequestMapping(value = "/sub/goHome0205", method = RequestMethod.GET)
	public String goHome0205() {
		logger.info("goHome0205");
		return "/sub/goHome0205"; 
	}
	 
	/* String 타입 End */
	
	/* 3) 자바빈즈 클래스 타입 =================================================================== */
	// 어노테이션 ResponseBody를 지정하지 않으면 HTTP 404에러가 발생합니다.
	// 어노테이션 ResponseBody가 객체를 리턴하여 객체를 응답 데이터로 보내는 역할을 합니다.
	// 어노테이션 ResponseBody의 리턴 default 데이터 형식은 json입니다.
	
	// 어노테이션 ResponseBody 대신에 어노테이션 RestController를 이용하여 대체할 수 있습니다.
	@ResponseBody
	@RequestMapping(value = "/goHome0301" , method = RequestMethod.GET)
	public Member gohome0301() {
		logger.info("gohome0301");
		Member member = new Member();
		
		// 응답 데이터로 내보낼 데이터 확인
		logger.info(member.getUserId());
		logger.info(member.getPassword());
		logger.info(member.getUserName());
		
		return member; // 확장자를 json 깔아주고 보여주려면 @ResponseBody 또는 @RestController
		
	}
	
	/* 자바빈즈 클래스 End */
	
	/* 4) 컬렉션 List 타입 =================================================================== */
	// 1) @ResponseBody를 이용한 방식
	// 반환값이 컬렉션 List타입이면 JSON 객체 배열 타입으로 자동으로 변환한다.
	@ResponseBody
	@RequestMapping(value = "/goHome0401", method = RequestMethod.GET)
	public List<Member> goHome0401(){
		logger.info("goHome0401");
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		list.add(member);
		
		Member member2 = new Member();
		list.add(member2);
		
		return list;
	}
	
	
	/* 4) 컬렉션 List 타입 End */
	
	/* 5) 컬렉션 Map 타입 =================================================================== */
	// 1) @ResponseBody를 이용하는 방식
	@ResponseBody
	@RequestMapping(value = "/goHome0501", method = RequestMethod.GET)
	public Map<String, Member> goHome0501(){
		logger.info("goHome0501");
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		map.put("key1", member);
		
		Member member2 = new Member();
		map.put("key2", member2);
		
		return map;
		
	}
	
	/* 5) 컬렉션 Map 타입 End */
	
	/* 6) ResponseEntity<Void> 타입 =================================================================== */
	// 1) @ResponseBody를 이용하는 방식
	
	// Void 타입은 아무런 형태가 아닌데 제네릭 타입의 뭔가는 채워야겠어서 채우는 Placeholder같은 느낌이랄까 
	@ResponseBody
	@RequestMapping(value = "/goHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> goHome0601(){
		logger.info("goHome0601");
		return new ResponseEntity<Void>(HttpStatus.OK);
		// 내가 요청한 url로 응답이 나가면서 응답데이터로 아무런 값이 전달되지 않는다.
		// 해당 URl 요청후, 브라우저에서 개발자 도구를 이용해 네트워크 탭을 확인해보면
		// 응답으로 해당하는 URL이 응답으로 나간걸 확인할 수 있다.
	}
	/* 6) ResponseEntity<Void> 타입 End */
	
	/* 7)  ResponseEntity<String> 타입 =================================================================== */
	@ResponseBody
	@RequestMapping(value = "/goHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> goHome0701(){
		logger.info("goHome0701");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	/* 7)  ResponseEntity<String> 타입 End */
	
	/* 8)  ResponseEntity<자바빈즈 클래스> 타입 =================================================================== */
	// response할 때, HTTP 헤더 정보와 객체 데이터를 전달하는 용도로 쓰인다
	@ResponseBody
	@RequestMapping(value = "/goHome0801", method = RequestMethod.GET)
	public ResponseEntity<Member> goHome0801(){
		logger.info("goHome0801");
		Member member = new Member();
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	/* 8)  ResponseEntity<자바빈즈 클래스> 타입 End */
	
	/* 9)  ResponseEntity<List<Member>> 타입 =================================================================== */
	// response할 때, HTTP 헤더 정보와 객체 배열 데이터를 전달하는 용도로 사용한다.
	@ResponseBody
	@RequestMapping(value = "/goHome0901", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> goHome0901(){
		logger.info("goHome0901");
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		list.add(member);
		
		Member member2 = new Member();
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	/* 9)  ResponseEntity<List<Member>> 타입 End */
	
	/* 10) ResponseEntity<Map> 타입  =================================================================== */
	// response할 때, HTTP 헤더 정보와 객체 데이터를 Map 형태로 전달하는 용도로 사용한다. 
	@ResponseBody
	@RequestMapping(value = "/goHome1001", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> goHome1001(){
		logger.info("goHome1001");
		
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		map.put("key1", member);
		
		Member member2 = new Member();
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String, Member>>(map, HttpStatus.OK);
	}
	/* 10) ResponseEntity<Map> 타입 end */
	
	/* 11) ResponseEntity<byte[]> 타입  =================================================================== */
	// 이미지 출력
	// response할 때, HTTP 헤더 정보와 객체 데이터를 Map 형태로 전달하는 용도로 사용한다. 
	@RequestMapping(value = "/goHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> goHome1101(){
		logger.info("goHome1101");
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\02.SPRING2\\study_img\\busan.jpg");
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
		
	}
	
	// 압축파일 다운로드 (각각 버전 다르게 해야함)
	@RequestMapping(value = "/goHome1102", method = RequestMethod.GET)	
	public ResponseEntity<byte[]> goHome1102() throws Exception{
		logger.info("goHome1102");
		String fileName = "busan.zip"; // 내가 받고자는 파일 넣었지  busan.zip 다운로드하기 위해서 읽어들여와서 받고자는 사용자한테 플러쉬!해야지? 우선 파일 읽어
		InputStream in = null; // InputStream이 파일 읽어오지!
		ResponseEntity<byte[]> entity = null;
		
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\02.SPRING2\\study_img\\" + fileName);
			// MediaType.APPLICATION_OCTET_STREAM은 이진 파일을 위한 기본값입니다.
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 이걸 이용해서 이진데이터로 읽어드린 내용으로 라이트하는데 
			headers.add("Content-Disposition", "attachment; filename=\"" + 
									new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\""); //"ISO-8859-1" 데이터 인코딩의 값을 파일 데이터를 "UTF-8"로 바꾸겠다.
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED); //IOUtils.toByteArray(in) 내가 응답으로 보낸 거기로 보내주는 애 in이라는 파일을 가지고 HttpStatus.CREATED 상태를 만들어줄께
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	/* 11) ResponseEntity<byte[]> 타입 end */
	
	
	
	
}



























