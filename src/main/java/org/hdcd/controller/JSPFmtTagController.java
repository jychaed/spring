package org.hdcd.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/fmttag")
@Controller
public class JSPFmtTagController {
	
	private static final Logger logger = LoggerFactory.getLogger(JSPFmtTagController.class);
	
	/*
	 * 7. 숫자 및 날짜 포맷팅 처리 태그 pdf 257
	 * - 숫자 및 날짜의 포맥팅과 관련된 태그입니다.
	 */
	
	// 1) type 속성을 지정하거나 pattern 속성을 지정하여 숫자를 형식화한다.
	@RequestMapping(value = "/home0101", method = RequestMethod.GET)
	public String home0101(Model model) {
		logger.info("home0101");
		int coin  = 100;
		model.addAttribute("coin", coin);
		return "home/fmttag/home0101";
	}
		
	// 2) type 속성을 지정 되지 않으면 기본값은 number입니다.
	@RequestMapping(value = "/home0201", method = RequestMethod.GET)
	public String home0201(Model model) {
		logger.info("home0201");
		int coin  = 1000;
		model.addAttribute("coin", coin);
		return "home/fmttag/home0201";
	}
	
	// 3) type 속성이 currency 입니다.
	@RequestMapping(value = "/home0202", method = RequestMethod.GET)
	public String home0202(Model model) {
		logger.info("home0202");
		String coin  = "￦1,000";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0202";
	}
	
	// 4) type 속성이 percent 입니다.
	@RequestMapping(value = "/home0203", method = RequestMethod.GET)
	public String home0203(Model model) {
		logger.info("home0203");
		String coin  = "1000%";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0203";
	}
	
	// 5) pattern 속성을 사용하여 직접 사용할 서식을 지정한다
	@RequestMapping(value = "/home0204", method = RequestMethod.GET)
	public String home0204(Model model) {
		logger.info("home0204");
		String coin  = "1,000.25";
		model.addAttribute("coin", coin);
		return "home/fmttag/home0204";
	}
	
	
		
		
		
}





