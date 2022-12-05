package org.hdcd.controller.member.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.mapper.MemberMapper;
import org.hdcd.vo.MemberAuth;
import org.hdcd.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {
	
	@Inject
	private MemberMapper mapper;
	
	@Override
	public void register(MemberVO member) throws Exception {
		mapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER"); // 기본 사용자 등급
		mapper.createAuth(memberAuth);

	}

	@Override
	public List<MemberVO> list() throws Exception { // 빨간줄떠서 재정의함!
		return mapper.list(); // public interface MemberMapper  여기로 이동
	}

	@Override
	public MemberVO read(int userNo) throws Exception { // 빨간줄떠서 재정의함!
		return mapper.read(userNo);  // public interface MemberMapper  여기로 이동
	}

	@Override
	public void modify(MemberVO member) throws Exception {
		mapper.update(member);
		
		int userNo = member.getUserNo();
		mapper.deleteAuth(userNo);
		List<MemberAuth> authList = member.getAuthList();
		
		for(int i = 0; i< authList.size(); i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			if(auth == null) {
				continue;
			}
			if(auth.trim().length() == 0) {
				continue;
			}
			memberAuth.setUserNo(userNo);
			mapper.createAuth(memberAuth);
		}
		
	}

	@Override
	public void remove(int userNo) throws Exception {
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
		
	}

}
