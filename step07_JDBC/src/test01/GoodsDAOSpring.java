package test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class GoodsDAOSpring {
	@Autowired
	JdbcTemplate jdbcTemplate;

	// SQL 명령어들
	String GOODS_INSERT = "insert into goods values (?, ?, ?, ?)";
	String GOODS_UPDATE = "update goods set name=?, price=?, maker=? " + " where code=?";
	String GOODS_DELETE = "delete goods where code=?";
	String GOODS_GET = "select * from goods where code=?";
	String GOODS_LIST = "select * from goods order by code asc";

	// CRUD 기능의 메소드
	// 1. 책등록
	public int insertGoods(GoodsVO vo) {
		// 방법1
		//return jdbcTemplate.update(GOODS_INSERT, vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker());
		// 방법2
		Object[] args = {vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker()};
		return jdbcTemplate.update(GOODS_INSERT, args);
	}
	
	// 2. 책수정
	public int updateGoods(GoodsVO vo) {
		Object[] args = {vo.getName(), vo.getPrice(), vo.getMaker(), vo.getCode()};
		return jdbcTemplate.update(GOODS_UPDATE, args);
	}
	
	// 3. 책삭제
	public int deleteGoods(GoodsVO vo) {
		return jdbcTemplate.update(GOODS_DELETE, vo.getCode());
	}
	
	// 4. 책 상세 조회
	public GoodsVO getGoods(GoodsVO vo) {
		Object[] args = {vo.getCode()};
		return jdbcTemplate.queryForObject(GOODS_GET, args, new GoodsRowMapper());
	}
	
	// 5. 책 목록 조회
	public List<GoodsVO> getGoodsList() {
		return jdbcTemplate.query(GOODS_LIST, new GoodsRowMapper());
	}
}