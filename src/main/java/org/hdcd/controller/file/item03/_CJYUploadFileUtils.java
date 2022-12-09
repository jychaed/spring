package org.hdcd.controller.file.item03;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class _CJYUploadFileUtils {
	
	private static Logger logger = LoggerFactory.getLogger(_CJYUploadFileUtils.class);
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		// UUID를 이용해서  uploadFile 이름을 랜덤으로 지정할꺼야
		UUID uuid = UUID.randomUUID();
		
		// uuid랑 _랑 진짜 originalName 합쳐서 savedName생성
		String savedName = uuid.toString() + "_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = savedPath.replace(File.separatorChar, '/') + "/" + savedName;
		
		if(MediaUtils.getMediaType(formatName) != null) {
			makeThumbnail(uploadPath, savedPath, savedName);
		}
		return uploadedFileName;
	}

	// 2022/12/03/s_afsljfhkas fhksahfjkhsadjkfhsajf_원본파일명 파일생성
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		// DecimalFormat("00") : 두자리에서 빈자리는 0으로 채움
		String monthPath = yearPath+ File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) +1);
		String datePath = monthPath+ File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);
		
		return datePath;
	}
	
	// 각각의 폴더들을 만들어주는 함수인거 메소드죠
	// 가변인자
	// 키워드'...'을 사용한다.
	// [사용법] 타입...변수명 형태로 사용
	// 순서대로 yearPath, monthPath, datePath가 배열로 들어와 처리
	private static void makeDir(String uploadPath, String...paths) { //String...paths가변변수
		if(new File(paths[paths.length - 1]).exists()) {
			return;
		}
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			if(!dirPath.exists()) {
				dirPath.mkdirs();
			}
		}
		
	}
	
	private static void makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		// Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100); 이미지를 바꾼다 변환한다 리사이징한다.
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		// 이걸 이용해서 썸네일이미지를 만들어냄 
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") +1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		
	}
	
	
	
}
