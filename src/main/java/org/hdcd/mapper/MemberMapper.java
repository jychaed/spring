package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.MemberAuth;
import org.hdcd.vo.MemberVO;

public interface MemberMapper {
	public void create(MemberVO member) throws Exception;
	public void createAuth(MemberAuth memberAtuth) throws Exception;
	public List<MemberVO> list() throws Exception; // 이녀석과 매핑될 쿼리만들러! memberMapper_SQL.xml
	public MemberVO read(int userNo) throws Exception; // 이녀석과 매핑될 쿼리만들러! memberMapper_SQL.xml
	public void update(MemberVO member) throws Exception; // 이녀석과 매핑될 쿼리만들러! memberMapper_SQL.xml
	public void deleteAuth(int userNo) throws Exception; // 이녀석과 매핑될 쿼리만들러! memberMapper_SQL.xml
	public void delete(int userNo) throws Exception;
}
