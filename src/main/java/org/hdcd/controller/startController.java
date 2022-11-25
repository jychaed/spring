package org.hdcd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class startController {
	
	private static final Logger logger = LoggerFactory.getLogger(startController.class);
	
	//문제풀어 보기
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String start() {
		logger.info("start");
		return "test1124/start";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView start(@RequestParam String userId, String userName) {
		logger.info("start");
		logger.info("userId : " + userId);
		logger.info("userName : " + userName);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("userName", userName);
		mav.setViewName("test1124/main1");
		return mav;
	}
	
	@RequestMapping(value = "/myBox", method = RequestMethod.GET)
	public ModelAndView myBox() {
		logger.info("myBox");
		String DATA_DIRECTORY = "D:\\A_TeachingMaterial\\08_Framework\\02.SPRING2\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\DevProject\\resources\\mybox";
		File dir = new File(DATA_DIRECTORY);

		String[] filenames = dir.list();
		for (String filename : filenames) {
			System.out.println("filename : " + filename);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("filenames", filenames);
		mav.setViewName("test1124/myBox");
		return mav;
		    
	}
	
//	@RequestMapping(value = "/myGallery", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> myGallery(){
//		logger.info("myGallery");
//		InputStream in = null;
//		ResponseEntity<byte[]> entity = null;
//		
//		HttpHeaders headers = new HttpHeaders();
//		try {
//			in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\02.SPRING2\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\DevProject\\resources\\mybox");
//			headers.setContentType(MediaType.IMAGE_JPEG);
//			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
//			e.printStackTrace();
//		}
//		
//		return entity;
//		
//	} // 시도해보았으나 실패
	
	@RequestMapping(value = "/myGallery", method = RequestMethod.GET)
	public ModelAndView myGallery() {
		ModelAndView mav = new ModelAndView();

		String dir = "D:\\A_TeachingMaterial\\08_Framework\\02.SPRING2\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\DevProject\\resources\\mybox\\image";
		File file = new File(dir);
		List<String> fileList = new ArrayList<String>();
		String[] filenames = file.list();
		for (String filename : filenames) {
			fileList.add(filename);
		}
		
		mav.setViewName("test1124/myGallery");
	    mav.addObject("fileList",fileList);
		return mav;
	}
	
	@RequestMapping(value = "/myGallery", method = RequestMethod.GET)	
	public ResponseEntity<byte[]> myGalleryDown() throws Exception{
		logger.info("myGalleryDown");
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
	
}
