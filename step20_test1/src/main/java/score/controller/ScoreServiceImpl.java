package score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	private ScoreDAO dao;

	@Override
	public int insertScore(ScoreDTO dto) {
		return dao.insertScore(dto);
	}

	@Override
	public ScoreDTO getScore(String studNo) {
		return dao.getScore(studNo);
	}

	@Override
	public List<ScoreDTO> getScoreList(int startNum, int endNum) {
		return dao.getScoreList(startNum, endNum);
	}

	@Override
	public int getTotalA() {
		return dao.getTotalA();
	}

	@Override
	public int updateScore(ScoreDTO dto) {
		return dao.updateScore(dto);
	}

	@Override
	public int deleteScore(String studNo) {
		return dao.deleteScore(studNo);
	}

}
