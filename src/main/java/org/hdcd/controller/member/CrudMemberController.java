package org.hdcd.controller.member;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.controller.member.service.IMemberService;
import org.hdcd.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/crud/member")
public class CrudMemberController {

	
	private static Logger logger = LoggerFactory.getLogger(CrudMemberController.class);
	
	@Inject
	private IMemberService service;
	
	// 회원 등록 페이지
	// 초기에는 사용자지만 하나의 등급이지만 수정할때는 등급을 수정할 수 있게 한명의 사용자가 3개의 등급을 가질 수 있다?
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String crudmemberRegisterForm(MemberVO member, Model model) {
		model.addAttribute("member", member);
		return "crud/member/register";
	}
	
	// 회원 등록 기능
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String crudmemberRegister(MemberVO member, Model model) throws Exception {
		service.register(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "crud/member/success";
	}
	
	// 회원 목록 페이지
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String crudmemberList(Model model) throws Exception {
		List<MemberVO> memberList =  service.list(); //public interface IMemberService  여기로 이동
		model.addAttribute("list", memberList);
		return "crud/member/list";
	}
	
	// 회원 상세 화면 페이지
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String crudMemberRead(int userNo, Model model) throws Exception {
		MemberVO member = service.read(userNo); //public interface IMemberService  여기로 이동
		model.addAttribute("member", member);
		return "crud/member/read";
	}
	
	// 회원 수정 페이지
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String crudMemberModifyForm(int userNo, Model model) throws Exception {
		MemberVO member = service.read(userNo); //public interface IMemberService  여기로 이동 //  유저 회원에 해당하는 정보넘겨줘!
		model.addAttribute("member", member);
		return "crud/member/modify";
	}
	
	// 회원 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String crudMemberModify(MemberVO member, Model model) throws Exception {
		service.modify(member); //public interface IMemberService  여기로 이동 
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "crud/member/success";
	}
	
	// 회원 삭제
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String crudMemberDelete(int userNo, Model model) throws Exception {
		service.remove(userNo); //public interface IMemberService  여기로 이동 
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "crud/member/success";
	}
	
	
	
	
	
	
	
}
