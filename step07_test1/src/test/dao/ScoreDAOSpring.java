package test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;


@Repository("dao")
public class ScoreDAOSpring {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// CRUD 기능의 메소드
	// SQL 명령어들
	String SCORE_INSERT="insert into score values(?,?,?,?,?,?,?,sysdate)";
	String SCORE_UPDATE="update score set kor=?, eng=?, mat=?, tot=?, avg=? where studNo=?";
	String SCORE_DELETE="delete score where studNo=?";
	String SCORE_LIST="select * from score order by studNo asc";
	
	// 1) insert
	public int insertScore(ScoreVO vo) {
		//방법 1
		//return jdbcTemplate.update(SCORE_INSERT, vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg());
		
		//방법 2
		Object[] args = {vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg()};
		return jdbcTemplate.update(SCORE_INSERT, args);
	}
	
	// 2) update
	public int updateScore(ScoreVO vo) {
		Object[] args = {vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg(), vo.getStudNo()};
		return jdbcTemplate.update(SCORE_UPDATE, args);
	}
	
	// 3) delete
	public int deleteScore(ScoreVO vo) {
		return jdbcTemplate.update(SCORE_DELETE, vo.getStudNo());
	}
	
	// 4) list
	public List<ScoreVO> getScoreList() {
		return jdbcTemplate.query(SCORE_LIST, new ScoreRowMapper());
	}
}
