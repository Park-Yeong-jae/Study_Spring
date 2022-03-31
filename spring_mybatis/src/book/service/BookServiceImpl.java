package book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.dao.BookDAO;
import book.bean.BookVO;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO dao;
	
	@Override
	public int insertBook(BookVO vo) {
		return dao.insertBook(vo);
	}

	@Override
	public List<BookVO> getBookList() {
		return dao.getBookList();
	}

}
