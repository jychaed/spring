package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.Board;

public interface FreeBoardmapper {

	void create(Board board) throws Exception;

	List<Board> list() throws Exception;

	Board read(int boardNo) throws Exception;

	void update(Board board) throws Exception;

	void delete(int boardNo) throws Exception;

}
