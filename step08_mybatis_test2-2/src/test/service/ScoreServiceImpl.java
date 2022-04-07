package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	ScoreDAOSpring dao;

	@Override
	public int insertScore(ScoreVO vo) {
		return dao.insertScore(vo);
	}

	@Override
	public List<ScoreVO> getScoreList() {
		return dao.getScoreList();
	}

	@Override
	public ScoreVO getScore(String studNo) {
		return dao.getScore(studNo);
	}

	@Override
	public int updateScore(ScoreVO vo) {
		return dao.updateScore(vo);
	}

	@Override
	public int deleteScore(String studNo) {
		return dao.deleteScore(studNo);
	}

}
