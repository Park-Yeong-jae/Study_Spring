package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		BoardDAO dao = new BoardDAO();

		// 파라미터 파싱
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));

		// DB
		dao.updateHit(seq);  // 조회수 증가
		BoardDTO dto = dao.boardView(seq);

		// 2. 화면 네비게이션 = 데이터 공유 + view 처리 파일 선택
		// 파라미터 공유
		request.setAttribute("pg", pg);
		request.setAttribute("seq", seq);
		request.setAttribute("dto", dto);
			
		return "boardView";		
	}

}
