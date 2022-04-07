package test02;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertGoods(GoodsVO vo) {
		return sqlSession.insert("mybatis.goodsMapper.insertGoods", vo);
	}
	
	public int updateGoods(GoodsVO vo) {
		return sqlSession.update("mybatis.goodsMapper.updateGoods", vo);
	}
	
	public int deleteGoods(GoodsVO vo) {
		return sqlSession.delete("mybatis.goodsMapper.deleteGoods", vo);
	}
	
	public GoodsVO getGoods(GoodsVO vo) {
		return sqlSession.selectOne("mybatis.goodsMapper.getGoods", vo);
	}
	
	public List<GoodsVO> getGoodsList() {
		return sqlSession.selectList("mybatis.goodsMapper.getGoodsList");
	}
}






