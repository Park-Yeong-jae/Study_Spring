package book.service;

import java.util.List;

import book.bean.BookVO;

public interface BookService {
	// 입력
	public int insertBook(BookVO vo);
	// 목록 출력
	public List<BookVO> getBookList();
}
