package test.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import test.bean.GoodsVO;
import test.service.GoodsService;

import java.util.List;

public class JdbcExample2 {
    public static void printResult(GoodsVO vo, int result){
        System.out.println("** " + vo.getCode() + " 삭제 시도 중... **");
        if( result > 0){
            System.out.println("제품이 삭제되었습니다.");
        } else {
            System.out.println("제품 삭제 실패");
        }
        System.out.println("-------------");
    }

    public static void printList(String title, List<GoodsVO> list){
        System.out.println("** " + title + " **");
        for(GoodsVO vo : list){
            System.out.println(vo.toString());
        }
        System.out.println("--------------");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");
        
        GoodsService service = (GoodsService) context.getBean("goodsService");
        
        // 삭제 전
        List<GoodsVO> list = service.getGoodsList();
        printList("삭제전", list);

        // 삭제 기능 테스트
        GoodsVO successVO = new GoodsVO();
        successVO.setCode("p0001");
        int result = service.deleteGoods(successVO);
        printResult(successVO, result);

        GoodsVO failVO = new GoodsVO();
        failVO.setCode("asdfasdf");
        result = service.deleteGoods(failVO);
        printResult(failVO, result);


        // 목록 기능 테스트
        list = service.getGoodsList();
        printList("삭제 후", list);

        context.close();
    }


}