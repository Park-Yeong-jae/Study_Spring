package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

public class ScoreDAOSpring {
	private SqlSession sqlSession;
	
	public ScoreDAOSpring() {
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}
	
	public int insertScore(ScoreVO vo) {
		return sqlSession.insert("mybatis.scoreMapper.insertScore", vo);
	}

	public List<ScoreVO> getList() {
		return sqlSession.selectList("mybatis.scoreMapper.getList");
	}

	public int updateScore(ScoreVO vo) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", vo);
	}

	public int deleteScore(ScoreVO vo) {
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", vo);
	}
}
