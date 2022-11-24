package org.hdcd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 객체면 json데이터로 호출
@Controller
public class RestHomeController {
	private static final Logger logger = LoggerFactory.getLogger(RestHomeController.class);
	
	
	@RequestMapping(value = "/goRestHome0301")
	public Member restHome0301() {
		logger.info("restHome0301");
		Member member = new Member();
		return member;
	}
	
	// 반환값이 컬렉션 List 타입이면 JSON 객체 배열 타입으로 자동으로 변환된다.
	@RequestMapping(value = "/goRestHome0401")
	public List<Member> restHome0401(){
		logger.info("restHome0401");
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		list.add(member);
		
		Member member2 = new Member();
		list.add(member2);
		
		return list;
	}
	
	@RequestMapping(value = "/goRestHome0501", method = RequestMethod.GET)
	public Map<String, Member> restHome0501(){
		logger.info("goHome0501");
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		map.put("member1", member);
		
		Member member2 = new Member();
		map.put("member2", member2);
		
		return map;
		
	}
	
	@RequestMapping(value = "/goRestHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> restHome0601(){
		logger.info("restHome0601");
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/goRestHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> restHome0701(){
		logger.info("restHome0701");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome0801", method = RequestMethod.GET)
	public ResponseEntity<Member> restHome0801(){
		logger.info("restHome0801");
		Member member = new Member();
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome0901", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> restHome0901(){
		logger.info("restHome0901");
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		list.add(member);
		
		Member member2 = new Member();
		list.add(member2);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome1001", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Member>> restHome1001(){
		logger.info("restHome1001");
		
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		map.put("key1", member);
		
		Member member2 = new Member();
		map.put("key2", member2);
		
		return new ResponseEntity<Map<String, Member>>(map, HttpStatus.OK);
	}
	
	
}
