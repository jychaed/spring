package org.hdcd.controller.file.item01;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.hdcd.controller.file.item01.service.ItemService;
import org.hdcd.vo.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/item")
public class FileUploadController01 {
	/*
	 *  13장 파일업로드  20221208
	 *  
	 *   1. 파일 업로드 설명
	 *   - 서블릿 3.0 에서 지원하는 파일 업로드 기능과 스프링 웹에서 제공하는 컴포넌트를 사용하여 파일을 업로드한다.
	 *   
	 *   	파일 업로드 설정
	 *   	1) 서블릿 3.0이상 지원
	 *   	2) 서블릿 표준 파일 업로드 기능을 활성화
	 *   	3) 스프링 MVC와 연계
	 *   	4) 업로드된 파일 저장 위치 설정
	 *   
	 *   	환경설정
	 *   	1) 의존 관계 정의
	 *   	- 파일을 처리하기 위해서 의존 라이브러리를 추가한다.
	 *   		>  pom.xml commons-io 추가 		// D:\A_TeachingMaterial\08_Framework\02.SPRING2\workspace\DevProject\pom.xml
	 *   	2) 웹 컨테이너 설정
	 *   		> web.xml 서블릿 표준 버전 3.1로 설정 		// D:\A_TeachingMaterial\08_Framework\02.SPRING2\workspace\DevProject\src\main\webapp\WEB-INF\web.xml
	 *   		> multipart-config 활성화
	 *   	3) 스프링 웹 설정
	 *   		> serlet-context.xml 		// D:\A_TeachingMaterial\08_Framework\02.SPRING2\workspace\DevProject\src\main\webapp\WEB-INF\spring\appServlet\servlet-context.xml
	 *   		> multipartResolver Bean 등록
	 *   	
	 *   	데이터 베이스 준비
	 *   	1) item 테이블 생성   // 오라클 DB구축 , VO생성 => D:\A_TeachingMaterial\08_Framework\02.SPRING2\workspace\DevProject\src\main\java\org\hdcd\vo\Item.java
	 *   
	 *   2. 이미지 업로드
	 *   - 한 개의 이미지를 업로드하는 기본 파일 업로드 기능을 구현합니다.
	 *   
	 *   	1. 파일 업로드 구현 설명
	 *   		- 파일업로드 등록 화면 컨트롤러 만들기(FileUploadController01)
	 *   		- 파일업로드 등록 화면 컨트롤러 메소드 만들기(itemRegisterForm:get)
	 *   		- 파일업로드 등록 화면 만들기(item/register.jsp)
	 *   		- 			여기까지 확인
	 *   		- 파일업로드 등록 기능 컨트롤러 메소드 만들기(itemRegisterForm:post)
	 *   		- 파일업로드 등록 기능 서비스 인터페이스 만들기
	 *   		- 파일업로드 등록 기능 클래스 메소드 만들기
	 *   		- 파일업로드 등록 기능 Mapper 인터페이스 만들기
	 *   		- 파일업로드 등록 기능 Mapper xml 쿼리 만들기
	 *   		- 파일업로드 등록 완료 페이지 만들기(item/success.jsp)
	 *   		- 			여기까지 확인
	 *   		- 파일업로드 목록 화면 컨트롤러 메소드 만들기 (itemList:get)
	 *   		- 파일업로드 목록 화면 서비스 인터페이스 메소드 만들기
	 *   		- 파일업로드 목록 화면 클래스 메소드 만들기
	 *   		- 파일업로드 목록 화면 Mapper 인터페이스 메소드 만들기
	 *   		- 파일업로드 목록 화면 Mapper xml 쿼리 만들기
	 *   		- 파일업로드 목록 완료 페이지 만들기(item/list.jsp)
	 *   		- 			여기까지 확인
	 *   		- 파일업로드 수정 화면 컨트롤러 메소드 만들기 (itemModifyForm:get)
	 *   		- 파일업로드 수정 화면 서비스 인터페이스 만들기
	 *   		- 파일업로드 수정 화면 클래스 메소드 만들기
	 *   		- 파일업로드 수정 화면 Mapper 인터페이스 메소드 만들기
	 *   		- 파일업로드 수정 화면 Mapper xml 쿼리 만들기
	 *   		- 파일업로드 수정 화면 페이지 만들기(item/modify.jsp)
	 *   		- 			여기까지 확인
	 *   		- 파일업로드 수정 기능 컨트롤러 메소드 만들기 (itemModify:post)
	 *   		- 파일업로드 수정 기능 서비스 인터페이스 메소드 만들기
	 *   		- 파일업로드 수정 기능 클래스 메소드 만들기
	 *   		- 파일업로드 수정 기능 Mapper 인터페이스 메소드 만들기
	 *   		- 파일업로드 수정 기능 Mapper xml 쿼리 만들기
	 *   		- 파일업로드 수정 화면 이미지 미리보기 기능 만들기(displayFile)
	 *   		- 			여기까지 확인
	 *   		
	 */
	
	
	private static Logger logger = LoggerFactory.getLogger(FileUploadController01.class);
	
