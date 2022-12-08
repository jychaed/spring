package org.hdcd.controller.ajax;

import java.util.List;
import java.util.Map;

import org.hdcd.vo.Merong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 리플렉션 어노테이션 쓰면 알아서 올려서 매칭시켜줘
@Controller
@RequestMapping("/ajax")
public class AjaxTest { // 20221208
	
	@GetMapping("/test")		// get은 보통 사용자 요청화면이나, 리스트를 처리할 때 사용 / 관공서 신청페이지 화면을 보여주는!
	public String getAjax() {
		return "ajaxTest";
	}
	
	@PostMapping(value = "/getTest", produces = "text/plain;charset=utf-8" )
	@ResponseBody		// ajax 요청 URL엔 이거이 꼬옥 있어야함, response.getWriter
	public String ajaxPost(@RequestBody Map<String, String> aVO) { // jsp에서 어플리케이션JSON 넘긴 데이터는 파라미터로 받아야함! 일반적으로 문자열로 처리!
		System.out.println(aVO.get("name"));
		System.out.println(aVO.get("age"));
		return "완존 메롱";
	}
	
	@PostMapping(value = "/getTest2", produces = "application/json;charset=utf-8" )
	@ResponseBody		// ajax 요청 URL엔 이거이 꼬옥 있어야함, response.getWriter
	public List<String> ajaxPost2(@RequestBody List<String> bVO) { // jsp에서 어플리케이션JSON 넘긴 데이터는 파라미터로 받아야함! 일반적으로 문자열로 처리!
		for(String str : bVO) {
			System.out.println(str);
		}
		return bVO;
	}
	
	// 아작스 요청은 전부 안 헷갈리겡 @RequestBody만 쓴당!
	@PostMapping(value = "/getTest3", produces = "application/json;charset=utf-8" )
	@ResponseBody		// ajax 요청 URL엔 이거이 꼬옥 있어야함, response.getWriter
	public List<Map<String, String>> ajaxPost3(@RequestBody List<Map<String, String>> cVO) { 
		for(Map<String, String> merong : cVO) {
			System.out.println(merong.get("name"));
			System.out.println(merong.get("age"));
			System.out.println("====================");
		}
		return cVO;
	}
	
	@PostMapping(value = "/getTest4", produces = "application/json;charset=utf-8" )
	@ResponseBody		// ajax 요청 URL엔 이거이 꼬옥 있어야함, response.getWriter
	public Map<String, Object> ajaxPost4(@RequestBody Map<String, Object> dVO) { 
		
		System.out.println(dVO.get("name"));
		@SuppressWarnings("unchecked") // 강제형변환 괜찮아! 문제없다 서프래스?워닝? 맞나
		List<String> idols = (List<String>)dVO.get("idols");
		for (String str : idols) { //forea 하고 자동완성
			System.out.println(str);
		}
		
		return dVO;
	}
	
	@PostMapping(value = "/getTest5", produces = "application/json;charset=utf-8" )
	@ResponseBody		// ajax 요청 URL엔 이거이 꼬옥 있어야함, response.getWriter
	public Merong ajaxPost5(@RequestBody Merong eVO) { 
		
		System.out.println("👑==>" + eVO); //자동 toString 불림!
		
		return eVO;
	}
	
}
