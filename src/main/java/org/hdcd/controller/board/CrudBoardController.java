package org.hdcd.controller.board;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.controller.board.service.IBoardService;
import org.hdcd.vo.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/crud/board")
public class CrudBoardController {//20221202
	
	private static Logger logger = LoggerFactory.getLogger(CrudBoardController.class);
	
	@Inject
	private IBoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String crudRegisterForm() {
		logger.info("crudRegisterForm");
		return "crud/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String crudRegister(Board board, Model model) throws Exception { // Board board 매개변수를 사용해서 매핑!
		logger.info("crudRegister");
		service.register(board);
		
		if(board.getBoardNo() > 0) {	// 초기가 아닌 ㅎㅎ 0이상의 번호일때! 상세보기로!
			return "redirect:/crud/board/read?boardNo=" + board.getBoardNo();
		}
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "crud/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String crudList(Model model) throws Exception {		
		logger.info("crudList");
		List<Board> boardList = service.list();
		model.addAttribute("list", boardList);
		return "crud/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String crudRead(@RequestParam("boardNo") int boardNo, Model model) throws Exception {		
		logger.info("crudRead");
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		return "crud/read";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String crudModifyForm(int boardNo, Model model) throws Exception {		
		logger.info("crudModifyForm");
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		model.addAttribute("status", "u");
		return "crud/register";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String crudModify(Board board, Model model) throws Exception {		
		logger.info("crudModify");
		service.update(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "crud/success";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String crudDelete(@RequestParam("boardNo") int boardNo, Model model) throws Exception {		
		logger.info("crudDelete");
		service.delete(boardNo);
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "crud/success";
	}
	
	// 20221205 검색기능 추가
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String crudSearch(@RequestParam("title") String title, Model model) throws Exception {		
		logger.info("crudSearch");
		
		Board board = new Board();
		board.setTitle(title);
		
		List<Board> boardlist =  service.search(title); // 타이틀에 해당하는 게시글을 보내주겠지 // public interface IBoardService 가자
		
		model.addAttribute("board", board);
		model.addAttribute("list", boardlist);
		return "crud/list";
	}
	
	
	
}









