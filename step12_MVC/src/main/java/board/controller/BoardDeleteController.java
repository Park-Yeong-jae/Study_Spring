package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/* 1. 데이터 처리 */
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// db
		BoardDAO dao = new BoardDAO();
		int result = dao.boardDelete(seq);
		
		/* 2. 화면 네비게이션 */
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("result", result);
		
		return "boardDelete";
	}

}
