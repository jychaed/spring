package org.hdcd.controller.free;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.controller.board.service.IBoardService;
import org.hdcd.controller.free.service.IFreeService;
import org.hdcd.vo.Board;
import org.hdcd.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/crud/free")
public class CrudFreeController {

	private static Logger logger = LoggerFactory.getLogger(CrudFreeController.class);

	@Inject
	private IFreeService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String crudRegisterForm() {
		logger.info("crudRegisterForm");
		return "crud/free/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String crudRegister(Board board, Model model) throws Exception { 
		logger.info("crudRegister");
		service.register(board);

		if(board.getBoardNo() > 0) { 	
			return "redirect:/crud/free/read?boardNo=" + board.getBoardNo();
		}

		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "crud/free/success";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String crudList(Model model) throws Exception {		
		logger.info("crudList");
		List<Board> boardList = service.list();
		model.addAttribute("list", boardList);
		return "crud/free/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String crudRead(@RequestParam("boardNo") int boardNo, Model model) throws Exception {		
		logger.info("crudRead");
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		return "crud/free/read";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String crudModifyForm(int boardNo, Model model) throws Exception {		
		logger.info("crudModifyForm");
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		model.addAttribute("status", "u");
		return "crud/free/register";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String crudModify(Board board, Model model) throws Exception {		
		logger.info("crudModify");
		service.update(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "crud/free/success";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String crudDelete(@RequestParam("boardNo") int boardNo, Model model) throws Exception {		
		logger.info("crudDelete");
		service.delete(boardNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "crud/free/success";
	}

}
