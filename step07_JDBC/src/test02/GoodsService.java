package test02;

import java.util.List;

public interface GoodsService {
	// 1. 책등록
	public int insertGoods(GoodsVO vo);
	// 2. 책수정
	public int updateGoods(GoodsVO vo);
	// 3. 책삭제
	public int deleteGoods(GoodsVO vo);
	// 4. 책 상세 조회
	public GoodsVO getGoods(GoodsVO vo);
	// 5. 책 목록 조회
	public List<GoodsVO> getGoodsList();
}
