package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO dao;

	@Override
	public List<BoardDTO> getBoardList(int startNum, int endNum) {
		return dao.getBoardList(startNum, endNum);
	}
	@Override
	public int getTotalBoard() {
		return dao.getTotalBoard();
	}
	@Override
	public int boardWrite(BoardDTO dto) {
		return dao.boardWrite(dto);
	}
	@Override
	public BoardDTO boardView(int seq) {
		return dao.boardView(seq);
	}
	@Override
	public int updateHit(int seq) {
		return dao.updateHit(seq);
	}
	@Override
	public int boardDelete(int seq) {
		return dao.boardDelete(seq);
	}
}
