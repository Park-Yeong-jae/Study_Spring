package test02;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcExample1 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean2.xml");

		GoodsService goodsService = (GoodsService) context.getBean("goodsService");

		// 1. 책 등록 기능 테스트
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0002");
		vo.setName("Java");
		vo.setPrice(20000);
		vo.setMaker("햇님출판사");

		int result = goodsService.insertGoods(vo);

		if (result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}

		// 2. 책 목록 검색 기능 테스트
		List<GoodsVO> list = goodsService.getGoodsList();
		for (GoodsVO vo1 : list) {
			System.out.println(vo1.toString());
		}

		context.close();
	}
}
