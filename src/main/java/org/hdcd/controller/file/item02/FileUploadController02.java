package org.hdcd.controller.file.item02;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.hdcd.controller.file.item01.service.ItemService;
import org.hdcd.controller.file.item02.service.ItemService2;
import org.hdcd.vo.Item2;
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
@RequestMapping("/item2")
public class FileUploadController02 {
	/*
	 * 13장. 파일 업로드 20221208
	 * 
	 * 3. 여러 개의 이미지 업로드
	 * 	- 한 번에 여러 개의 이미지를 업로드하는 파일 업로드 기능을 구현한다.
	 * 		
	 * 		데이터베이스만들기
	 * 		- item2 테이블 생성
	 * 
	 * 		1. 파일업로드 구현 설명
	 * 			- 파일업로드 등록 화면 컨트롤러 만들기(FileUploadController02)
	 * 			- 파일업로드 등록 화면 컨트롤러 메소드 만들기(item2RegisterForm:get)
	 * 			- 파일업로드 등록 화면 만들기 (item2/register.jsp)
	 * 			- 			여기까지 확인
	 * 			- 파일업로드 등록 기능 컨트롤러 메소드 만들기(item2Register:post)
	 * 			- 파일업로드 등록 기능 서비스 인터페이스 메소드 만들기
	 * 			- 파일업로드 등록 기능 서비스 클래스 메소드 만들기
	 * 			- 파일업로드 등록 기능 Mapper 인터페이스 메소드 만들기
	 * 			- 파일업로드 등록 기능 Mapper xml 쿼리 만들기
	 * 			- 파일업로드 등록 완료 페이지 만들기 
	 * 			- 			여기까지 확인
	 * 			- 파일업로드 목록 기능 컨트롤러 메소드 만들기(item2List:get)
	 * 			- 파일업로드 목록 기능 서비스 인터페이스 메소드 만들기
	 * 			- 파일업로드 목록 기능 서비스 클래스 메소드 만들기
	 * 			- 파일업로드 목록 기능 Mapper 인터페이스 메소드 만들기
	 * 			- 파일업로드 목록 기능 Mapper xml 쿼리 만들기
	 * 			- 파일업로드 목록 완료 페이지 만들기  (item2/list.jsp)
	 * 			- 			여기까지 확인
	 * 			- 파일업로드 수정 화면 컨트롤러 메소드 만들기(item2ModifyForm:get)
	 * 			- 파일업로드 수정 화면 서비스 인터페이스 메소드 만들기
	 * 			- 파일업로드 수정 화면 서비스 클래스 메소드 만들기
	 * 			- 파일업로드 수정 화면 Mapper 인터페이스 메소드 만들기
	 * 			- 파일업로드 수정 화면 Mapper xml 쿼리 만들기
	 * 			- 파일업로드 수정 완료 페이지 만들기  (item2/modify.jsp)
	 * 
	 * 			- 파일업로드 수정 기능 컨트롤러 메소드 만들기(item2ModifyForm:post)
	 * 			- 파일업로드 수정 기능 서비스 인터페이스 메소드 만들기
	 * 			- 파일업로드 수정 기능 서비스 클래스 메소드 만들기
	 * 			- 파일업로드 수정 기능 Mapper 인터페이스 메소드 만들기
	 * 			- 파일업로드 수정 기능 Mapper xml 쿼리 만들기
	 * 			- 			여기까지 확인
	 * 
	 * 			- 파일업로드 삭제 화면 컨트롤러 메소드 만들기(item2RemoveForm:get)
	 * 			- 파일업로드 삭제 화면 서비스 인터페이스 메소드 만들기
	 * 			- 파일업로드 삭제 화면 서비스 클래스 메소드 만들기
	 * 			- 파일업로드 삭제 화면 Mapper 인터페이스 메소드 만들기
	 * 			- 파일업로드 삭제 화면 Mapper xml 쿼리 만들기
	 * 
	 * 			- 파일업로드 삭제 기능 컨트롤러 메소드 만들기(item2RemoveForm:post)
	 * 			- 파일업로드 삭제 기능 서비스 인터페이스 메소드 만들기
	 * 			- 파일업로드 삭제 기능 서비스 클래스 메소드 만들기
	 * 			- 파일업로드 삭제 기능 Mapper 인터페이스 메소드 만들기
	 * 			- 파일업로드 삭제 기능 Mapper xml 쿼리 만들기
	 * 			- 			여기까지 확인 (끝)
	 * 
	 * 
	 * 
	 */
	
	
	private static Logger logger = LoggerFactory.getLogger(FileUploadController02.class);
	
