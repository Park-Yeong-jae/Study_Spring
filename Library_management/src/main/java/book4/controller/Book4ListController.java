package book4.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import book4.bean.Book4DTO;
import book4.dao.Book4DAO;

public class Book4ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리 코드
		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		// 목록 : 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		Book4DAO dao = new Book4DAO();
		List<Book4DTO> list = dao.getBook4List(startNum, endNum);

		// 페이징 : 3블럿
		int totalA = dao.getTotalBook4(); // 총 데이터 갯수
		int totalP = (totalA + 4) / 5; // 총 페이지 수

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if (endPage > totalP)
			endPage = totalP;

		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 2-1. 공유데이터 저장
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		// 2-2. view처리 파일명 저장
		modelAndView.setViewName("book4List.jsp");
		return modelAndView;
	}

}
