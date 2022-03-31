package book.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import book.bean.BookVO;

@Repository("dao")
public class BookDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 도서 입력
	public int insertBook(BookVO vo) {
		return sqlSession.insert("mybatis.bookMapper.insertBook", vo);
	}
	// 도서 목록 출력
	public List<BookVO> getBookList() {
		return sqlSession.selectList("mybatis.bookMapper.getBookList");
	}
}
