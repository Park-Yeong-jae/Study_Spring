package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.GoodsVO;
import test.dao.GoodsDAO;

// <bean id="goodsService" class="test.service.GoodsServiceImpl">
// <property name="dao" ref="dao"/>
// </bean> 와 동일한 설정
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired	//setter 생략가능
	GoodsDAO dao;
	
	@Override
	public int insertGoods(GoodsVO vo) {
		return dao.insertGoods(vo);
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		return dao.updateGoods(vo);
	}

	@Override
	public int deleteGoods(GoodsVO vo) {
		return dao.deleteGoods(vo);
	}

	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		return dao.getGoods(vo);
	}

	@Override
	public List<GoodsVO> getGoodsList() {
		return dao.getGoodsList();
	}
}
