package org.hdcd.controller.member.service;

import java.util.List;

import org.hdcd.vo.MemberVO;

public interface IMemberService {
	public void register(MemberVO member) throws Exception;

	public List<MemberVO> list() throws Exception; // 이거하면 MemberServiceImpl.java 이 오류가 남! 가자!

	public MemberVO read(int userNo) throws Exception;  // 이거하면 MemberServiceImpl.java 이 오류가 남! 가자!

	public void modify(MemberVO member) throws Exception;  // 이거하면 MemberServiceImpl.java 이 오류가 남! 가자!

	public void remove(int userNo) throws Exception;

	
}
