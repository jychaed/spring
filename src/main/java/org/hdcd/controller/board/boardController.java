package org.hdcd.controller.board;

import java.util.Date;
import java.util.Map;

import org.hdcd.vo.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger Logger = LoggerFactory.getLogger(BoardController.class);
	/*
	 * 1. 요청 경로 매핑
	 * @RequestMapping(value = "/board/register")
	 * @RequestMapping(value = "/board/modify")
	 * @RequestMapping(value = "/board/list")
	 * 
	 * 해당 경로로 요청시, 페이지를 리턴하는 부분이 없기 때문에 404 에러가 발생하는 걸로 생각되나
	 * 스프링 View Resolver라는 녀석이 리턴된 페이지 Name이 존재하지 않는 경우,
	 * 요청된 url을 가지고 매핑정보로 삼아 페이지를 찾아서 앞에는 '/WEB-INF/views/' 를 뒤에는 '.jsp'를 붙여서
	 * 페이지 정보를 찾아 응답 리소스 데이터를 구성하여 응답 데이터로 리턴합니다.
	 */
	
//	@RequestMapping({"/register" , "/hello"})
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() { 
		Logger.info("registerForm() 실행...!");
		return "success";
	} 
	/*
		리턴이 없는데 페이지가 나오는 이유는? 해당 board안에 register
		D:\A_TeachingMaterial\08_Framework\02.SPRING2\workspace\DevProject\src\main\webapp\WEB-INF\spring\appServlet\servlet-context.xml
		여기서 알아서 해줌 뷰 리졸버가 알아서 찾아줌
		해당 url 찍힘!
	 */
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerFormPost() { 
		Logger.info("registerFormPost() 실행...!");
		return "success";
	} 
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyForm() {
		Logger.info("modifyForm() 실행...!");
		return "success";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyFormPost() {
		Logger.info("modifyFormPost() 실행...!");
		return "success";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove() {
		Logger.info("remove() 실행...!");
		return "success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		Logger.info("list() 실행...!");
		return"success";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(String keyword, Model model) {
		Logger.info("search() 실행...!");
		model.addAttribute("keyword", keyword);
		return "board/search";
	}
	
	@RequestMapping(value = "/read/{boardNo}") // 이녀석이 게시글 번호로 들어온다면 컨트롤 가능
	public String read(@PathVariable int boardNo) { // 값으로 받아서 경로안에 설정합니다.
		Logger.info("read boardNo : " + boardNo);
		return "board/read";
	}// 내가 넘긴 넘버 값이 들어옴! http://localhost/board/read/222 이런식으로 하면 리턴됨!
	
	
	//---------------------------------------------------------------------------------------------------
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "register")
	public String registerParamsGet() {
		Logger.info("registerParamsGet() 실행...!");
		return "board/register";
	}
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "register")
	public String registerParamsPost() {
		Logger.info("registerParamsPost() 실행...!");
		return "board/list";
	}
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "modify")
	public String modifyParamsGet() {
		Logger.info("modifyParamsGet() 실행...!");
		return "board/modify";
	}
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "modify")
	public String modifyParamsPost() {
		Logger.info("modifyParamsPost() 실행...!");
		return "board/modify";
	}
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "remove")
	public String removeParamsGet() {
		Logger.info("removeParamsGet() 실행...!");
		return "board/remove";
	}
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "remove")
	public String removeParamsPost() {
		Logger.info("removeParamsPost() 실행...!");
		return "board/remove";
	}
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "list")
	@GetMapping(value = "/get" , params = "list")
	public String listParamsGet() {
		Logger.info("listParamsGet() 실행...!");
		return "board/list";
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "read")
	public String readParamsGet() {
		Logger.info("readParamsGet() 실행...!");
		return "board/read";
	}

	
	// ==============5. Header 매핑 ========================
	// 1)
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyAjax(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		Logger.info("Headers 매핑 : modifyAjax" );
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// url 이 {boardNo} 값으로 오는데 이 안에서 받기 위한 도구가 필요함 
	// 어노테이션 중에 @PathVariable 이거를 매핑되면{boardNo} = ("boardNo")같은것 인식
	// int boardNo => 내가 설정한 그 값이 변수 에 들어감 int boardNo 이건 그냥 변수 명임!!! 바꿀수 있음 ({boardNo} = ("boardNo") 이때만가능
	
	// 요청을 보낼때 제이슨데이터를 담아서 url 경로로 날렸죠 Board라는 객체에 매핑시킬려고!
	// @RequestBody 이거를 통해서 자동 바인딩 되도록 해주는 도구
	// 헤더와 바디 영역이 있는데 아작스 데이타 날릴때 바디라는 영역에 데이터가 만들어져서 날라옴
	// 너가 바디 영역에 만들 데이터를 보드라는 객체에 그 아작스의 키로 설정해서 담아줄께 
	
	//ResponseEntity 응답을 내보낼껀데 파일데이터를 업로드하고 업로드된 파일은 리솔스라던지 객체같은 타입을 담아서
	// 파일 다운로드 만들거야 응답 데이터로 값을 리턴할 때 사용합니다. 제네릭이 스트링이니 결과 값("SUCCESS")을 출력하고 있는데
	// 상태가 200? 400? 404? 뭐야 그 응답 정상으로 보내기 위해서 HttpStatus.OK로 내보내는 것
	// 아작스에서 성공이면 만든 석세스 부분이 리졸트로 받게 되겠지 그 값이 진짜 같으면 알럿띄워죠 라고 설정해둠 
	
	// 2)
	// Headers 매핑을 이용한 PUT 통신
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyAjaxByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		Logger.info("Headers 매핑 : modifyAjaxByHeader" );
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	// ResponseEntity 이 응답데이터로 String 보내는데 보내는 것이 타입이 여러개 인데 여기에 어떤 값으로 매핑해서 내보내는지 
	// 거기에서 응답을 뭐로 보낼지 응답하는 거! 내가 SUCCESS문자열로 보내고HttpStatus.OK 상태코드를 보여줌
	// 이 응답을 아작스에서 만든 석세스 부분이 리졸트로 받게 되겠지 그 값이 진짜 같으면 알럿띄워죠 라고 설정해둠 
	
	
	// ==============6. Content-Type 매핑 ========================
	// 1)
	// 요청 본문의 미디어 타입을 지정하지 않으면 기본값이 "application/json" 미디어 타입으로 지정됩니다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.POST)
	public ResponseEntity<String> modifyContentTypePost(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		Logger.info("Content-Type 매핑 : modifyContentTypePost" );
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 2)
	// contentType 매핑을 이용한 PUT 통신 (json)
	// consumes 속성값에 "application/json" 미디어 타입을 지정한다.
	// 요청에서 설정한 ContentType으로 설정한 설정값 "application/json" 타입을 받기 위한 속성
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "application/json") //consumes 아작스에서 컨텍트 타입 받을때 사용하는 것
	public ResponseEntity<String> modifyContentTypeByJson(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		Logger.info("Content-Type 매핑 : modifyContentTypeByJson" );
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 3)
	// contentType 매핑을 이용한 PUT 통신(xml)
	// consumes 속성값에 "application/xml" 미디어 타입을 지정한다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "application/xml") 
	public ResponseEntity<String> modifyContentTypeByXml(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		Logger.info("Content-Type 매핑 : modifyContentTypeByXml" );
		Logger.info("modifyContentTypeByXm : boardNo " + boardNo );
		Logger.info("modifyContentTypeByXm : board " + board );
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	
	// ==============7. Accept 매핑 ========================
	// 1.
	// produces 속성값을 지정하지 않으면 기본값이 "application/json" 미디어 타입으로 지정된다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<Board> readAccept(@PathVariable("boardNo") int boardNo){
		Logger.info("read" );
		Board board = new Board();
		board.setTitle("제목입니다1");
		board.setContent("내용입니다1");
		board.setWriter("작성자입니다1");
		board.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
		
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo, Board board){
		Logger.info("readToJson" );
		
		String addStr = "_json";
		Board boardVO = new Board();
		boardVO.setTitle("제목" + addStr);
		boardVO.setContent("내용" + addStr);
		boardVO.setWriter("작성자" + addStr);
		boardVO.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(boardVO, HttpStatus.OK);
		return entity;
		
	}
	
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo, Board board){
		Logger.info("readToXml" );
		
		String addStr = "_xml";
		Board boardVO = new Board();
		boardVO.setTitle("제목" + addStr);
		boardVO.setContent("내용" + addStr);
		boardVO.setWriter("작성자" + addStr);
		boardVO.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(boardVO, HttpStatus.OK);
		return entity;
		
	}
	
	
	//------------------------------------------------------------------------------------------------
	
//	@RequestMapping(value = "/hello", method = RequestMethod.GET ,params = {"id","pw"})
//	public ResponseEntity<String> hello(@RequestParam Map<String,Object>map){
//		Logger.info("id: " + map.get("id") + ", pw: " + map.get("pw"));
//		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		return entity;
//	}
//	
//	
//	 @GetMapping("/register") // 너 둘중 뭐받을꺼야? Cannot map 'boardController' method  찾을 수 없어 // Ambiguous mapping. 모호해 매핑~ 오마이갓
//	 public String registerForm (@RequestParam int id,@RequestParam int pw) {
//		 Logger.info("registerForm() 실행...!");
//		 Logger.info("id = " +id);
//		 Logger.info("pw = " +pw);
//		 return "success";
//	  }
//
	
	/// 수정해보기 

}

















