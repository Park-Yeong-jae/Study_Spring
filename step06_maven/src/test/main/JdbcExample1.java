package test.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.GoodsVO;
import test.service.GoodsService;

public class JdbcExample1 {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
		
		GoodsService goodService = (GoodsService) context.getBean("goodsService");
		
		// 1. 책 등록 기능 테스트
		GoodsVO vo = new GoodsVO();
		vo.setCode("p0002");
		vo.setName("Java");
		vo.setPrice(20000);
		vo.setMaker("햇님출판사");
		
		int result = goodService.insertGoods(vo);
		
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		
		// 2. 책 목록 검색 기능 테스트
		List<GoodsVO> list = goodService.getGoodsList();
		for(GoodsVO vo1 : list) {
			System.out.println(vo.toString());
		}
		
		context.close();
	}
}