	@Resource(name = "uploadPath") // c드라이브 업로드 폴더 있죠 그거 써먹고 주입받아서 쓰는거 네임 받고 아래 변수명은 마음대로 가능
	private String uploadPath; // 변수명 자유
	
	@Inject
	private ItemService2 itemService; // 파일업로드 등록 기능 서비스 인터페이스 만들기
	
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
	public String item2RegisterForm(Model model) {
		model.addAttribute("item", new Item2());
		return "item2/register";
	}
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String item2Register(Item2 item, Model model) throws Exception {
		List<MultipartFile> pictures = item.getPictures();
		
		for(int i = 0; i < pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			
			logger.info("getOriginalFilename : " + file.getOriginalFilename());
			logger.info("getSize : " + file.getSize());
			logger.info("getContentType : " + file.getContentType());
			
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			
			if(i == 0) {
				item.setPictureUrl(savedName);
			}else if(i == 1) {
				item.setPictureUrl2(savedName);
			}
		}
		
		itemService.register(item); 
		model.addAttribute("msg", "등록이 완료 되었습니다.");
		return "item2/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String item2List(Model model) throws Exception {
		List<Item2> itemList = itemService.list();
		model.addAttribute("itemList", itemList);
		return "item2/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String item2ModifyForm(int itemId, Model model) throws Exception {
		Item2 item = itemService.read(itemId);
		model.addAttribute("item", item);
		return "item2/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String item2Modify(Item2 item, Model model) throws Exception {
		List<MultipartFile> pictures = item.getPictures();
		
		for(int i = 0 ; i < pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			
			if(file != null && file.getSize() > 0) {
				logger.info("getOriginalFilename :" + file.getOriginalFilename());
				logger.info("getSize :" + file.getSize());
				logger.info("getContentType :" + file.getContentType());
				
				// 넘겨 받은 파일을 이용하여 파일 업로드(복사)를 진행한다.
				// return : UUID + '_' + 파일원본명
				String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
				if(i == 0) {
					item.setPictureUrl(createdFileName);
				}else if (i == 1) {
					item.setPictureUrl2(createdFileName);
				}
			}
		}
		itemService.modify(item);
		model.addAttribute("msg", "수정이 완료되었습니다");
		return "item2/success";
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
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}finally {
				in.close();
			}
			return entity;
		}
		
		// 파일업로드 수정 화면 이미지 미리보기 기능 만들기(displayFile)
		@ResponseBody
		@RequestMapping(value = "/display2")
		public ResponseEntity<byte[]> displayFile2(int itemId) throws Exception{
			InputStream in = null;
			ResponseEntity<byte[]> entity = null;
			
			String fileName = itemService.getPicture2(itemId);
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
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}finally {
				in.close();
			}
			return entity;
		}
		
		@RequestMapping(value = "/remove", method = RequestMethod.GET)
		public String item2RemoveForm(int itemId, Model model) throws Exception{
			Item2 item = itemService.read(itemId);
			model.addAttribute("item", item);
			return "item2/remove";
		}
		
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		public String item2RemoveForm(Item2 item, Model model) throws Exception{
			itemService.remove(item.getItemId());
			model.addAttribute("msg", "삭제가 완료되었습니다.");
			return "item2/success";
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
		
		private String uploadFile(String originalName, byte[] fileData) throws Exception{
			UUID uuid = UUID.randomUUID();
			String createFileName = uuid.toString() + "_" + originalName;
			File target = new File(uploadPath, createFileName);
			FileCopyUtils.copy(fileData, target);
			return createFileName;
			
		}
		
	
	
	
	
}











