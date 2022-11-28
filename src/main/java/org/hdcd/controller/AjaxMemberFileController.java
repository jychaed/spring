package org.hdcd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ajax")
public class AjaxMemberFileController {
	
	private static Logger logger = LoggerFactory.getLogger(AjaxMemberFileController.class);
	
	//10. 파일 업로드 Ajax 방식 요청 처리
	//파일 업로드 아작스 방식 요청 처리 시작 페이지
	@RequestMapping(value = "/registerFileForm", method = RequestMethod.GET)
	public String ajaxRegisterFileForm() {
		return "member/ajaxRegisterFile";
	}
	
	@RequestMapping(value = "uploadAjax",  method = RequestMethod.POST, produces ="text/plain; charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file){
		String originalFilename = file.getOriginalFilename();
		logger.info("originalFilename" + originalFilename);
		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS", HttpStatus.OK);
		return entity; 
	}
	
}