	@Resource(name = "uploadPath") // c드라이브 업로드 폴더 있죠 그거 써먹고 주입받아서 쓰는거 네임 받고 아래 변수명은 마음대로 가능
	private String uploadPath; // 변수명 자유
	
	@Inject
	private ItemService itemService; // 파일업로드 등록 기능 서비스 인터페이스 만들기
	
	// 파일 업로드 등록화면
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String itemRegisterForm(Model model) {
		model.addAttribute("item", new Item());
		return "item/register";
	} // 여기까지 만들고 파일업로드 등록 화면 만들기(item/register.jsp)
	
	// 파일 업로드 등록화면
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String itemRegister(Item item,  Model model) throws Exception {
		MultipartFile file = item.getPicture();
		
		logger.info("originalName : " + file.getOriginalFilename());
		logger.info("size : " + file.getSize());
		logger.info("contentType : " + file.getContentType());
		
		String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		
		item.setPictureUrl(createdFileName);
		itemService.register(item);
		model.addAttribute("msg", "등록이 완료 되었습니다.");
		return "item/success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String itemList(Model model) throws Exception{
		List<Item> itemList = itemService.list();
		model.addAttribute("itemList", itemList);
		return "item/list";
	}
	
	//파일업로드 수정 화면 컨트롤러
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String itemModifyForm(int itemId, Model model) throws Exception {
		Item item = itemService.read(itemId);
		model.addAttribute("item", item);
		return "item/modify";
		
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String itemModify(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();
		
		if(file != null && file.getSize() > 0) {
			logger.info("getOriginalFilename :" + file.getOriginalFilename());
			logger.info("getSize :" + file.getSize());
			logger.info("getContentType :" + file.getContentType());
			
			// 넘겨 받은 파일을 이용하여 파일 업로드(복사)를 진행한다.
			// return : UUID + '_' + 파일원본명
			String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
			item.setPictureUrl(createdFileName);
			
		}
		itemService.modify(item);
		model.addAttribute("msg", "수정이 완료되었습니다");
		return "item/success";
		
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String itemRemove(int itemId, Model model) throws Exception {
		Item item = itemService.read(itemId);
		model.addAttribute("item", item);
		return "item/remove";
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String itemRemove(Item item, Model model) throws Exception {
		
		itemService.remove(item.getItemId());
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "item/success";
		
	}
	
	
	// 파일업로드 수정 화면 이미지 미리보기 기능 만들기(displayFile)
	@ResponseBody
	@RequestMapping(value = "/display")
	public ResponseEntity<byte[]> displayFile(int itemId) throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = itemService.getPicture(itemId);
		logger.info("FILE NAME : " + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1); //확장자추출
			MediaType mType = getMediaType(formatName); // 확장자 추가
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + File.separator + fileName);
			
			if(mType != null) {
				headers.setContentType(mType);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			in.close();
		}
		return entity;
	}
	
	public MediaType getMediaType(String formatName) {
		if(formatName != null) {
			if(formatName.toUpperCase().equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}else if(formatName.toUpperCase().equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}else if(formatName.toUpperCase().equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
		}
		return null;
	}
	
	
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID();	//UUID로 파일명 생성
		String createdFileName = uuid.toString() + "_" + originalName;
		File target = new File(uploadPath, createdFileName);	// 파일 업로드 (복사) 준비
		FileCopyUtils.copy(fileData, target);// 파일 업로드 (복사) 진행
		
		return createdFileName;
	}
	
	
	
	
	
	
	
}
