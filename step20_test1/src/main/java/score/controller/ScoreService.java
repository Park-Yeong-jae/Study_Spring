package score.controller;

import java.util.List;

import score.bean.ScoreDTO;

public interface ScoreService {
	public int insertScore(ScoreDTO dto);
	public ScoreDTO getScore(String studNo);
	public List<ScoreDTO> getScoreList(int startNum, int endNum);
	public int getTotalA();
	public int updateScore(ScoreDTO dto);
	public int deleteScore(String studNo);
}
