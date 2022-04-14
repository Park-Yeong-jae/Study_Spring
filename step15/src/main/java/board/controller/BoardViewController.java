package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardViewController{

	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		BoardDAO dao = new BoardDAO();
		dao.updateHit(seq);	// 조회수 증가

		BoardDTO dto = dao.boardView(seq); 
		
		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("boardView.jsp");
		
		return modelAndView;
	}

}
