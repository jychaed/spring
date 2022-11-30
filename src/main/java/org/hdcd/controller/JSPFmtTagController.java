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
	
	// 6) type 속성을 date로 지정하여 날짜 포맷팅을 한다
	@RequestMapping(value = "/home0301", method = RequestMethod.GET)
	public String home0301(Model model) {
		logger.info("home0301");
		Date now = new Date();
		model.addAttribute("now", now);
		return "home/fmttag/home0301";
	}
	
	// 7) type 속성을 time으로 지정하여 시간 포맷팅을 한다
	@RequestMapping(value = "/home0302", method = RequestMethod.GET)
	public String home0302(Model model) {
		logger.info("home0302");
		Date now = new Date();
		model.addAttribute("now", now);
		return "home/fmttag/home0302";
	}
	
	// 8) type 속성을 both로 지정하여 날짜, 시간 포맷팅을 한다
	@RequestMapping(value = "/home0303", method = RequestMethod.GET)
	public String home0303(Model model) {
		logger.info("home0303");
		Date now = new Date();
		model.addAttribute("now", now);
		return "home/fmttag/home0303";
	}
	
	// 9) pattern 속성을 지정하여 날짜를 포맷팅한다
	@RequestMapping(value = "/home0304", method = RequestMethod.GET)
	public String home0304(Model model) {
		logger.info("home0304");
		Date now = new Date();
		model.addAttribute("now", now);
		return "home/fmttag/home0304";
	}
	
	// 10) dateStyle 속성을 지정하지 않으면 기본값은 default이다.
	@RequestMapping(value = "/home0401", method = RequestMethod.GET)
	public String home0401(Model model) {
		logger.info("home0401");
		String dateValue = "2020.10.20";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0401";
	}
	
	// 11) dateStyle 속성을 short로 지정하여 문자열을 Date객체로 변환한다
	@RequestMapping(value = "/home0402", method = RequestMethod.GET)
	public String home0402(Model model) {
		logger.info("home0402");
		String dateValue = "19. 2. 1";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0402";
	}
	
	// 12) dateStyle 속성을 medium로 지정하여 문자열을 Date객체로 변환한다
	@RequestMapping(value = "/home0403", method = RequestMethod.GET)
	public String home0403(Model model) {
		logger.info("home0403");
		String dateValue = "2020. 2. 1";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0403";
	}
	
	// 13) dateStyle 속성을 long로 지정하여 문자열을 Date객체로 변환한다
	@RequestMapping(value = "/home0404", method = RequestMethod.GET)
	public String home0404(Model model) {
		logger.info("home0404");
		String dateValue = "2019년 2월 1일 (금)"; // 띄어쓰기 안맞으면 500에러남
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0404";
	}
	
	// 14) dateStyle 속성을 full로 지정하여 문자열을 Date객체로 변환한다
	@RequestMapping(value = "/home0405", method = RequestMethod.GET)
	public String home0405(Model model) {
		logger.info("home0405");
		String dateValue = "2019년 2월 1일 금요일";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0405";
	}
	
	// 15) pattern 속성을 지정하여 문자열을 Date객체로 변환한다
	@RequestMapping(value = "/home0406", method = RequestMethod.GET)
	public String home0406(Model model) {
		logger.info("home0406");
		String dateValue = "22022-02-01 15:00:24";
		model.addAttribute("dateValue", dateValue);
		return "home/fmttag/home0406";
	}
	
	
		
		
		
}





