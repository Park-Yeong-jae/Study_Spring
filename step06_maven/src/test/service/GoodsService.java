package test.service;

import java.util.List;

import test.bean.GoodsVO;

public interface GoodsService {
	// 1) 책 등록 : insert
	public int insertGoods(GoodsVO vo);
		
	//2) 책 수정 : update
	public int updateGoods(GoodsVO vo);
	
	// 3) 책 삭제 : delete
	public int deleteGoods(GoodsVO vo);
		
	// 4) 책 상세 조회
	public GoodsVO getGoods(GoodsVO vo);
		
	// 5) 책 목록 조회
	public List<GoodsVO> getGoodsList();
}
