package org.hdcd.controller.noticeboard.view;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.web.servlet.view.AbstractView;

public class NoticeDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> noticeFileMap = (Map<String, Object>) model.get("noticeFileMap");
		
		File saveFile = new File(noticeFileMap.get("fileSavepath").toString());
		String filename = (String) noticeFileMap.get("fileName");
		String agent = request.getHeader("User-Agent");
		if (StringUtils.containsIgnoreCase(agent, "trident")) {
			filename = URLEncoder.encode(filename, "UTF-8");	// IE, Chrome
		}else {
			filename = new String(filename.getBytes(), "ISO-8859-1"); 	// firefox, chrome
		}
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
		response.setHeader("Content-Length", noticeFileMap.get("fileSize").toString());
		// 향상된 try...
		try (
			OutputStream os = response.getOutputStream();
		){ 
			FileUtils.copyFile(saveFile, os);
		}
		
	}

}
