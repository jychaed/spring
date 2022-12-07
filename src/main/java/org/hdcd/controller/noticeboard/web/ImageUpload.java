package org.hdcd.controller.noticeboard.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@Controller
public class ImageUpload {
   
   @RequestMapping(value = "/imageUpload.do")
   public String imageUpload(
		 MultipartHttpServletRequest multiFile, //multiFile 내가넘긴 이미지 파일 받음
         HttpServletRequest req,
         HttpServletResponse resp) throws Exception {
      JsonObject json = new JsonObject();
      PrintWriter printWriter = null;
      OutputStream out = null;
      
      long limitSize = 1024 * 1024 * 2; //2MB // 이게 이미지 사이즈
      MultipartFile file = multiFile.getFile("upload"); //upload 이키로 사진 이미지를 보냄 MultipartFile호 반환함
      if(file!=null && file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) { // 여러 필터를 걸었음 파일명이 비어있지 않다면?
         if(file.getContentType().toLowerCase().startsWith("image/")) { // 해당 파일의 타입이 이미지 일때만 처리하고 시퍼 이미지 파일 맞아? 어 맞아
            if(file.getSize() > limitSize) { // 위 2개 걸쳐서 넘어오지 / 고화질 파일만 용량을 가용하다보면 메모리가 계속 차서 서버터짐 //  아래 이미지 제한 가이드를 빼준거
               JsonObject jsonMsg = new JsonObject();
               JsonArray jsonArr = new JsonArray();
               jsonMsg.addProperty("message", "2MB미만의 이미지만 업로드 가능합니다");
               jsonArr.add(jsonMsg);
               json.addProperty("uploaded", 0);
               json.add("error", jsonArr.get(0));
               resp.setCharacterEncoding("UTF-8");
               printWriter = resp.getWriter();
               printWriter.println(json);
            }else { // 적정이미지일때 여기 돌아요
               try {
                  String fileName = file.getName();
                  byte[] bytes = file.getBytes();
                  String uploadPath = req.getServletContext().getRealPath("/resources/img"); //여기서 폴더 관리할ㄱㅔ
                  File uploadFile = new File(uploadPath);// 우선 폴더 있는지 확인하고 만드는 로직
                  if(!uploadFile.exists()) {
                	  uploadFile.mkdirs();
                  }
                  
                  fileName = UUID.randomUUID().toString(); // 파일명을 랜덤한 문자열을 만들어서  그녀석을 이용해서 파일명 만들고
                  uploadPath = uploadPath + "/" + fileName + ".jpg"; // 경로 이름해서
                  out = new FileOutputStream(new File(uploadPath)); // 여기서 처리함
                  out.write(bytes);
                  
                  printWriter = resp.getWriter(); // 이제 바깥으로 빼야하는 데 이미지 테그 만들엉줌
                  resp.setContentType("text/html");
                  // 최종 획득된 업로드한 이미지 경로 (URL)
                  String fileUrl = req.getContextPath() + "/resources/img/" + fileName + ".jpg";
                  
                  json.addProperty("uploaded", 1); //1 업로드가 됬다
                  json.addProperty("fileName", fileName); // uuid이녀석
                  json.addProperty("url", fileUrl);
                  
                  printWriter.println(json);
               }catch (Exception e) {
            	   if( out != null ) out.close();
            	   if( printWriter != null ) printWriter.close();
               }
            }
         }
      }
      return null;
   }
}