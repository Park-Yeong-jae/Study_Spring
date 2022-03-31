package book.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import book.bean.BookVO;
import book.service.BookService;

@Component
public class Test {
	@Autowired
	BookService bookService;
	Scanner sc = new Scanner(System.in);

	// 메뉴
	public void menu() {
		while (true) {
			int x = 0;
			System.out.println("1. 도서등록");
			System.out.println("2. 도서 목록 출력");
			System.out.println("3. 종료");
			System.out.println("-----------");
			System.out.print("번호 : ");
			x = sc.nextInt();
			System.out.println();

			switch (x) {
			case 1:
				insert();
				break;
			case 2:
				list();
				break;
			case 3:
				System.out.println(" ** 종료합니다 ** ");
				return;
			}
			System.out.println();
		}
	}

	private void insert() {
		BookVO vo = new BookVO();
		System.out.print("도서코드 : ");
		vo.setBook3_code(sc.next());
		System.out.print("도서명 : ");
		vo.setBook3_name(sc.next());
		System.out.print("저자 : ");
		vo.setBook3_author(sc.next());
		System.out.print("출판사 : ");
		vo.setBook3_publisher(sc.next());
		System.out.print("가격 : ");
		vo.setBook3_price(sc.nextInt());
		System.out.print("출판일 : ");
		vo.setBook3_date(sc.next());
		
		int result = bookService.insertBook(vo);
		
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
	}

	private void list() {
		List<BookVO> list = bookService.getBookList();
		
		if(list.size() > 0) {
			for(BookVO vo1 : list) {
				System.out.println(vo1.toString());
			}
		} else {
			System.out.println("출력할 정보가 없습니다");
		}
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("bean.xml");

		Test test = (Test) context.getBean("test");
		test.menu();
		
		context.close();
	}
}










