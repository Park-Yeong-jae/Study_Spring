package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;

public class BoardDeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		// db
		BoardDAO dao = new BoardDAO();
		int result = dao.boardDelete(seq);

		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;
	}

}
