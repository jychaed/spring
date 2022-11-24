package org.hdcd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
	
	@RequestMapping(value = "/myGallery", method = RequestMethod.GET)
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
	
}
