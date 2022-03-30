package book4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import book4.bean.Book4DTO;
import book4.dao.Book4DAO;

public class Book4WriteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		// 1. 데이터 처리 코드
		String book4_code = request.getParameter("book4_code");
		String book4_name = request.getParameter("book4_name");
		String book4_author = request.getParameter("book4_author");
		String book4_publisher = request.getParameter("book4_publisher");
		int book4_price = Integer.parseInt(request.getParameter("book4_price"));
		String book4_date = request.getParameter("book4_date");

		Book4DTO dto = new Book4DTO();
		dto.setBook4_code(book4_code);
		dto.setBook4_name(book4_name);
		dto.setBook4_author(book4_author);
		dto.setBook4_publisher(book4_publisher);
		dto.setBook4_price(book4_price);
		dto.setBook4_date(book4_date);

		Book4DAO dao = new Book4DAO();
		int result = dao.book4Write(dto);

		// 2. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 2-1. 공유데이터 저장
		modelAndView.addObject("result", result);
		// 2-2. view 처리 파일명 저장
		modelAndView.setViewName("book4Write.jsp");
		return modelAndView;
	}

}
