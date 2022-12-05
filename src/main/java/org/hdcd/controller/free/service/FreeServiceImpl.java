package org.hdcd.controller.free.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.mapper.FreeBoardmapper;
import org.hdcd.vo.Board;
import org.springframework.stereotype.Service;

@Service
public class FreeServiceImpl implements IFreeService {
	
	@Inject
	private FreeBoardmapper mapper;

	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);
		
	}

	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}

	@Override
	public Board read(int boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	@Override
	public void update(Board board) throws Exception {
		mapper.update(board);
	}

	@Override
	public void delete(int boardNo) throws Exception {
		mapper.delete(boardNo);
		
	}	
}
