package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.Board;

public interface BoardMapper {
	// 여기 있는 함수를 매핑해서 사용 
	public void create(Board board) throws Exception;

	public List<Board> list() throws Exception;

	public Board read(int boardNo) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(int boardNo) throws Exception;

	public List<Board> search(String title) throws Exception;
	
	
	
	
}
