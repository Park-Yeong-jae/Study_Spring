package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	// 1. insert
	public int insertScore(ScoreVO vo);
	// 2. update
	public int updateScore(ScoreVO vo);
	// 3. delete
	public int deleteScore(ScoreVO vo);
	// 4. list
	public List<ScoreVO> getScoreList();
}
