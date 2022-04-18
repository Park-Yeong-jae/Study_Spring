package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getBoardList(int startNum, int endNum);
	public int getTotalBoard();
	public int boardWrite(BoardDTO dto);
	public BoardDTO boardView(int seq);
	public int updateHit(int seq);
	public int boardDelete(int seq);
}
