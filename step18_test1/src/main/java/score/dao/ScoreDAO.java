package score.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import score.bean.ScoreDTO;

@Repository
public class ScoreDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 저장 
	public int insertScore(ScoreDTO dto) {		
		return sqlSession.insert("mybatis.scoreMapper.insertScore", dto);
	}
	// 삭제
	public int deleteScore(String studNo) {		
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", studNo);
	}
	// 상세보기
	public ScoreDTO getScore(String studNo) {		
		return sqlSession.selectOne("mybatis.scoreMapper.getScore", studNo);
	}
	// 목록보기
	public List<ScoreDTO> getScoreList(int startNum, int endNum) {		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList", map);
	}
	// 총 데이터수 구하기
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.scoreMapper.getTotalA");
	}
	
	// 성적 수정
	public int updateScore(ScoreDTO dto) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", dto);
	}
}









