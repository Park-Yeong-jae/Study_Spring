package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 목록
	public List<BoardDTO> getBoardList(int startNum, int endNum) {
		// 매개변수가 여러개 일경우에는 Map 클래스에 저장해서 사용함
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.boardMapper.getBoardList", map);
	}

	// 총 데이터 갯수
	public int getTotalBoard() {
		return sqlSession.selectOne("mybatis.boardMapper.getTotalBoard");
	}

	// 상세보기
	public BoardDTO boardView(int seq) {
		return sqlSession.selectOne("mybatis.boardMapper.boardView", seq);
	}

	// 글저장
	public int boardWrite(BoardDTO dto) {
		return sqlSession.insert("mybatis.boardMapper.boardWrite", dto);
	}

	// 조회수 증가
	public int updateHit(int seq) {
		return sqlSession.update("mybatis.boardMapper.updateHit", seq);
	}

	// 글삭제
	// delete board where seq=1
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.boardMapper.boardDelete", seq);
	}
}
